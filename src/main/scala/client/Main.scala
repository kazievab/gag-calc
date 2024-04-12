package client

import scala.scalajs.js.annotation.JSExportTopLevel

import org.scalajs.dom

import router.AppRouter

object Main {

  @JSExportTopLevel("main")
  def main(args: Array[String]): Unit = {
    val root = dom.document.getElementById("root")

    AppRouter.router().renderIntoDOM(root)
  }

}
