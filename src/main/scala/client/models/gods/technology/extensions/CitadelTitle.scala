package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed abstract class CitadelTitle(val researchSpeed: Double)
    extends EnumEntry
      with Snakecase

object CitadelTitle extends Enum[CitadelTitle] with CirceEnum[CitadelTitle] {
  case object Researcher extends CitadelTitle(0.25)
  case object Jester extends CitadelTitle(-0.25)

  val values = findValues
}
