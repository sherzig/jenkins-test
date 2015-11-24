package gov.nasa.jpl.imce.devenv.ci.jenkins.test

/** Main entry point into the sample project.
  *
  * @author Sebastian.J.Herzig
  * @version 1.0
  */
object SampleProject {

  def main(args: Array[String]) {
    def hwo = new HelloWorldClass()
    hwo.sayHello()
  }

}