package functions

/**
 * Instead of returning null when the function goes wrong,
 * it returns None.  If it's ok it returns Some(result).
 *
 * So it is explicit when you need to check for the function
 * going wrong (instead of guessing/checking the doc for
 * whether or not to check for null)
 */
object OptionalReturn extends App {
  def divide(num:Double, denom:Double) : Option[Double] = {
    if (denom == 0)
      None
    else
      Some(num / denom)
  }

  def printResultOfDivision(num:Double, denom:Double) {
    divide(num, denom) match {
      case Some(result) => println("%f / %f = %f".format(num, denom, result))
      case None => println("Can't divide by zero!")
    }
  }

  printResultOfDivision(3, 4)
  printResultOfDivision(5, 0)

}
