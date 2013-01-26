package match_examples

import runtime.DoubleRef

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 16:22
 */
object Extractors extends App {
  // Gives case class deconstruction to non-case class objects
  object Doubler {
    def apply(value: Int): Int = { 2 * value }
    def unapply(value: Int): Option[Int] = { Some(value / 2) }
  }

  val value: Int = Doubler(3)

  value match {
    case Doubler(2) => println("Found 2")
    case Doubler(n) => println(n)
  }
}
