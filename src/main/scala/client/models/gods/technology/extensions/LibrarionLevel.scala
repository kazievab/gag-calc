package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed abstract class LibrarionLevel(val level: Int, val researchCost: Double, val researchSpeed: Double)
    extends EnumEntry
      with Snakecase

object LibrarionLevel extends Enum[LibrarionLevel] with CirceEnum[LibrarionLevel] {
  case object `0` extends LibrarionLevel(0, -0.025, 0.025)
  case object `1` extends LibrarionLevel(1, -0.05, 0.05)
  case object `2` extends LibrarionLevel(2, -0.075, 0.075)
  case object `3` extends LibrarionLevel(3, -0.1, 0.15)
  case object `4` extends LibrarionLevel(4, -0.2, 0.225)
  case object `5` extends LibrarionLevel(5, -0.25, 0.35)

  val values = findValues
}
