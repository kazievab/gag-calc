package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed abstract class VipLevel(val level: Int, val researchSpeed: Double) extends EnumEntry
      with Snakecase

object VipLevel extends Enum[VipLevel] with CirceEnum[VipLevel] {
  case object `1` extends VipLevel(1, 0)
  case object `2` extends VipLevel(2, 0)
  case object `3` extends VipLevel(3, 0)
  case object `4` extends VipLevel(4, 0.1)
  case object `5` extends VipLevel(5, 0.25)
  case object `6` extends VipLevel(6, 0.4)
  case object `7` extends VipLevel(7, 0.55)
  case object `8` extends VipLevel(8, 0.7)
  case object `9` extends VipLevel(9, 0.85)
  case object `10` extends VipLevel(10, 1)
  case object `11` extends VipLevel(11, 1.15)
  case object `12` extends VipLevel(12, 1.2)
  case object `13` extends VipLevel(13, 1.25)
  case object `14` extends VipLevel(14, 1.3)
  case object `15` extends VipLevel(15, 1.35)
  case object `16` extends VipLevel(16, 1.4)
  case object `17` extends VipLevel(17, 1.45)
  case object `18` extends VipLevel(18, 1.5)
  case object `19` extends VipLevel(19, 1.5)
  case object `20` extends VipLevel(20, 1.5)

  val values = findValues
}
