package functions

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 18:06
 */
object ArgumentExpansion extends App {

  def sum(args: Int*): Int = {
    var sum:Int = 0
    // args.foreach( (x) => {sum += x} )  // below is shorthand
    args.foreach( sum += _ )
    sum
  }


  println(sum(Array(1,2,3,4): _*))
}
