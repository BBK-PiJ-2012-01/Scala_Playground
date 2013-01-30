package functions

/**
 * User: Sam Wright
 * Date: 30/01/2013
 * Time: 12:31
 */
object LazyEvaluation extends App {
  class Clazz {
    lazy val lazy_string: String = {
      println("Creating string!")
      "string"
    }

    def saySomething() {
      println("saying something...")
    }


  }

  val obj = new Clazz()
  obj.saySomething()
  println(obj.lazy_string)
  println(obj.lazy_string)
  println(obj.lazy_string)
}
