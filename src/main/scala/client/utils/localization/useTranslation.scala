package client.utils.localization

import scala.scalajs.js

import typings.i18next.mod.{TOptionsBase, i18n}

trait TFunction {
  def apply(key: String): String

  def apply(key: String, options: js.Object): String
}

object useTranslation {

  def apply(): (TFunction, i18n) = {
    val js.Tuple3(t, i18n, _) = typings.reactI18next.mod.useTranslation()

    val tImpl = new TFunction {
      override def apply(key: String): String = t[String, String, js.Object](key)
      override def apply(key: String, options: js.Object): String =
        t[String, String, js.Object](key, options.asInstanceOf[TOptionsBase with js.Object])
    }

    (tImpl, i18n)
  }

}
