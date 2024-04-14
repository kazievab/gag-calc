package client.models.gods.technology

import io.circe.generic.JsonCodec

@JsonCodec
case class AllianceResearch(
  commonKnowledgeLevel: Int = 10,
  commonKnowledgeIILevel: Int = 0
) {

  def researchSpeed: Double = Seq(
    commonKnowledgeLevel / 100D,
    commonKnowledgeIILevel / 100D
  ).sum

}
