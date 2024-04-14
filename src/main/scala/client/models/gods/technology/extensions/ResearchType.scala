package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed trait ResearchType extends EnumEntry with Snakecase

object ResearchType extends Enum[ResearchType] with CirceEnum[ResearchType] {
  case object Core extends ResearchType
  case object CostReduction extends ResearchType
  case object AbilityUpgrade extends ResearchType
  case object RecruitmentSpeed extends ResearchType

  val values = findValues
}
