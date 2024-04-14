package client.utils.localization

import scala.scalajs.js
import typings.i18next.mod.{InitOptions, InterpolationOptions, Resource, default => i18n}
import typings.i18nextBrowserLanguagedetector.mod.{default => LanguageDetector}
import typings.reactI18next.mod.initReactI18next

import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("virtual:i18next-loader", JSImport.Namespace)
object resources extends Resource

object I18n {
  def default = i18n

  def init() = default
    .use(new LanguageDetector)
    .use(initReactI18next)
    .init(
      InitOptions()
        .setResources(resources)
        .setFallbackLng("ru")
        .setDebug(true)
        .setInterpolation(InterpolationOptions().setEscapeValue(false))
    )

}
