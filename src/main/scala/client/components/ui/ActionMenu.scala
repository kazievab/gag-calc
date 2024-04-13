package client.components.ui

import client.components.ui.Tooltip.Tooltip
import client.models.ActionItem
import client.style.commonStyle
import client.utils.localization.useTranslation
import client.utils.syntax.IdentitySyntax
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.vdom.all._
import typings.antDesignIcons.components.AntdIcon
import typings.antDesignIconsSvg.esAsnDeleteOutlinedMod.{default => DeleteOutlinedIcon}
import typings.antDesignIconsSvg.esAsnEditOutlinedMod.{default => EditOutlinedIcon}
import typings.antd.{antdStrings, components => Antd}

final case class ActionMenu(
  actions: List[ActionItem] = Nil
) {
  def setActions(actions: List[ActionItem]): ActionMenu = copy(actions = actions)

  @inline def render: VdomElement = ActionMenu.component(this)
}

object ActionMenu extends IdentitySyntax {

  private val component = ScalaFnComponent.withHooks[ActionMenu]
    .render { props =>
      val (t, _) = useTranslation()

      val getMenuItem = (actionItem: ActionItem) =>
        actionItem match {
          case item: ActionItem.Create => Antd.Button(t("common:Create"))
              .`type`(antdStrings.primary)
              .onClick(_ => item.onClick)
              .disabled(item.disabled)
              .rawNode
          case item: ActionItem.Edit =>
            if (item.icon) Tooltip()
              .setTitle(t("common:Edit"))
              .setChildren(
                Antd.Button()
                  .icon(
                    AntdIcon(EditOutlinedIcon)
                      .style(commonStyle.normalizeToCustomIcon)
                  )
                  .`type`(antdStrings.text_)
                  .disabled(item.disabled)
                  .onClick(_ => item.onClick)
              )
              .render
              .rawNode
            else Antd.Button(t("common:Edit"))
              .`type`(antdStrings.primary)
              .onClick(_ => item.onClick)
              .disabled(item.disabled)
              .rawNode
          case item: ActionItem.DeleteConfirm => Tooltip()
              .setTitle(t("common:Delete"))
              .setChildren(
                Antd.Popconfirm(
                  Antd.Button()
                    .icon(
                      AntdIcon(DeleteOutlinedIcon)
                        .style(commonStyle.normalizeToCustomIcon)
                    )
                    .`type`(antdStrings.text_)
                    .disabled(item.disabled)
                )
                  .title(t("common:DeleteItem"))
                  .description(t("common:DeleteItemConfirm"))
                  .okText(t("common:Yes"))
                  .cancelText(t("common:No"))
                  .okType(antdStrings.danger)
                  .applyUndef(item.open)((builder, value) => builder.open(value))
                  .applyUndef(item.onOpenChange)((builder, value) => builder.onOpenChange((open, _) => value(open)))
                  .onConfirm(_ => item.onConfirm)
                  .disabled(item.disabled)
              )
              .render
              .rawNode
        }

      val actions = props.actions
        .zipWithIndex
        .toVdomArray { case (action, index) => div(key := index, getMenuItem(action)) }

      Antd.Space(actions)
        .size(antdStrings.small)
        .wrap(true)
    }

}
