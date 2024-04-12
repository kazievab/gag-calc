package client.router

import client.components.Layout
import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.all._

object AppRouter {

  sealed trait Page {
    def path: String = "unknown"
  }

  case object RootPage extends Page {
    override def path: String = "/"
  }

  val routerConfig = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._

    (
      staticRoute(RootPage.path, RootPage) ~> render(div(""))
    )
      .notFound(redirectToPage(RootPage)(SetRouteVia.HistoryReplace))
  }.renderWith(layout)

  def layout(c: RouterCtl[Page], r: Resolution[Page]) = Layout.component(Layout.Props(c, r))

  val baseUrl = BaseUrl.fromWindowOrigin

  val router = Router(baseUrl, routerConfig)
}
