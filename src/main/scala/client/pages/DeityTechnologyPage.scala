package client.pages

import scala.scalajs.js.JSConverters.JSRichIterableOnce
import cats.implicits.catsSyntaxOptionId
import client.components.ui.{ActionMenu, ContainerPage}
import client.models.ActionItem
import client.utils.localization.useTranslation
import client.utils.syntax.IdentitySyntax
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.callback.{AsyncCallback, Callback}
import japgolly.scalajs.react.util.DefaultEffects._
import japgolly.scalajs.react.vdom.all._
import typings.antd.{antdStrings, components => Antd}

import scala.scalajs.js

final case class DeityTechnologyPage() {
  @inline def render: VdomElement = DeityTechnologyPage.component(this)
}

object DeityTechnologyPage extends IdentitySyntax {

  private class ListItem(
    val id: Int,
    val title: String,
    val description: String
  ) extends js.Object

  private val component = ScalaFnComponent.withHooks[DeityTechnologyPage]
    .render { props =>
      val (t, _) = useTranslation()
      val dataSource = List.empty[ListItem]

      val extraActions = List(
        ActionItem.Create(
          onClick = Callback.empty
        )
      )

      val extra = ActionMenu(extraActions).render

      val actions = (item: ListItem) =>
        List(
          ActionItem.Edit(
            onClick = Callback.empty
          ),
          ActionItem.DeleteConfirm(
            onConfirm = Callback.empty
          )
        )

      val list = Antd.List[ListItem]()
        .size(antdStrings.small)
        .bordered(true)
        .dataSource(dataSource.toJSArray)
        .renderItem((item, index) =>
          Antd.List.Item(
            Antd.List.Item.Meta().title(
              a(
                onClick --> Callback.empty,
                item.title
              )
            )
          )
            .extra(
              ActionMenu()
                .setActions(actions(item))
                .render
                .rawNode
            )
            .onClick(_ => Callback.empty)
            .withKey(index)
            .rawNode
        )

      ContainerPage()
        .setTitle(t("technology:PageTitle"))
        .setTooltipTitle(t("technology:PageTitleTooltip"))
        .setExtra(extra)
        .setChildrenVarargs(list)
        .render
    }

}
