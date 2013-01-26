package functions

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 18:02
 */
object DefaultArguments extends App {
  def echo(arg: Int = 3): Int = {
    arg
  }

  println(echo())
  println(echo(4))
}
