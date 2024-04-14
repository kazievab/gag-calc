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

  def librarionResearchCost: Double = librarionLevel.map(_.researchCost).getOrElse(0)
  def ageOfScienceGoldResearchCost: Double = if (ageOfScience) 0.3 else 0

  private def preWoodResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    librarionResearchCost,
    developmentResearch.woodResearchCost,
    skinType.map(_.woodResearchCost).getOrElse(0D),
    additionalParameters.woodResearchCost
  ).sum

  def woodResearchCost: Double = Math.abs(
    Math.max(preWoodResearchCost, GodsTechnology.minResearchCost)
  )

  def woodResearchCostPercent: String =
    (if (woodResearchCost != 0) "-" else "") + (woodResearchCost * 100).toString + "%"

  private def preGoldResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    ageOfScienceGoldResearchCost,
    librarionResearchCost,
    developmentResearch.goldResearchCost,
    skinType.map(_.goldResearchCost).getOrElse(0D),
    additionalParameters.goldResearchCost
  ).sum

  def goldResearchCost: Double = Math.abs(
    Math.max(preGoldResearchCost, GodsTechnology.minResearchCost)
  )

  def goldResearchCostPercent: String =
    (if (goldResearchCost < 0) "-" else "+") + Math.ceil(goldResearchCost * 100).toString + "%"

  private def preStoneResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    librarionResearchCost,
    developmentResearch.stoneResearchCost,
    skinType.map(_.stoneResearchCost).getOrElse(0D),
    additionalParameters.stoneResearchCost
  ).sum

  def stoneResearchCost: Double = Math.abs(
    Math.max(preStoneResearchCost, GodsTechnology.minResearchCost)
  )

  def stoneResearchCostPercent: String =
    (if (stoneResearchCost != 0) "-" else "") + (stoneResearchCost * 100).toString + "%"

  def preStardustResearchCost: Double = Seq(
    GodsTechnology.baseResearchCost,
    librarionResearchCost,
    developmentResearch.stardustResearchCost,
    skinType.map(_.stardustResearchCost).getOrElse(0D),
    additionalParameters.stardustResearchCost
  ).sum

  def stardustResearchCost: Double = Math.abs(
    Math.max(preStardustResearchCost, GodsTechnology.minResearchCost)
  )

  def stardustResearchCostPercent: String =
    (if (stardustResearchCost != 0) "-" else "") + (stardustResearchCost * 100).toString + "%"

  lazy val researchRequirements: Seq[ResearchRequirements] =
    if (researchIds.isEmpty) ResearchRequirements.default
    else ResearchRequirements.default.filter(entity => researchIds.contains(entity.id))

  lazy val totalTimeResearchTimeCost: Double = TimeUnit.SECONDS.toDays(researchRequirements.map(_.seconds).sum).toDouble
  lazy val totalWoodResearchCost: Double = researchRequirements.map(_.wood).sum.toDouble
  lazy val totalGoldResearchCost: Double = researchRequirements.map(_.gold).sum.toDouble
  lazy val totalStoneResearchCost: Double = researchRequirements.map(_.stone).sum.toDouble
  lazy val totalStardustResearchCost: Double = researchRequirements.map(_.stardust).sum.toDouble

  lazy val currentWoodResearchCost: Double = (1 - woodResearchCost) * totalWoodResearchCost
  lazy val currentGoldResearchCost: Double = (1 - goldResearchCost) * totalGoldResearchCost
  lazy val currentStoneResearchCost: Double = (1 - stoneResearchCost) * totalStoneResearchCost
  lazy val currentStardustResearchCost: Double = (1 - stardustResearchCost) * totalStardustResearchCost
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
