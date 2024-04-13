package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed trait GodType extends EnumEntry with Snakecase

object GodType extends Enum[GodType] with CirceEnum[GodType] {
  case object Teraxes extends GodType
  case object Proteus extends GodType
  case object Farios extends GodType

  val values = findValues
}
