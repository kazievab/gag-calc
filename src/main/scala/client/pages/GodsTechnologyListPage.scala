package client.pages

import scala.scalajs.js.JSConverters.JSRichIterableOnce
import cats.implicits.catsSyntaxOptionId
import client.components.ui.{ActionMenu, ContainerPage}
import client.models.ActionItem
import client.models.gods.technology.GodsTechnology
import client.router.AppRouter.{GodsTechnologyViewRoute, Route}
import client.utils.localization.useTranslation
import client.utils.syntax.IdentitySyntax
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.callback.{AsyncCallback, Callback}
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.util.DefaultEffects._
import japgolly.scalajs.react.vdom.all._
import typings.antd.{antdStrings, components => Antd}

import java.util.UUID
import scala.scalajs.js

final case class GodsTechnologyListPage(r: RouterCtl[Route]) {
  @inline def render: VdomElement = GodsTechnologyListPage.component(this)
}

object GodsTechnologyListPage extends IdentitySyntax {

  private class ListItem(
    val id: UUID,
    val title: String,
    val description: String
  ) extends js.Object

  private val component = ScalaFnComponent.withHooks[GodsTechnologyListPage]
    .useState(Seq.empty[GodsTechnology])
    .render { (props, entitiesHook) =>
      val (t, _) = useTranslation()
      val entities = Seq(GodsTechnology.example(t)) ++ entitiesHook.value
      val dataSource = entities.map(entity =>
        new ListItem(
          entity.id,
          entity.title,
          entity.description
        )
      )

      val extraActions = List(
        ActionItem.Create(
          onClick = Callback.empty
        )
      )

      val extra = ActionMenu(extraActions).render

      val actions = (item: ListItem) =>
        List(
          ActionItem.View(
            onClick = props.r.set(GodsTechnologyViewRoute(item.id))
          ),
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
            Antd.List.Item.Meta()
              .title(
                a(
                  onClick --> props.r.set(GodsTechnologyViewRoute(item.id)),
                  item.title
                )
              )
              .description(item.description)
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
