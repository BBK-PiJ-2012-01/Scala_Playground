package functions

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 17:10
 */
object PartialFunctions extends App {
  def sum(a:Int, b:Int, c:Int): Int = { a + b + c }

  def sumPlus5 = sum(5, _:Int, _:Int)
  println("Five plus sum(1,2) = " + sumPlus5(1,2))

  val sum_plus_1 = sum(_:Int, 1, _:Int)
  println("1 plus sum(2,3) = " + sum_plus_1(2,3))

}
