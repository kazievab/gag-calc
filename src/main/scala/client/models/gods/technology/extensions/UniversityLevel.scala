package client.models.gods.technology.extensions

import enumeratum.{CirceEnum, Enum, EnumEntry}
import enumeratum.EnumEntry.Snakecase

sealed abstract class UniversityLevel(val level: Int, val researchSpeed: Double) extends EnumEntry
      with Snakecase

object UniversityLevel extends Enum[UniversityLevel] with CirceEnum[UniversityLevel] {
  case object `1` extends UniversityLevel(1, 0)
  case object `2` extends UniversityLevel(2, 0.01)
  case object `3` extends UniversityLevel(3, 0.02)
  case object `4` extends UniversityLevel(4, 0.03)
  case object `5` extends UniversityLevel(5, 0.05)
  case object `6` extends UniversityLevel(6, 0.07)
  case object `7` extends UniversityLevel(7, 0.09)
  case object `8` extends UniversityLevel(8, 0.11)
  case object `9` extends UniversityLevel(9, 0.13)
  case object `10` extends UniversityLevel(10, 0.15)
  case object `11` extends UniversityLevel(11, 0.2)
  case object `12` extends UniversityLevel(12, 0.25)
  case object `13` extends UniversityLevel(13, 0.3)
  case object `14` extends UniversityLevel(14, 0.35)
  case object `15` extends UniversityLevel(15, 0.4)
  case object `16` extends UniversityLevel(16, 0.45)
  case object `17` extends UniversityLevel(17, 0.5)
  case object `18` extends UniversityLevel(18, 0.55)
  case object `19` extends UniversityLevel(19, 0.6)
  case object `20` extends UniversityLevel(20, 0.65)
  case object `21` extends UniversityLevel(21, 0.7)
  case object `22` extends UniversityLevel(22, 0.75)
  case object `23` extends UniversityLevel(23, 0.8)
  case object `24` extends UniversityLevel(24, 0.9)
  case object `25` extends UniversityLevel(25, 1)
  case object `26` extends UniversityLevel(26, 1.1)
  case object `27` extends UniversityLevel(27, 1.2)
  case object `28` extends UniversityLevel(28, 1.3)
  case object `29` extends UniversityLevel(29, 1.4)
  case object `30` extends UniversityLevel(30, 1.5)
  case object `31` extends UniversityLevel(31, 1.6)
  case object `32` extends UniversityLevel(32, 1.7)
  case object `33` extends UniversityLevel(33, 1.8)
  case object `34` extends UniversityLevel(34, 1.9)
  case object `35` extends UniversityLevel(35, 2)

  val values = findValues
}
