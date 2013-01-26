package functions

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 21:35
 */
object PassAsArgument extends App {
  val shouldCheck: Boolean = false

  def isValTrue(value: Boolean): Boolean = { !shouldCheck || value }    // evaulated before function called
  def isFuncTrue(func: () => Boolean) = { !shouldCheck || func() }      // evaluated in function, but verbose usage
  def isShortFuncTrue(func: => Boolean) = { !shouldCheck || func }      // evaluated in function & clean usage

  print("isShortFuncTrue = ")
  println(isShortFuncTrue( 2 / 0 == 0 ))
  print("isFuncTrue = ")
  println(isFuncTrue( () => 2 / 0 == 0 ))
  print("isValTrue = ")
  try {
    println(isValTrue( 2 / 0 == 0 ))
  } catch {
    case err: ArithmeticException => println("error!")
  }

}
