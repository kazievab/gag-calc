package client.components.ui

import cats.implicits.catsSyntaxOptionId
import client.components.ui.Tooltip.TooltipWithIcon
import client.style.commonStyle
import client.utils.syntax.{IdentitySyntax, ListSyntax}
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.facade.{Empty, JsNumber, React}
import japgolly.scalajs.react.vdom.all._
import typings.antDesignProLayout.anon.OmitAffixPropschildren
import typings.antDesignProLayout.components.PageContainer
import typings.antDesignProLayout.esComponentsPageContainerMod.PageContainerProps
import typings.react.components.Fragment

import scala.scalajs.js.JSConverters.JSRichIterableOnce
import scala.scalajs.js.|

final case class ContainerPage(
  title: Option[React.Node] = None,
  tooltipTitle: Option[React.Node] = None,
  subTitle: Option[React.Node] = None,
  tags: List[React.Element] = List.empty,
  content: Option[VdomNode] = None,
  extra: List[VdomNode] = Nil,
  children: List[VdomNode] = Nil,
  fixedHeader: Boolean = false,
  loading: Boolean = false
) {
  def setTitle(value: React.Node): ContainerPage = copy(title = value.some)

  def setSubTitle(value: React.Node): ContainerPage = copy(subTitle = value.some)

  def setTooltipTitle(value: React.Node): ContainerPage = copy(tooltipTitle = value.some)

  def setTags(value: React.Element): ContainerPage = copy(tags = List(value))

  def setTagsList(value: List[React.Element]): ContainerPage = copy(tags = value)

  def setTagsVarargs(value: React.Element*): ContainerPage = copy(tags = List(value: _*))

  def setContent(value: VdomNode): ContainerPage = copy(content = value.some)

  def setExtra(value: VdomNode): ContainerPage = copy(extra = List(value))

  def setExtraList(value: List[VdomNode]): ContainerPage = copy(extra = value)

  def setExtraVarargs(value: VdomNode*): ContainerPage = copy(extra = List(value: _*))

  def setChildren(value: VdomNode): ContainerPage = copy(children = List(value))

  def setChildrenVarargs(value: VdomNode*): ContainerPage = copy(children = List(value: _*))

  def setLoading(value: Boolean): ContainerPage = copy(loading = value)

  def enableFixedHeader: ContainerPage = copy(fixedHeader = true)

  @inline def render: VdomElement = ContainerPage.component(this)
}

object ContainerPage extends IdentitySyntax with ListSyntax {

  private val component = ScalaFnComponent.withHooks[ContainerPage]
    .render { props =>
      val widenChildrens = props
        .children
        .zipWithIndex
        .map { case (child, index) => Fragment.withKey(index)(child).rawElement }
        .widen[
          Empty | String | JsNumber | japgolly.scalajs.react.facade.React.Element
        ]

      PageContainer.withProps(
        PageContainerProps()
          .setLoading(props.loading)
          .setFixedHeader(props.fixedHeader)
          .setAffixProps(OmitAffixPropschildren().setOffsetTop(56D))
          .applyOption(props.title)((builder, value) =>
            builder.setTitle(value)
          )
          .applyOption(props.subTitle)((builder, value) =>
            builder.setSubTitle(value)
          )
          .applyOption(props.tooltipTitle)((builder, value) =>
            builder.setSubTitle(
              TooltipWithIcon()
                .setTitle(value)
                .setIconStyle(commonStyle.pageTitleTooltip)
                .render
            )
          )
          .applyWhen(props.tags.nonEmpty)(_.setTags(props.tags.toJSArray))
          .applyOption(props.content)((builder, value) => builder.setContent(value))
          .applyWhen(props.extra.nonEmpty) { builder =>
            val widenExtra = props
              .extra
              .zipWithIndex
              .map { case (child, index) => Fragment.withKey(index)(child).rawElement }

            builder.setExtraVarargs(widenExtra: _*)
          }
          .setChildrenVarargs(widenChildrens: _*)
      )
    }

}
