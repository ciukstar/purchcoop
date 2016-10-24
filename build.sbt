
lazy val root = (project in file(".")).settings(
  organization := "ciukstar.com",
  name := "purchasing-cooperative",
  version := "0.1.0",
  scalaVersion := "2.11.8",
  libraryDependencies := {
    val liftVersion = "3.0-RC4"
    Seq(
      "net.liftweb" %% "lift-webkit" % liftVersion,
      "org.scalactic" %% "scalactic" % "3.0.0",
      "org.scalatest" %% "scalatest" % "3.0.0" % "test",
      "org.h2database" % "h2" % "1.4.192" % "test",
      "c3p0" % "c3p0" % "0.1.9.2" % "test"
    )
  }
)
