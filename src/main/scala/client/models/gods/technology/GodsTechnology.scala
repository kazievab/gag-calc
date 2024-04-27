package client.models.gods.technology

import client.models.gods.technology.extensions._
import client.utils.localization.TFunction
import io.circe.generic.JsonCodec

import java.util.UUID
import java.util.concurrent.TimeUnit

@JsonCodec
case class GodsTechnology(
  id: UUID,
  title: String,
  description: String,
  godType: GodType,
  researchIds: Seq[Int] = Seq.empty[Int],
  version: Int = GodsTechnology.version,
  godLevel: Int = 5,
  skinType: Option[SkinType] = None,
  citadelTitle: Option[CitadelTitle] = None,
  universityLevel: UniversityLevel = UniversityLevel.`35`,
  vipLevel: Option[VipLevel] = Some(VipLevel.`20`),
  librarionLevel: Option[LibrarionLevel] = Some(LibrarionLevel.`5`),
  boostResearch: BoostResearch = BoostResearch(),
  developmentResearch: DevelopmentResearch = DevelopmentResearch(),
  allianceResearch: AllianceResearch = AllianceResearch(),
  allianceSubscription: Boolean = true,
  ageOfScience: Boolean = true,
  rings: Boolean = true,
  additionalParameters: AdditionalParameters = AdditionalParameters()
) {
  def allianceSubscriptionResearchSpeed: Double = if (allianceSubscription) 0.05 else 0
  def ageOfScienceResearchSpeed: Double = if (ageOfScience) 0.25 else 0
  def ringsResearchSpeed: Double = if (rings) 0.0625 else 0

  def researchSpeed: Double = Seq(
    GodsTechnology.baseResearchSpeed,
    skinType.map(_.researchSpeed).getOrElse(0D),
    citadelTitle.map(_.researchSpeed).getOrElse(0D),
    universityLevel.researchSpeed,
    vipLevel.map(_.researchSpeed).getOrElse(0D),
    librarionLevel.map(_.researchSpeed).getOrElse(0D),
    boostResearch.researchSpeed,
    developmentResearch.researchSpeed,
    allianceResearch.researchSpeed,
    allianceSubscriptionResearchSpeed,
    ageOfScienceResearchSpeed,
    ringsResearchSpeed,
    additionalParameters.researchSpeed
  ).sum

  def speedResearchCost: ResearchCost = ResearchCost.createAcceleration(researchSpeed)

  def librarionResearchCost: Double = librarionLevel.map(_.researchCost).getOrElse(0)
  def ageOfScienceGoldResearchCost: Double = if (ageOfScience) 0.3 else 0

  private def preWoodResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    librarionResearchCost,
    developmentResearch.woodResearchCost,
    skinType.map(_.woodResearchCost).getOrElse(0D),
    additionalParameters.woodResearchCost
  ).sum

  def woodResearchCost: ResearchCost = ResearchCost.createResource(preWoodResearchCost, GodsTechnology.minResearchCost)

  private def preGoldResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    ageOfScienceGoldResearchCost,
    librarionResearchCost,
    developmentResearch.goldResearchCost,
    skinType.map(_.goldResearchCost).getOrElse(0D),
    additionalParameters.goldResearchCost
  ).sum

  def goldResearchCost: ResearchCost = ResearchCost.createResource(preGoldResearchCost, GodsTechnology.minResearchCost)

  private def preStoneResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    librarionResearchCost,
    developmentResearch.stoneResearchCost,
    skinType.map(_.stoneResearchCost).getOrElse(0D),
    additionalParameters.stoneResearchCost
  ).sum

  def stoneResearchCost: ResearchCost = ResearchCost.createResource(preStoneResearchCost, GodsTechnology.minResearchCost)

  def preStardustResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    librarionResearchCost,
    developmentResearch.stardustResearchCost,
    skinType.map(_.stardustResearchCost).getOrElse(0D),
    additionalParameters.stardustResearchCost
  ).sum

  def stardustResearchCost: ResearchCost =
    ResearchCost.createResource(preStardustResearchCost, GodsTechnology.minResearchCost)

  lazy val researchRequirements: Seq[ResearchRequirements] =
    if (researchIds.isEmpty) ResearchRequirements.default
    else ResearchRequirements.default.filter(entity => researchIds.contains(entity.id))

  lazy val totalTimeResearchCost: Double = researchRequirements.map(_.seconds).sum
  lazy val totalWoodResearchCost: Double = researchRequirements.map(_.wood).sum.toDouble
  lazy val totalGoldResearchCost: Double = researchRequirements.map(_.gold).sum.toDouble
  lazy val totalStoneResearchCost: Double = researchRequirements.map(_.stone).sum.toDouble
  lazy val totalStardustResearchCost: Double = researchRequirements.map(_.stardust).sum.toDouble

  lazy val currentTimeResearchCost: Double = TimeUnit.SECONDS.toDays((totalTimeResearchCost / researchSpeed).toLong)
  lazy val currentWoodResearchCost: Double = (1 - woodResearchCost.value) * totalWoodResearchCost
  lazy val currentGoldResearchCost: Double = (1 - goldResearchCost.value) * totalGoldResearchCost
  lazy val currentStoneResearchCost: Double = (1 - stoneResearchCost.value) * totalStoneResearchCost
  lazy val currentStardustResearchCost: Double = (1 - stardustResearchCost.value) * totalStardustResearchCost
}

object GodsTechnology {
  val version: Int = 1

  val baseResearchSpeed: Double = 1.0
  val baseResearchCost: Double = 0
  val minResearchCost: Double = -0.8

  def example(t: TFunction): GodsTechnology = GodsTechnology(
    UUID.fromString("123e4567-e89b-12d3-a456-426614174000"),
    t("technology:ExampleTitle"),
    t("technology:ExampleDescription"),
    GodType.Teraxes
  )

}
