
lazy val root = (project in file("."))
  .enablePlugins(JettyPlugin)
  .settings(
    organization := "ciukstar.com",
    name := "cooper",
    version := "0.1.0",
    scalaVersion in ThisBuild := "2.11.8",
    parallelExecution in Test := false,
    containerLibs in Jetty := Seq(
      "org.eclipse.jetty" % "jetty-runner" % "9.3.13.v20161014",
      "com.h2database" % "h2" % "1.4.192"
    ),
    containerMain in Jetty := "org.eclipse.jetty.runner.Runner",
    libraryDependencies ++= {
      val liftVersion = "3.0-RC4"
      Seq(
        "net.liftweb" %% "lift-webkit" % liftVersion,
        "net.liftweb" %% "lift-json" % liftVersion,
        "org.eclipse.jetty" % "jetty-webapp" % "9.3.13.v20161014",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016",
        "org.squeryl" %% "squeryl" % "0.9.7",
        "com.h2database" % "h2" % "1.4.192",
        "c3p0" % "c3p0" % "0.9.1.2",
        "org.scalactic" %% "scalactic" % "3.0.0",
        "org.scalatest" %% "scalatest" % "3.0.0" % "test"
      )
    }    
  )
