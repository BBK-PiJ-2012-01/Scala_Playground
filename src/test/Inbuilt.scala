package test

/**
 * User: Sam Wright
 * Date: 28/01/2013
 * Time: 15:47
 */
object Inbuilt extends App {

  class PositiveList(nums: List[Int]) {
    require(!nums.isEmpty)  // This should only fail if my code is used badly (eg. given bad parameter)
    for (num <- nums) require(num >= 0)
    assume(1 == 2 / 2)  // This should only fail if my code is bad

    def notImplemented() { ??? }
  }

  divide(3,0)
  new PositiveList(List(1,2)).notImplemented()
  new PositiveList(List())
  new PositiveList(List(-1, 2))

  @throws(classOf[AssertionError])
  def divide(a: Double, b: Double): Double = {
    a / b
  } ensuring ( _ != Double.PositiveInfinity )

}
