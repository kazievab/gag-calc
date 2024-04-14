package client.models.gods.technology

import io.circe.generic.JsonCodec

@JsonCodec
case class DevelopmentResearch(
  scientificMethodLevel: Int = 0,
  woodCostLevel: Int = 0,
  goldCostLevel: Int = 0,
  stoneCostLevel: Int = 0,
  stardustCostLevel: Int = 0
) {
  def researchSpeed: Double = scientificMethodLevel / 100D

  def woodResearchCost: Double = -(woodCostLevel / 100D)
  def goldResearchCost: Double = -(goldCostLevel / 100D)
  def stoneResearchCost: Double = -(stoneCostLevel / 100D)
  def stardustResearchCost: Double = -(stardustCostLevel / 100D)
}
