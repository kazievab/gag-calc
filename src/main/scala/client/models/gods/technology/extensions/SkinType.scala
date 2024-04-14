package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed abstract class SkinType(
  val researchSpeed: Double,
  val woodResearchCost: Double,
  val goldResearchCost: Double,
  val stoneResearchCost: Double,
  val stardustResearchCost: Double
) extends EnumEntry
      with Snakecase

object SkinType extends Enum[SkinType] with CirceEnum[SkinType] {
  case object ColossusDeep extends SkinType(0, 0, 0, 0, -0.2)
  case object Vinci extends SkinType(0, -0.3, 0, 0, -0.3)
  case object BitOfRuins extends SkinType(0, -0.33, -0.33, -0.33, -0.33)
  case object NightSkyResidence extends SkinType(0.25, 0, 0, 0, 0)
  case object HallOfMadness extends SkinType(0.25, 0, 0, 0, 0)
  case object SupernalLibrary extends SkinType(0.5, 0, 0, 0, 0)
  case object Atlantis extends SkinType(0, 0, 0, 0, -0.6)
  case object Atlantis2 extends SkinType(0, 0, 0, 0, -0.6)
  case object Anomaly extends SkinType(0.5, 0, 0, 0, -0.5)
  case object HallsOfScience extends SkinType(1, 0, 0, 0, 0)
  case object Yggdrasil extends SkinType(0, -0.5, 0, -0.5, 0)
  case object Paragon extends SkinType(0.75, 0, 0, 0, 0)
  case object CityOfDis extends SkinType(0, -0.75, -0.75, -0.75, -0.75)

  case class Custom(
    override val researchSpeed: Double,
    override val woodResearchCost: Double,
    override val goldResearchCost: Double,
    override val stoneResearchCost: Double,
    override val stardustResearchCost: Double
  ) extends SkinType(
        researchSpeed,
        woodResearchCost,
        goldResearchCost,
        stoneResearchCost,
        stardustResearchCost
      )

  val values = findValues
}
