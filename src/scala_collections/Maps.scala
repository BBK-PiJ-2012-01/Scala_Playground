package scala_collections

/**
 * User: Sam Wright
 * Date: 27/01/2013
 * Time: 22:39
 */
object Maps extends App {
  val map = Map(7 -> "seven", 8 -> "eight")
  println(map(7))
  val new_map = map + (9 -> "nine")

  println(s"new map = $new_map")

}