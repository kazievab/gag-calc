package client.router

import client.components.Layout
import client.pages.{GodsTechnologyListPage, GodsTechnologyViewPage}
import japgolly.scalajs.react.callback.CallbackTo
import japgolly.scalajs.react.component.ScalaFn.Unmounted
import japgolly.scalajs.react.extra.router._

import java.util.UUID

object AppRouter {

  def Default: Route = GodsTechnologyListRoute

  sealed trait Route {
    def path: String = ""
  }

  case object GodsTechnologyListRoute extends Route {
    override def path: String = "/technology"
  }

  case class GodsTechnologyViewRoute(id: UUID) extends Route {
    override def path: String = s"/technology/$id/view"
  }

  val routerConfig = RouterConfigDsl[Route].buildConfig { dsl =>
    import dsl._

    (
      staticRoute(GodsTechnologyListRoute.path, GodsTechnologyListRoute) ~> renderR(GodsTechnologyListPage(_).render) |
        dynamicRouteCT[GodsTechnologyViewRoute](
          ("/technology" / uuid / "view").caseClass[GodsTechnologyViewRoute]
        ) ~> dynRenderR((p, r) => GodsTechnologyViewPage(r, p.id).render)
    )
      .notFound(redirectToPage(Default)(SetRouteVia.HistoryReplace))
  }.renderWith(layout)

  private def layout(c: RouterCtl[Route], r: Resolution[Route]): Unmounted[Layout.Props] =
    Layout.component(Layout.Props(c, r))

  private val baseUrl: BaseUrl = BaseUrl.fromWindowOrigin / "gag-calc"

  val router: RouterF[CallbackTo, Route] = Router(baseUrl, routerConfig)
}
