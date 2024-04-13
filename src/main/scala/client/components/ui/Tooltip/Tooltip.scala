package client.components.ui.Tooltip

import cats.implicits.catsSyntaxOptionId
import client.utils.syntax.IdentitySyntax
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.facade.React
import japgolly.scalajs.react.vdom.{VdomElement, VdomNode}
import typings.antd.{components => Antd}
import typings.antd.esTooltipMod.{TooltipPlacement, TooltipProps, TooltipPropsWithTitle}
import typings.react.mod.{CSSProperties, RefAttributes}

final case class Tooltip(
  title: Option[React.Node] = None,
  children: Option[VdomNode] = None,
  placement: Option[TooltipPlacement] = None,
  overlayStyle: Option[CSSProperties] = None,
  overlayInnerStyle: Option[CSSProperties] = None,
  delay: Double = 1.5D
) {
  def setTitle(value: React.Node): Tooltip = copy(title = value.some)

  def setPlacement(value: TooltipPlacement): Tooltip = copy(placement = value.some)

  def setDelay(value: Double): Tooltip = copy(delay = value)

  def setOverlayStyle(value: CSSProperties): Tooltip = copy(overlayStyle = value.some)

  def setOverlayInnerStyle(value: CSSProperties): Tooltip = copy(overlayInnerStyle = value.some)

  def setChildren(value: VdomNode): Tooltip = copy(children = value.some)

  @inline def render: VdomElement = Tooltip.component(this)
}

object Tooltip extends IdentitySyntax {

  private val component = ScalaFnComponent.withHooks[Tooltip]
    .render { props =>
      val tooltipProps = TooltipPropsWithTitle()
        .applyOption(props.title)((builder, value) => builder.setTitle(value))
        .applyOption(props.placement)((builder, value) => builder.setPlacement(value))
        .applyOption(props.children)((builder, value) => builder.setChildren(value))
        .applyOption(props.overlayStyle)((builder, value) => builder.setOverlayStyle(value))
        .applyOption(props.overlayInnerStyle)((builder, value) => builder.setOverlayInnerStyle(value))
        .setMouseEnterDelay(props.delay)
        .asInstanceOf[TooltipProps with RefAttributes[Any]]

      Antd.Tooltip(tooltipProps)
    }

}
