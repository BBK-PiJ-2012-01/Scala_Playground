package scala_collections

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 18:04
 */
object Tuple extends App {
  val l = (1, 0, 0)
  println("%s %s".format(l.getClass.toString, l.toString()))

  val k = 1 :: 2 :: List(3, 4)
  println("%s %s".format(k.getClass.toString, k.toString()))
}
