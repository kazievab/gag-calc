package client

import client.utils.localization.I18n
import japgolly.scalajs.react.ReactDOMClient

import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom
import router.AppRouter

object Main {

  @JSExportTopLevel("main")
  def main(args: Array[String]): Unit = {
    I18n.init()

    val root = dom.document.getElementById("root")

    ReactDOMClient.createRoot(root).render(AppRouter.router())
  }

}
