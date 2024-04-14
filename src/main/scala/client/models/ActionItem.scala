package client.models

import japgolly.scalajs.react.callback.Callback

import scala.scalajs.js

sealed trait ActionItem {
  def disabled: Boolean
}

object ActionItem {

  case class Create(
    onClick: Callback,
    disabled: Boolean = false
  ) extends ActionItem

  case class Edit(
    onClick: Callback,
    icon: Boolean = true,
    disabled: Boolean = false
  ) extends ActionItem

  case class View(
    onClick: Callback,
    icon: Boolean = true,
    disabled: Boolean = false
  ) extends ActionItem

  case class Back(
    onClick: Callback,
    disabled: Boolean = false
  ) extends ActionItem

  case class DeleteConfirm(
    onConfirm: Callback,
    disabled: Boolean = false,
    open: js.UndefOr[Boolean] = js.undefined,
    onOpenChange: js.UndefOr[Boolean => Callback] = js.undefined
  ) extends ActionItem

}
