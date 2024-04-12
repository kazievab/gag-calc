import org.scalajs.linker.interface.ModuleSplitStyle
import org.typelevel.scalacoptions.ScalacOptions
import sbt.Keys.scalacOptions

import scala.collection.Seq

Global / scalaVersion := "2.13.12"

lazy val client = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin, ScalablyTypedConverterExternalNpmPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("client")))
    },
    libraryDependencies ++=
      Seq(
        "org.scala-js"                      %%% "scalajs-dom" % "2.6.0",
        "com.github.japgolly.scalajs-react" %%% "core"        % "2.1.1",
        "com.github.japgolly.scalajs-react" %%% "extra"       % "2.1.1"
      ),
    stFlavour := Flavour.ScalajsReact,
    stIgnore ++= List("react-dom", "typescript"),
    externalNpm := baseDirectory.value,
    tpolecatExcludeOptions :=
      Set(
        ScalacOptions.fatalWarnings,
        ScalacOptions.warnError,
        ScalacOptions.warnValueDiscard,
        ScalacOptions.privateWarnValueDiscard,
        ScalacOptions.warnDeadCode,
        ScalacOptions.privateWarnDeadCode,
        ScalacOptions.lintInferAny,
        ScalacOptions.warnNonUnitStatement
      ),
    scalacOptions ++= Seq("-Ymacro-annotations", "-Wconf:src=target/.*:s")
  )

Global / onChangedBuildSource := ReloadOnSourceChanges
