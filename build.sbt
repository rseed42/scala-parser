//------------------------------------------------------------------------------
// Project Information
//------------------------------------------------------------------------------
version := "0.01"
name := "scala-parser"
scalaVersion := "2.11.8"

//------------------------------------------------------------------------------
// Dependencies
//------------------------------------------------------------------------------

libraryDependencies ++= Seq (
  "com.beust"                     %  "jcommander"                       % Version.jcommander,
  "org.scala-lang.modules"        %  "scala-parser-combinators_2.11"    % Version.scalamodules,
  "org.scalatest"                 %% "scalatest"                        % Version.scalatest         % "test"
)

//------------------------------------------------------------------------------
// Assembly
//------------------------------------------------------------------------------
// We do the tests in out CI setup. No need to slow down the assembly unless we
// are really paranoid (which maybe we should be :)):
test in assembly := {}

// If you want to exclude local jar file dependencies from the final
// assembly (like a 100 MB  trend data parser :)), you can do so here. Do not
// forget to specify its location with the --jars parameter on submit

//------------------------------------------------------------------------------
// Run configuration
//------------------------------------------------------------------------------

scalacOptions ++= Seq(
  "-deprecation",
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Ywarn-unused-import"
)

javacOptions ++= Seq(
  "-source", "1.8",
  "-target", "1.8")

wartremover.wartremoverErrors in (Compile, compile) ++= Seq(
  wartremover.Wart.Any,
  wartremover.Wart.Serializable
)

//------------------------------------------------------------------------------
// Testing configuration
//------------------------------------------------------------------------------
//parallelExecution in Test := false
//javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
