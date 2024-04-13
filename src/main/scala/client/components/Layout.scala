package client.components

import client.router.AppRouter.Page
import client.utils.localization.useTranslation
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.extra.router.{Resolution, RouterCtl}
import typings.antDesignProProvider.components.ProConfigProvider
import typings.antd.{esLocaleEnUSMod, esLocaleRuRUMod}
import typings.antd.{components => Antd}

object Layout {

  final case class Props(
    router: RouterCtl[Page],
    r: Resolution[Page]
  )

  val component = ScalaFnComponent.withHooks[Props]
    .render { props =>
      val (_, i18n) = useTranslation()
      val antdLocale =
        if (i18n.language.contains("en")) esLocaleEnUSMod.default
        else esLocaleRuRUMod.default

      Antd.ConfigProvider(
        ProConfigProvider(
          Antd.App(props.r.render())
        )
      )
        .locale(antdLocale)
    }

}
