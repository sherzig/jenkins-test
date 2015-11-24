package gov.nasa.jpl.imce.devenc.ci.jenkins.test.testcases

import gov.nasa.jpl.imce.devenv.ci.jenkins.test.HelloWorldClass
import org.scalatest._

/**
  * Created by sherzig on 11/23/15.
  */
class SquaringTest extends FlatSpec with Matchers {

  val hwo = new HelloWorldClass()

  it should "return the square of the argument" in {
    val square2 = hwo.calculateSquare(2)
    square2 should be (4)

    val square4 = hwo.calculateSquare(4)
    square4 should be (16)

    val square12 = hwo.calculateSquare(12)
    square12 should be (144)
  }

}
