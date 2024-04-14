package client.models.gods.technology

import io.circe.generic.JsonCodec

@JsonCodec
case class AdditionalParameters(
  researchSpeed: Double = 0,
  woodResearchCost: Double = 0,
  goldResearchCost: Double = 0,
  stoneResearchCost: Double = 0,
  stardustResearchCost: Double = 0
)
