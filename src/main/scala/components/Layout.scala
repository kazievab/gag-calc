package components

import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.extra.router.{Resolution, RouterCtl}
import japgolly.scalajs.react.vdom.all._
import roter.AppRouter.Page

object Layout {

  final case class Props(
    router: RouterCtl[Page],
    r: Resolution[Page]
  )

  val component = ScalaFnComponent.withHooks[Props]
    .render(_ => div("Test1"))

}
