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
        "org.typelevel" %%% "cats-core"                 % "2.10.0",
        "io.circe"      %%% "circe-core"                % "0.14.5",
        "io.circe"      %%% "circe-parser"              % "0.14.5",
        "io.circe"      %%% "circe-generic"             % "0.14.5",
        "io.circe"      %%% "circe-generic-extras"      % "0.14.3",
        "com.beachape"  %%% "enumeratum-circe"          % "1.7.3",
        "org.scala-js"  %%% "scalajs-dom"               % "2.8.0",
        "org.scala-js"  %%% "scalajs-java-securerandom" % "1.0.0",
        "com.github.japgolly.scalajs-react" %%% "core"  % "2.2.0-beta2",
        "com.github.japgolly.scalajs-react" %%% "extra" % "2.2.0-beta2"
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
