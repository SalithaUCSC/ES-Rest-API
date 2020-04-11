name := """es-rest-api"""
organization := "com.ncinga"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.8.1"
libraryDependencies += "log4j" % "log4j" % "1.2.17"
libraryDependencies += "org.elasticsearch" % "elasticsearch" % "6.5.2"
libraryDependencies += "org.elasticsearch.client" % "transport" % "6.5.2"
libraryDependencies += "org.elasticsearch.client" % "elasticsearch-rest-high-level-client" % "6.5.2"

libraryDependencies ++= Seq(
  guice,
  javaWs
)

