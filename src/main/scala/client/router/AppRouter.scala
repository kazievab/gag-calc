package client.router

import client.components.Layout
import client.pages.DeityTechnologyPage
import japgolly.scalajs.react.extra.router._

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
      staticRoute(RootPage.path, RootPage) ~> render(DeityTechnologyPage().render)
    )
      .notFound(redirectToPage(RootPage)(SetRouteVia.HistoryReplace))
  }.renderWith(layout)

  def layout(c: RouterCtl[Page], r: Resolution[Page]) = Layout.component(Layout.Props(c, r))

  val baseUrl = BaseUrl.fromWindowOrigin / "gag-calc"

  val router = Router(baseUrl, routerConfig)
}
