package client.pages

import client.components.ui.{ActionMenu, ContainerPage}
import client.models.ActionItem
import client.models.gods.technology.GodsTechnology
import client.router.AppRouter.{GodsTechnologyListRoute, Route}
import client.utils.localization.useTranslation
import client.utils.syntax.IdentitySyntax
import japgolly.scalajs.react.ScalaFnComponent
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.util.DefaultEffects._
import japgolly.scalajs.react.vdom.all._
import typings.antDesignProCard.antDesignProCardStrings
import typings.antDesignProCard.components.StatisticCard
import typings.antDesignProCard.esComponentsStatisticMod.StatisticProps
import typings.antd.{antdStrings, components => Antd}
import typings.rcCollapse.esInterfaceMod.ItemType
import typings.rcCollapse.rcCollapseStrings

import java.util.UUID
import scala.scalajs.js
import scala.scalajs.js.JSConverters.JSRichIterableOnce

final case class GodsTechnologyViewPage(r: RouterCtl[Route], id: UUID) {
  @inline def render: VdomElement = GodsTechnologyViewPage.component(this)
}

object GodsTechnologyViewPage extends IdentitySyntax {

  private class ListItem(
    val id: String,
    val title: String,
    val description: String
  ) extends js.Object

  private val component = ScalaFnComponent.withHooks[GodsTechnologyViewPage]
    .useState(Option.empty[GodsTechnology])
    .useEffectOnMountBy { (props, entityHook) =>
      val (t, _) = useTranslation()
      val example = GodsTechnology.example(t)

      entityHook.setState(Some(example)).when_(props.id == example.id)
    }
    .render { (props, entityHook) =>
      val (t, _) = useTranslation()
      val entityO = entityHook.value
      val title = entityO.map(_.title).mkString

      val extraActions = List(
        ActionItem.Back(
          onClick = props.r.set(GodsTechnologyListRoute)
        )
      )

      val extra = ActionMenu(extraActions).render

      val statistic = entityO.toVdomArray(entity =>
        StatisticCard.Group(
          StatisticCard()
            .statistic(
              StatisticProps()
                .setTitle(t("technology:Resources.Acceleration"))
                .setTip("Текст справки")
                .setPrecision(0)
                .setValue(entity.totalTimeResearchTimeCost)
            ),
          StatisticCard.Divider().`type`(antDesignProCardStrings.vertical),
          StatisticCard()
            .statistic(
              StatisticProps()
                .setTitle(t("technology:Resources.Wood"))
                .setTip("Текст справки")
                .setPrecision(0)
                .setValue(entity.currentWoodResearchCost)
                .setDescription(
                  StatisticCard.Statistic()
                    .title(t("technology:ResearchCost"))
                    .value(entity.woodResearchCostPercent)
                    .trend(antDesignProCardStrings.down)
                )
            ),
          StatisticCard()
            .statistic(
              StatisticProps()
                .setTitle(t("technology:Resources.Gold"))
                .setTip("Текст справки")
                .setPrecision(0)
                .setValue(entity.currentGoldResearchCost)
                .setDescription(
                  StatisticCard.Statistic()
                    .title(t("technology:ResearchCost"))
                    .value(entity.goldResearchCostPercent)
                    .trend(antDesignProCardStrings.down)
                )
            ),
          StatisticCard()
            .statistic(
              StatisticProps()
                .setTitle(t("technology:Resources.Stone"))
                .setTip("Текст справки")
                .setPrecision(0)
                .setValue(entity.currentStoneResearchCost)
                .setDescription(
                  StatisticCard.Statistic()
                    .title(t("technology:ResearchCost"))
                    .value(entity.stoneResearchCostPercent)
                    .trend(antDesignProCardStrings.down)
                )
            ),
          StatisticCard()
            .statistic(
              StatisticProps()
                .setTitle(t("technology:Resources.Stardust"))
                .setTip("Текст справки")
                .setPrecision(0)
                .setValue(entity.currentStardustResearchCost)
                .setDescription(
                  StatisticCard.Statistic()
                    .title(t("technology:ResearchCost"))
                    .value(entity.stardustResearchCostPercent)
                    .trend(antDesignProCardStrings.down)
                )
            )
        )
      ).rawNode

      val items = List(
        ItemType()
          .setKey("1")
          .setLabel(t("technology:Total"))
          .setCollapsible(rcCollapseStrings.header)
          .setChildren(statistic)
      )

      val content = Antd.Collapse()
//        .ghost(true)
        .defaultActiveKeyVarargs("1")
        .items(items.toJSArray)

      ContainerPage()
        .setTitle(title)
        .setExtra(extra)
        .setContent(content)
        .render
    }

}
