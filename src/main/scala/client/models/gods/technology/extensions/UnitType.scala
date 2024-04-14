package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed abstract class UnitType(val row: Int) extends EnumEntry with Snakecase

object UnitType extends Enum[UnitType] with CirceEnum[UnitType] {
  case object TroglodytePirateGuardian extends UnitType(1)
  case object GoblinAmphibianHalfling extends UnitType(2)
  case object OverseerSirenGargoyle extends UnitType(2)
  case object CyclopsMedusaElf extends UnitType(3)
  case object GiantElementalGolem extends UnitType(4)
  case object OgreKrakenDwarf extends UnitType(4)
  case object MinotaurNeptuneDestroyer extends UnitType(5)

  val values = findValues
}
