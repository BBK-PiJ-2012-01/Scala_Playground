package one

import scala.collection.mutable.ListBuffer

/**
 * User: Sam Wright
 * Date: 25/01/2013
 * Time: 18:56
 */
object Currying {
  def addNtoM(n:Int)(m:Int) : Int = { n + m }
}

object CurryingTest extends App {
  // Simple test
  println("3 + 4 = " + Currying.addNtoM(3)(4))

  // Add three to all values of a list
  val lst = (0 to 10).toList
  println(lst)
  val lst2 = lst.map(Currying.addNtoM(5))
  println(lst2)
  val lst3 = lst map Currying.addNtoM(7)
  println(lst3)

//  val buf = new ListBuffer[Int]
//  buf.append(7)
}
