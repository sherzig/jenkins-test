package gov.nasa.jpl.imce.devenv.ci.jenkins.test

/** Elaborate version of a "Hello World" program to test integration with Jenkins and the possibilities
  * that come with it - e.g., automated scaladoc generation, feature branch detection, etc.
  *
  * @author Sebastian.J.Herzig
  * @version 1.0
  */
class HelloWorldClass {

  val helloWorld = "Hello world!"

  /** Prints "Hello world!" to the terminal
    */
  def sayHello() = saySomething(helloWorld)

  /** Returns the hello world string.
    *
    * @return the hello world string
    */
  def whatToSayWhenFooed(): String = helloWorld

  /** Function that prints a string to the terminal.
    *
    * Note that the function does not return anything (this should be on the second line, by the way).
    *
    * @param something the thing to say
    */
  def saySomething(something: String) =
    println(something)

  /** Determines the square of the argument.
    *
    * @param x The argument to build the square of
    * @return The square of the argument
    */
  def calculateSquare(x: Int): Int = x * x

  /** Function that outputs "foo" to the command line
    */
  def fooFunction() = saySomething("foo-foo-foo")

}