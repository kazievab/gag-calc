package client.models.gods.technology

import client.models.gods.technology.extensions.GodType
import io.circe.generic.JsonCodec

import java.util.UUID

@JsonCodec
case class GodsTechnology(
  id: UUID,
  title: String,
  description: String,
  godLvl: Int,
  godType: GodType,
  universityLvl: Int
)
