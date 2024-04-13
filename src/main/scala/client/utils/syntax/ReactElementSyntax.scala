package client.utils.syntax

import japgolly.scalajs.react.facade.React
import japgolly.scalajs.react.vdom.VdomNode

final private[syntax] class ReactElementOps(private val entity: React.Element) extends AnyVal {

  @inline
  def toVdomNode: VdomNode = VdomNode(entity)

}

trait ReactElementSyntax {
  implicit final def syntaxReactElementOps(entity: React.Element): ReactElementOps = new ReactElementOps(entity)
}

object ReactElementSyntax extends ReactElementSyntax
