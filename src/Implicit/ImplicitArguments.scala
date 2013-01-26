package Implicit

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 15:51
 */
object ImplicitArguments extends App {
  def printout(preamble: String)(implicit d: Int) {
    println(preamble + " : " + d)
  }

  printout("explicit")(1)

  implicit val d: Int = 3

  printout("implicit")


  trait Adder[T] {
    def add(obj1:T, obj2:T): T
  }

  implicit object StringAdder extends Adder[String] {
    def add(obj1: String, obj2: String): String = obj1.concat(obj2)
  }

  implicit object IntAdder extends Adder[Int] {
    def add(obj1: Int, obj2: Int): Int = obj1 + obj2
  }

  def add[T](obj1:T, obj2:T)(implicit adder: Adder[T]): T = {
    adder.add(obj1, obj2)
  }

  println(add(1, 2))
  println(add("One", "Two"))



}
