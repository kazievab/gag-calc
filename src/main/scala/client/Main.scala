package client

import org.scalajs.dom
import router.AppRouter

import scala.scalajs.js.annotation.JSExportTopLevel

object Main {

  @JSExportTopLevel("main")
  def main(args: Array[String]): Unit = {
    val root = dom.document.getElementById("root")

    AppRouter.router().renderIntoDOM(root)
  }

}
