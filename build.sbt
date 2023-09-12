import org.typelevel.scalacoptions.ScalacOptions

import java.nio.file.Files
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

Global / scalaVersion := "2.13.11"
Global / excludeLintKeys ++= Set(webpackExtraArgs, webpackDevServerPort)

resolvers +=
  "Sonatype S01 OSS Snapshots".at(
    "https://s01.oss.sonatype.org/content/repositories/snapshots"
  )

enablePlugins(ScalaJSPlugin, ScalablyTypedConverterPlugin)

scalaJSUseMainModuleInitializer := true
scalaJSLinkerConfig := scalaJSLinkerConfig.value.withSourceMap(false)
stFlavour := Flavour.ScalajsReact

Compile / npmDependencies ++=
  Seq(
    "react" -> "17.0.2",
    "react-dom" -> "17.0.2",
    "@types/react" -> "17.0.65",
    "@types/react-dom" -> "17.0.20",
    "csstype" -> "3.1.2",
    "@types/prop-types" -> "15.7.5",
    "antd" -> "5.8.5",
    "@ant-design/icons" -> "5.2.6",
    "@ant-design/pro-components" -> "2.6.18"
  )

Compile / npmDevDependencies ++=
  Seq(
    "webpack-merge" -> "5.9.0",
    "css-loader" -> "6.8.1",
    "style-loader" -> "3.3.3",
    "file-loader" -> "6.2.0"
  )

Compile / npmResolutions ++=
  (Compile / npmDependencies).value.toMap ++
    (Compile / npmDevDependencies).value.toMap

libraryDependencies ++=
  Seq(
    "org.scala-js"                      %%% "scalajs-dom" % "2.6.0",
    "com.github.japgolly.scalajs-react" %%% "core"        % "2.1.1",
    "com.github.japgolly.scalajs-react" %%% "extra"       % "2.1.1"
  )

useYarn := true
yarnExtraArgs := Seq("--silent")

webpackCliVersion := "4.10.0"
webpackDevServerPort := 8000
Compile / fastOptJS / webpackExtraArgs += "--mode=development"
Compile / fullOptJS / webpackExtraArgs += "--mode=production"
Compile / fastOptJS / webpackDevServerExtraArgs += "--mode=development"
Compile / fullOptJS / webpackDevServerExtraArgs += "--mode=production"

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
  )

scalacOptions ++= Seq("-Ymacro-annotations", "-Wconf:src=target/.*:s")

lazy val start = TaskKey[Unit]("start")

lazy val dist = TaskKey[File]("dist")

/** Implement the `start` and `dist` tasks defined above. Most of this is really
  * just to copy the index.html file around.
  */
start := (Compile / fastOptJS / startWebpackDevServer).value

dist := {
  val artifacts = (Compile / fullOptJS / webpack).value
  val artifactFolder = (Compile / fullOptJS / crossTarget).value
  val distFolder = (ThisBuild / baseDirectory).value / "docs"

  distFolder.mkdirs()
  artifacts.foreach { artifact =>
    val target = artifact.data.relativeTo(artifactFolder) match {
      case None          => distFolder / artifact.data.name
      case Some(relFile) => distFolder / relFile.toString
    }

    Files.copy(artifact.data.toPath, target.toPath, REPLACE_EXISTING)
  }

  val indexFrom = baseDirectory.value / "src/main/js/index.html"
  val indexTo = distFolder / "index.html"

  val indexPatchedContent = {
    import collection.JavaConverters.*
    Files
      .readAllLines(indexFrom.toPath, IO.utf8)
      .asScala
      .map(_.replaceAllLiterally("-fastopt-", "-opt-"))
      .mkString("\n")
  }

  Files.write(indexTo.toPath, indexPatchedContent.getBytes(IO.utf8))
  distFolder
}

Global / onChangedBuildSource := ReloadOnSourceChanges
