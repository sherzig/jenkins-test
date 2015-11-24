package gov.nasa.jpl.imce.devenc.ci.jenkins.test.testcases

import gov.nasa.jpl.imce.devenv.ci.jenkins.test.HelloWorldClass
import org.scalatest._

/**
  * Created by sherzig on 11/23/15.
  */
class HelloWorldTest extends FlatSpec with Matchers {

  val hwo = new HelloWorldClass()

  it should "return 'Hello world!'" in {
    hwo.whatToSayWhenFooed() should be ("Hello world!")
  }

}
