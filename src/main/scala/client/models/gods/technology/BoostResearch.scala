package client.models.gods.technology

import io.circe.generic.JsonCodec

@JsonCodec
case class BoostResearch(
  commonBoost: Boolean = true,
  citadelRanking: Boolean = false,
  citadelChests: Boolean = false,
  season: Boolean = false,
  shadowInvasion: Boolean = false
) {
  def commonBoostResearchSpeed: Double = if (commonBoost) 0.25 else 0
  def citadelRankingResearchSpeed: Double = if (commonBoost) 0.05 else 0
  def citadelChestsResearchSpeed: Double = if (commonBoost) 0.05 else 0
  def seasonResearchSpeed: Double = if (season) 0.1 else 0
  def shadowInvasionResearchSpeed: Double = if (season) 0.1 else 0

  def researchSpeed: Double = Seq(
    commonBoostResearchSpeed,
    citadelRankingResearchSpeed,
    citadelChestsResearchSpeed,
    seasonResearchSpeed,
    shadowInvasionResearchSpeed
  ).sum

}
