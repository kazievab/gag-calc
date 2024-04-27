package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed trait CostType extends EnumEntry with Snakecase

object CostType extends Enum[CostType] with CirceEnum[CostType] {
  case object Acceleration extends CostType
  case object Resource extends CostType

  val values = findValues
}
