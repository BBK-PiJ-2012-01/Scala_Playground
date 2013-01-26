package one

/**
 * User: Sam Wright
 * Date: 25/01/2013
 * Time: 20:47
 */
object Comprehensions extends App {
  val lst = for (x <- 0 to 5 if (x%2 == 0); y <- 0 to 2) yield "(%d,%d)".format(x, y)
  println(lst)
}
