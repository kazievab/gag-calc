package client.components.ui.Tooltip

import cats.implicits.catsSyntaxOptionId
import client.style.commonStyle
import client.utils.syntax.IdentitySyntax
import client.utils.syntax.ReactElementSyntax.syntaxReactElementOps
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.facade.React
import japgolly.scalajs.react.vdom.VdomElement
import typings.antDesignIcons.components.AntdIcon
import typings.antDesignIconsSvg.esAsnQuestionCircleOutlinedMod.{default => QuestionCircleOutlinedIcon}
import typings.antd.esTooltipMod.TooltipPlacement
import typings.react.mod.CSSProperties

final case class TooltipWithIcon(
  title: Option[React.Node] = None,
  placement: Option[TooltipPlacement] = None,
  icon: Option[React.Element] = None,
  iconStyle: Option[CSSProperties] = None
) {
  def setTitle(value: React.Node): TooltipWithIcon = copy(title = value.some)

  def setPlacement(value: TooltipPlacement): TooltipWithIcon = copy(placement = value.some)

  def setIcon(value: React.Element): TooltipWithIcon = copy(icon = value.some)

  def setIconStyle(value: CSSProperties): TooltipWithIcon = copy(iconStyle = value.some)

  @inline def render: VdomElement = TooltipWithIcon.component(this)
}

object TooltipWithIcon extends IdentitySyntax {

  private val component = ScalaFnComponent.withHooks[TooltipWithIcon]
    .render { props =>
      val icon = props
        .icon
        .getOrElse(
          AntdIcon(QuestionCircleOutlinedIcon)
            .applyOption(props.iconStyle)((builder, value) => builder.style(value))
            .rawElement
        )
        .toVdomNode

      Tooltip()
        .applyOption(props.title)((builder, value) => builder.setTitle(value))
        .applyOption(props.placement)((builder, value) => builder.setPlacement(value))
        .setOverlayInnerStyle(commonStyle.pageTitleTooltipInner)
        .setChildren(icon)
        .render
    }

}
