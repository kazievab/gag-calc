package client.models.gods.technology

import client.models.gods.technology.extensions.CostType
import typings.antDesignProCard.antDesignProCardStrings
import typings.antDesignProCard.antDesignProCardStrings.{down, up}

import scala.scalajs.js.|

case class ResearchCost(value: Double, baseValue: Double, costType: CostType) {
  val percent: String = (if (baseValue < 0) "-" else "+") + Math.ceil(value * 100).toString + "%"

  val trend: up | down = costType match {
    case CostType.Acceleration => if (baseValue >= 0) antDesignProCardStrings.down else antDesignProCardStrings.up
    case CostType.Resource     => if (baseValue < 0) antDesignProCardStrings.down else antDesignProCardStrings.up
  }

}

object ResearchCost {

  def createResource(pre: Double, min: Double): ResearchCost = {
    val baseValue = Math.max(pre, min)

    ResearchCost(Math.abs(baseValue), baseValue, CostType.Resource)
  }

  def createAcceleration(value: Double): ResearchCost = ResearchCost(Math.abs(value), value, CostType.Acceleration)

}
