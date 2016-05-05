version := "1.0"

scalaVersion := "2.11.7"

enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"

libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.12.0"

scalaJSUseRhino in Global := false