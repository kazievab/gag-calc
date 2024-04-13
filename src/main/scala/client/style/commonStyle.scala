package client.style

import typings.csstype.csstypeStrings
import typings.react.mod.CSSProperties

object commonStyle {
  val normalizeToCustomIcon: CSSProperties = CSSProperties().setFontSize("1.2em").setMarginTop("0.2em")

  def loading(isCollapsedSider: Boolean): CSSProperties = CSSProperties()
    .setPosition(csstypeStrings.fixed)
    .setTop("50%")
    .setLeft(
      if (isCollapsedSider) "calc(50% + 32px)"
      else "calc(50% + 108px)"
    )
    .setZIndex(11000)

  val defaultLightAvatar: CSSProperties = CSSProperties().setColor("rgba(0, 0, 0, 0.65)")

  val menuFooterTooltip: CSSProperties = CSSProperties().setLeft("64px")

  val pageTitleTooltip: CSSProperties = CSSProperties().setMarginTop("7px")

  val pageTitleTooltipInner: CSSProperties = CSSProperties().setTextAlign(csstypeStrings.center)

  val toolbar: CSSProperties = CSSProperties().setMarginBottom("5px")

  val stackModalList: CSSProperties = CSSProperties()
    .setHeight("350px")
    .setOverflow(csstypeStrings.auto)

  val stackModalListHeader: CSSProperties = CSSProperties()
    .setMarginTop("5px")
    .setMarginBottom("5px")

  val scriptViewEditor: CSSProperties = CSSProperties()
    .setHeight("500px")
    .setOverflow(csstypeStrings.auto)

  val hide: CSSProperties = CSSProperties().setDisplay(csstypeStrings.none)

  val stepContent: CSSProperties = CSSProperties().setMarginTop(16D)

  val proListTitle = CSSProperties().setPaddingLeft("5px").setOverflowWrap(csstypeStrings.`break-word`)

  val proListContent = CSSProperties().setHeight(60)

  val listViewSettingsNotTop = CSSProperties().setOpacity(0.5D)

  val expandIcon = CSSProperties().setFontSize(12D)

  val hideBackgroundBorder = CSSProperties().setBackgroundColor("rgba(0, 0, 0, 0)").setCursor(csstypeStrings.auto)

  val blue = CSSProperties().setColor("#1677ff")

  val pink = CSSProperties().setColor("#f433ab")

  val orange = CSSProperties().setColor("#fc7a1e")

  val stackLoading = CSSProperties().setColor("#0065ff")
}
