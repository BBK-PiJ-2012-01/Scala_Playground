package elements

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 22:36
 */
object Elements extends App {
  class Parent(val foo: String = "default")
  class Child(val bar: String) extends Parent(bar)
  new Parent().foo
  new Parent("foo!").foo
  new Child("hi").foo


}