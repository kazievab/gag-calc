package client.models.gods.technology

import client.models.gods.technology.extensions.{ResearchType, UnitType}

case class ResearchRequirements(
  level: Int,
  wood: Long,
  stardust: Long,
  gold: Long,
  stone: Long,
  seconds: Long,
  universityLevel: Int,
  godLevel: Int,
  unitType: UnitType = UnitType.Noop,
  researchType: ResearchType = ResearchType.Noop
)

object ResearchRequirements {

  val default: Seq[ResearchRequirements] = List(
    ResearchRequirements(1, 1700, 1950, 1650, 2100, 14400, 11, 0),
    ResearchRequirements(2, 3850, 3900, 3950, 4250, 32400, 12, 0),
    ResearchRequirements(3, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(4, 19000, 20500, 19500, 21500, 140400, 14, 0),
    ResearchRequirements(5, 35500, 37500, 36000, 40500, 216000, 15, 0),
    ResearchRequirements(6, 48500, 51000, 50500, 54000, 270000, 16, 0),
    ResearchRequirements(7, 70000, 74000, 74500, 74000, 388800, 17, 0),
    ResearchRequirements(8, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(9, 510000, 710000, 545000, 565000, 4579200, 19, 0),
    ResearchRequirements(10, 2050000, 2850000, 2100000, 2050000, 15724800, 20, 0),
    ResearchRequirements(11, 3150000, 4250000, 3100000, 3100000, 23587200, 21, 4),
    ResearchRequirements(12, 4200000, 5450000, 4150000, 4160000, 31536000, 22, 4),
    ResearchRequirements(13, 5900000, 7400000, 5800000, 6260000, 39484800, 23, 5),
    ResearchRequirements(14, 9300000, 11300000, 9100000, 10460000, 47520000, 24, 5)
  ).map(
    _.copy(
      unitType = UnitType.TroglodytePirateGuardian,
      researchType = ResearchType.Core
    )
  ) ++ List(
    ResearchRequirements(1, 1700, 1950, 1650, 2100, 14400, 11, 0),
    ResearchRequirements(2, 3850, 3900, 3950, 4250, 32400, 12, 0),
    ResearchRequirements(3, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(4, 19000, 20500, 19500, 21500, 140400, 14, 0),
    ResearchRequirements(5, 35500, 37500, 36000, 40500, 216000, 15, 0),
    ResearchRequirements(6, 48500, 51000, 50500, 54000, 270000, 16, 0),
    ResearchRequirements(7, 70000, 74000, 74500, 74000, 388800, 17, 0),
    ResearchRequirements(8, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(9, 510000, 710000, 545000, 565000, 4579200, 19, 0),
    ResearchRequirements(10, 2050000, 2850000, 2100000, 2050000, 15724800, 20, 0),
    ResearchRequirements(11, 3150000, 4250000, 3100000, 3100000, 23587200, 21, 4),
    ResearchRequirements(12, 4200000, 5450000, 4150000, 4160000, 31536000, 22, 4),
    ResearchRequirements(13, 6350000, 7400000, 6450000, 6310000, 39312000, 23, 5),
    ResearchRequirements(14, 10650000, 11300000, 11050000, 10610000, 47174400, 24, 5)
  ).map(
    _.copy(
      unitType = UnitType.TroglodytePirateGuardian,
      researchType = ResearchType.CostReduction
    )
  ) ++ List(
    ResearchRequirements(1, 1700, 1950, 1650, 2100, 14400, 11, 0),
    ResearchRequirements(2, 3850, 3900, 3950, 4250, 32400, 12, 0),
    ResearchRequirements(3, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(4, 19000, 20500, 19500, 21500, 140400, 14, 0),
    ResearchRequirements(5, 35500, 37500, 36000, 40500, 216000, 15, 0),
    ResearchRequirements(6, 48500, 51000, 50500, 54000, 270000, 16, 0),
    ResearchRequirements(7, 70000, 74000, 74500, 74000, 388800, 17, 0),
    ResearchRequirements(8, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(9, 510000, 710000, 545000, 565000, 4579200, 19, 0),
    ResearchRequirements(10, 2050000, 2850000, 2100000, 2050000, 15724800, 20, 0),
    ResearchRequirements(11, 3150000, 4250000, 3100000, 3100000, 23587200, 21, 4),
    ResearchRequirements(12, 6350000, 7400000, 6450000, 6310000, 31536000, 22, 4),
    ResearchRequirements(13, 6350000, 7400000, 6450000, 6310000, 35078400, 23, 5),
    ResearchRequirements(14, 10650000, 11300000, 11050000, 10610000, 39571200, 24, 5)
  ).map(
    _.copy(
      unitType = UnitType.TroglodytePirateGuardian,
      researchType = ResearchType.AbilityUpgrade
    )
  ) ++ List(
    ResearchRequirements(1, 1700, 1950, 1650, 2100, 14400, 11, 0),
    ResearchRequirements(2, 3850, 3900, 3950, 4250, 32400, 12, 0),
    ResearchRequirements(3, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(4, 19000, 20500, 19500, 21500, 140400, 14, 0),
    ResearchRequirements(5, 35500, 37500, 36000, 40500, 216000, 15, 0),
    ResearchRequirements(6, 48500, 51000, 50500, 54000, 270000, 16, 0),
    ResearchRequirements(7, 70000, 74000, 74500, 74000, 388800, 17, 0),
    ResearchRequirements(8, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(9, 510000, 710000, 545000, 565000, 4579200, 19, 0),
    ResearchRequirements(10, 2050000, 2850000, 2100000, 2050000, 15724800, 20, 0),
    ResearchRequirements(11, 3150000, 4250000, 3100000, 3100000, 23587200, 21, 4),
    ResearchRequirements(12, 4200000, 5450000, 4150000, 4160000, 31536000, 22, 4),
    ResearchRequirements(13, 6350000, 7400000, 6450000, 6310000, 37497600, 23, 5),
    ResearchRequirements(14, 10650000, 11300000, 11050000, 10610000, 43459200, 24, 5)
  ).map(
    _.copy(
      unitType = UnitType.TroglodytePirateGuardian,
      researchType = ResearchType.RecruitmentSpeed
    )
  ) ++ List(
    ResearchRequirements(0, 8950, 10000, 8650, 11000, 75600, 11, 0),
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 15650000, 27250000, 15700000, 16200000, 72921600, 24, 5),
    ResearchRequirements(14, 25050000, 36750000, 25400000, 26600000, 82857600, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.GoblinAmphibianHalfling,
      researchType = ResearchType.Core
    )
  ) ++ List(
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 19750000, 42000000, 20000000, 20800000, 74390400, 24, 5),
    ResearchRequirements(14, 37350000, 66375000, 38300000, 40400000, 85795200, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.GoblinAmphibianHalfling,
      researchType = ResearchType.CostReduction
    )
  ) ++ List(
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 19750000, 42000000, 20000000, 20800000, 75427200, 24, 5),
    ResearchRequirements(14, 37350000, 74500000, 38300000, 40400000, 85968000, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.GoblinAmphibianHalfling,
      researchType = ResearchType.AbilityUpgrade
    )
  ) ++ List(
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 19750000, 42000000, 20000000, 20800000, 74390400, 24, 5),
    ResearchRequirements(14, 37350000, 66375000, 38300000, 40400000, 85795200, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.GoblinAmphibianHalfling,
      researchType = ResearchType.RecruitmentSpeed
    )
  ) ++ List(
    ResearchRequirements(0, 8950, 10000, 8650, 11000, 75600, 11, 0),
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 15650000, 27250000, 15700000, 16200000, 72921600, 24, 5),
    ResearchRequirements(14, 25050000, 36750000, 25400000, 26600000, 82857600, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.OverseerSirenGargoyle,
      researchType = ResearchType.Core
    )
  ) ++ List(
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 19750000, 42000000, 20000000, 20800000, 74390400, 24, 5),
    ResearchRequirements(14, 37350000, 66375000, 38300000, 40400000, 85795200, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.OverseerSirenGargoyle,
      researchType = ResearchType.CostReduction
    )
  ) ++ List(
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 19750000, 42000000, 20000000, 20800000, 75427200, 24, 5),
    ResearchRequirements(14, 37350000, 74500000, 38300000, 40400000, 85968000, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.OverseerSirenGargoyle,
      researchType = ResearchType.AbilityUpgrade
    )
  ) ++ List(
    ResearchRequirements(1, 4700, 4750, 4850, 5200, 39600, 12, 0),
    ResearchRequirements(2, 13500, 14500, 14000, 15000, 108000, 13, 0),
    ResearchRequirements(3, 20500, 22000, 21000, 23000, 151200, 14, 0),
    ResearchRequirements(4, 33500, 36000, 34500, 38500, 205200, 15, 0),
    ResearchRequirements(5, 44500, 47000, 46500, 50000, 248400, 16, 0),
    ResearchRequirements(6, 62500, 66000, 66000, 66000, 345600, 17, 0),
    ResearchRequirements(7, 165000, 200000, 175000, 180000, 1296000, 18, 0),
    ResearchRequirements(8, 530000, 740000, 565000, 585000, 4752000, 19, 0),
    ResearchRequirements(9, 2250000, 3200000, 2300000, 2300000, 17539200, 20, 0),
    ResearchRequirements(10, 5250000, 7400000, 5300000, 5150000, 36288000, 21, 0),
    ResearchRequirements(11, 7300000, 11000000, 7250000, 7200000, 49680000, 22, 4),
    ResearchRequirements(12, 10950000, 22500000, 10850000, 11000000, 63072000, 23, 4),
    ResearchRequirements(13, 19750000, 42000000, 20000000, 20800000, 74390400, 24, 5),
    ResearchRequirements(14, 37350000, 66375000, 38300000, 40400000, 85795200, 25, 5)
  ).map(
    _.copy(
      unitType = UnitType.OverseerSirenGargoyle,
      researchType = ResearchType.RecruitmentSpeed
    )
  ) ++ List(
    ResearchRequirements(0, 15500, 15500, 16000, 17000, 129600, 12, 2),
    ResearchRequirements(1, 11000, 11500, 11500, 12000, 86400, 13, 2),
    ResearchRequirements(2, 19000, 20500, 19500, 21500, 140400, 14, 2),
    ResearchRequirements(3, 33500, 36000, 34500, 38500, 205200, 15, 2),
    ResearchRequirements(4, 44500, 47000, 46500, 50000, 248400, 16, 2),
    ResearchRequirements(5, 76000, 80500, 80500, 80500, 421200, 17, 2),
    ResearchRequirements(6, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(7, 580000, 805000, 620000, 640000, 5184000, 19, 2),
    ResearchRequirements(8, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(9, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(10, 15000000, 22000000, 15000000, 15000000, 101606400, 22, 2),
    ResearchRequirements(11, 19000000, 28000000, 19000000, 19000000, 152409600, 23, 4),
    ResearchRequirements(12, 28500000, 42000000, 28500000, 28500000, 228614400, 24, 4),
    ResearchRequirements(13, 39500000, 65000000, 40000000, 40500000, 279417600, 25, 5),
    ResearchRequirements(14, 61500000, 93750000, 63000000, 64500000, 313977600, 26, 5)
  ).map(
    _.copy(
      unitType = UnitType.CyclopsMedusaElf,
      researchType = ResearchType.Core
    )
  ) ++ List(
    ResearchRequirements(1, 11000, 11500, 11500, 12000, 86400, 13, 2),
    ResearchRequirements(2, 19000, 20500, 19500, 21500, 140400, 14, 2),
    ResearchRequirements(3, 33500, 36000, 34500, 38500, 205200, 15, 2),
    ResearchRequirements(4, 44500, 47000, 46500, 50000, 248400, 16, 2),
    ResearchRequirements(5, 76000, 80500, 80500, 80500, 421200, 17, 2),
    ResearchRequirements(6, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(7, 580000, 805000, 620000, 640000, 5184000, 19, 2),
    ResearchRequirements(8, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(9, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(10, 15000000, 22000000, 15000000, 15000000, 101606400, 22, 2),
    ResearchRequirements(11, 19000000, 28000000, 19000000, 19000000, 152409600, 23, 4),
    ResearchRequirements(12, 28500000, 42000000, 28500000, 28500000, 228614400, 24, 4),
    ResearchRequirements(13, 44500000, 60000000, 44500000, 47500000, 249350400, 25, 5),
    ResearchRequirements(14, 64500000, 82500000, 64500000, 71250000, 262224000, 26, 5)
  ).map(
    _.copy(
      unitType = UnitType.CyclopsMedusaElf,
      researchType = ResearchType.CostReduction
    )
  ) ++ List(
    ResearchRequirements(1, 11000, 11500, 11500, 12000, 86400, 13, 2),
    ResearchRequirements(2, 19000, 20500, 19500, 21500, 140400, 14, 2),
    ResearchRequirements(3, 33500, 36000, 34500, 38500, 205200, 15, 2),
    ResearchRequirements(4, 44500, 47000, 46500, 50000, 248400, 16, 2),
    ResearchRequirements(5, 76000, 80500, 80500, 80500, 421200, 17, 2),
    ResearchRequirements(6, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(7, 580000, 805000, 620000, 640000, 5184000, 19, 2),
    ResearchRequirements(8, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(9, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(10, 15000000, 22000000, 15000000, 15000000, 101606400, 22, 2),
    ResearchRequirements(11, 19000000, 28000000, 19000000, 19000000, 152409600, 23, 4),
    ResearchRequirements(12, 28500000, 42000000, 28500000, 28500000, 228614400, 24, 4),
    ResearchRequirements(13, 44500000, 60000000, 44500000, 47500000, 246585600, 25, 5),
    ResearchRequirements(14, 64500000, 82500000, 64500000, 71250000, 264556800, 26, 5)
  ).map(
    _.copy(
      unitType = UnitType.CyclopsMedusaElf,
      researchType = ResearchType.AbilityUpgrade
    )
  ) ++ List(
    ResearchRequirements(1, 11000, 11500, 11500, 12000, 86400, 13, 2),
    ResearchRequirements(2, 19000, 20500, 19500, 21500, 140400, 14, 2),
    ResearchRequirements(3, 33500, 36000, 34500, 38500, 205200, 15, 2),
    ResearchRequirements(4, 44500, 47000, 46500, 50000, 248400, 16, 2),
    ResearchRequirements(5, 76000, 80500, 80500, 80500, 421200, 17, 2),
    ResearchRequirements(6, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(7, 580000, 805000, 620000, 640000, 5184000, 19, 2),
    ResearchRequirements(8, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(9, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(10, 15000000, 22000000, 15000000, 15000000, 101606400, 22, 2),
    ResearchRequirements(11, 19000000, 28000000, 19000000, 19000000, 152409600, 23, 4),
    ResearchRequirements(12, 28500000, 42000000, 28500000, 28500000, 228614400, 24, 4),
    ResearchRequirements(13, 44500000, 60000000, 44500000, 47500000, 246585600, 25, 5),
    ResearchRequirements(14, 64500000, 82500000, 64500000, 71250000, 259459200, 26, 5)
  ).map(
    _.copy(
      unitType = UnitType.CyclopsMedusaElf,
      researchType = ResearchType.RecruitmentSpeed
    )
  ) ++ List(
    ResearchRequirements(0, 38000, 40000, 39500, 42500, 302400, 13, 2),
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 62500000, 104500000, 63000000, 65000000, 368928000, 26, 5),
    ResearchRequirements(14, 97500000, 150750000, 99000000, 105000000, 412128000, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.GiantElementalGolem,
      researchType = ResearchType.Core
    )
  ) ++ List(
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 74000000, 98500000, 74000000, 78000000, 350611200, 26, 5),
    ResearchRequirements(14, 110250000, 137250000, 110250000, 119250000, 366076800, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.GiantElementalGolem,
      researchType = ResearchType.CostReduction
    )
  ) ++ List(
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 74000000, 98500000, 74000000, 78000000, 347328000, 26, 5),
    ResearchRequirements(14, 110250000, 137250000, 110250000, 119250000, 368928000, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.GiantElementalGolem,
      researchType = ResearchType.AbilityUpgrade
    )
  ) ++ List(
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 74000000, 98500000, 74000000, 78000000, 351648000, 26, 5),
    ResearchRequirements(14, 110250000, 137250000, 110250000, 119250000, 373248000, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.GiantElementalGolem,
      researchType = ResearchType.RecruitmentSpeed
    )
  ) ++ List(
    ResearchRequirements(0, 38000, 40000, 39500, 42500, 302400, 13, 2),
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 62500000, 104500000, 63000000, 65000000, 368928000, 26, 5),
    ResearchRequirements(14, 97500000, 150750000, 99000000, 105000000, 412128000, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.OgreKrakenDwarf,
      researchType = ResearchType.Core
    )
  ) ++ List(
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 74000000, 98500000, 74000000, 78000000, 350611200, 26, 5),
    ResearchRequirements(14, 110250000, 137250000, 110250000, 119250000, 366076800, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.OgreKrakenDwarf,
      researchType = ResearchType.CostReduction
    )
  ) ++ List(
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 74000000, 98500000, 74000000, 78000000, 347328000, 26, 5),
    ResearchRequirements(14, 110250000, 137250000, 110250000, 119250000, 368928000, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.OgreKrakenDwarf,
      researchType = ResearchType.AbilityUpgrade
    )
  ) ++ List(
    ResearchRequirements(1, 17500, 18500, 18000, 20000, 129600, 14, 2),
    ResearchRequirements(2, 32000, 34000, 32500, 36500, 194400, 15, 2),
    ResearchRequirements(3, 43000, 45000, 44500, 47500, 237600, 16, 2),
    ResearchRequirements(4, 72000, 76000, 76500, 76000, 399600, 17, 2),
    ResearchRequirements(5, 190000, 225000, 200000, 200000, 1468800, 18, 2),
    ResearchRequirements(6, 570000, 790000, 610000, 630000, 5097600, 19, 2),
    ResearchRequirements(7, 2350000, 3300000, 2400000, 2350000, 18144000, 20, 2),
    ResearchRequirements(8, 5600000, 7900000, 5650000, 5500000, 38707200, 21, 2),
    ResearchRequirements(9, 16500000, 24000000, 16500000, 16500000, 110073600, 22, 2),
    ResearchRequirements(10, 20000000, 30000000, 20000000, 20000000, 160876800, 23, 2),
    ResearchRequirements(11, 30000000, 45000000, 30000000, 30000000, 241315200, 24, 4),
    ResearchRequirements(12, 45000000, 67500000, 45000000, 45000000, 325728000, 25, 4),
    ResearchRequirements(13, 74000000, 98500000, 74000000, 78000000, 351648000, 26, 5),
    ResearchRequirements(14, 110250000, 137250000, 110250000, 119250000, 373248000, 27, 5)
  ).map(
    _.copy(
      unitType = UnitType.OgreKrakenDwarf,
      researchType = ResearchType.RecruitmentSpeed
    )
  ) ++ List(
    ResearchRequirements(0, 54000, 57500, 56000, 61500, 399600, 14, 3),
    ResearchRequirements(1, 24500, 26500, 25500, 28000, 151200, 15, 3),
    ResearchRequirements(2, 37000, 38500, 38500, 41000, 205200, 16, 3),
    ResearchRequirements(3, 62500, 66000, 66000, 66000, 345600, 17, 3),
    ResearchRequirements(4, 165000, 200000, 175000, 180000, 1296000, 18, 3),
    ResearchRequirements(5, 550000, 765000, 590000, 610000, 4924800, 19, 3),
    ResearchRequirements(6, 2450000, 3400000, 2500000, 2450000, 18748800, 20, 3),
    ResearchRequirements(7, 5850000, 8250000, 5950000, 5750000, 40521600, 21, 3),
    ResearchRequirements(8, 17000000, 25000000, 17500000, 17000000, 115516800, 22, 3),
    ResearchRequirements(9, 23500000, 35500000, 23500000, 23500000, 191116800, 23, 3),
    ResearchRequirements(10, 46000000, 69000000, 46000000, 46000000, 315705600, 24, 3),
    ResearchRequirements(11, 69000000, 103500000, 69000000, 69000000, 426211200, 25, 4),
    ResearchRequirements(12, 103500000, 155000000, 103500000, 103500000, 575424000, 26, 4),
    ResearchRequirements(13, 152500000, 208000000, 154500000, 159500000, 625795200, 27, 5),
    ResearchRequirements(14, 213750000, 274250000, 218250000, 229500000, 676166400, 28, 5)
  ).map(
    _.copy(
      unitType = UnitType.MinotaurNeptuneDestroyer,
      researchType = ResearchType.Core
    )
  ) ++ List(
    ResearchRequirements(1, 24500, 26500, 25500, 28000, 151200, 15, 3),
    ResearchRequirements(2, 37000, 38500, 38500, 41000, 205200, 16, 3),
    ResearchRequirements(3, 62500, 66000, 66000, 66000, 345600, 17, 3),
    ResearchRequirements(4, 165000, 200000, 175000, 180000, 1296000, 18, 3),
    ResearchRequirements(5, 550000, 765000, 590000, 610000, 4924800, 19, 3),
    ResearchRequirements(6, 2450000, 3400000, 2500000, 2450000, 18748800, 20, 3),
    ResearchRequirements(7, 5850000, 8250000, 5950000, 5750000, 40521600, 21, 3),
    ResearchRequirements(8, 17000000, 25000000, 17500000, 17000000, 115516800, 22, 3),
    ResearchRequirements(9, 23500000, 35500000, 23500000, 23500000, 191116800, 23, 3),
    ResearchRequirements(10, 46000000, 69000000, 46000000, 46000000, 315705600, 24, 3),
    ResearchRequirements(11, 69000000, 103500000, 69000000, 69000000, 426211200, 25, 4),
    ResearchRequirements(12, 103500000, 155000000, 103500000, 103500000, 575424000, 26, 4),
    ResearchRequirements(13, 166000000, 275000000, 168500000, 168500000, 593395200, 27, 5),
    ResearchRequirements(14, 228500000, 395000000, 233500000, 233500000, 604195200, 28, 5)
  ).map(
    _.copy(
      unitType = UnitType.MinotaurNeptuneDestroyer,
      researchType = ResearchType.CostReduction
    )
  ) ++ List(
    ResearchRequirements(1, 24500, 26500, 25500, 28000, 151200, 15, 3),
    ResearchRequirements(2, 37000, 38500, 38500, 41000, 205200, 16, 3),
    ResearchRequirements(3, 62500, 66000, 66000, 66000, 345600, 17, 3),
    ResearchRequirements(4, 165000, 200000, 175000, 180000, 1296000, 18, 3),
    ResearchRequirements(5, 550000, 765000, 590000, 610000, 4924800, 19, 3),
    ResearchRequirements(6, 2450000, 3400000, 2500000, 2450000, 18748800, 20, 3),
    ResearchRequirements(7, 5850000, 8250000, 5950000, 5750000, 40521600, 21, 3),
    ResearchRequirements(8, 17000000, 25000000, 17500000, 17000000, 115516800, 22, 3),
    ResearchRequirements(9, 23500000, 35500000, 23500000, 23500000, 191116800, 23, 3),
    ResearchRequirements(10, 46000000, 69000000, 46000000, 46000000, 315705600, 24, 3),
    ResearchRequirements(11, 69000000, 103500000, 69000000, 69000000, 426211200, 25, 4),
    ResearchRequirements(12, 103500000, 155000000, 103500000, 103500000, 575424000, 26, 4),
    ResearchRequirements(13, 166000000, 275000000, 168500000, 168500000, 597024000, 27, 5),
    ResearchRequirements(14, 228500000, 395000000, 233500000, 233500000, 618624000, 28, 5)
  ).map(
    _.copy(
      unitType = UnitType.MinotaurNeptuneDestroyer,
      researchType = ResearchType.AbilityUpgrade
    )
  ) ++ List(
    ResearchRequirements(1, 24500, 26500, 25500, 28000, 151200, 15, 3),
    ResearchRequirements(2, 37000, 38500, 38500, 41000, 205200, 16, 3),
    ResearchRequirements(3, 62500, 66000, 66000, 66000, 345600, 17, 3),
    ResearchRequirements(4, 165000, 200000, 175000, 180000, 1296000, 18, 3),
    ResearchRequirements(5, 550000, 765000, 590000, 610000, 4924800, 19, 3),
    ResearchRequirements(6, 2450000, 3400000, 2500000, 2450000, 18748800, 20, 3),
    ResearchRequirements(7, 5850000, 8250000, 5950000, 5750000, 40521600, 21, 3),
    ResearchRequirements(8, 17000000, 25000000, 17500000, 17000000, 115516800, 22, 3),
    ResearchRequirements(9, 23500000, 35500000, 23500000, 23500000, 191116800, 23, 3),
    ResearchRequirements(10, 46000000, 69000000, 46000000, 46000000, 315705600, 24, 3),
    ResearchRequirements(11, 69000000, 103500000, 69000000, 69000000, 426211200, 25, 4),
    ResearchRequirements(12, 103500000, 155000000, 103500000, 103500000, 575424000, 26, 4),
    ResearchRequirements(13, 166000000, 275000000, 168500000, 168500000, 593395200, 27, 5),
    ResearchRequirements(14, 228500000, 395000000, 233500000, 233500000, 602380800, 28, 5)
  ).map(
    _.copy(
      unitType = UnitType.MinotaurNeptuneDestroyer,
      researchType = ResearchType.RecruitmentSpeed
    )
  )

}
