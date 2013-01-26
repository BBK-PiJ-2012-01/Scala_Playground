package Implicit

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 14:23
 */
object AssociatedConversion extends App {

  // Don't need implicit conversions to be in scope
  // if they are associated with the type to be converted

  println("Dollar(5).euroValue = " + new Dollar(6).euroValue)
  println("Euro(5).dollarValue = " + new Euro(6).dollarValue)

}

class Dollar(value: Int) {
  val dollarValue = value
}


class Euro(value: Int) {
  val euroValue = value
}

object Dollar {
  implicit def convertToEuro(dollar: Dollar): Euro =
    new Euro(dollar.dollarValue * 2)
}

object Euro {
  implicit def convertToDollar(euro: Euro): Dollar =
    new Dollar(euro.euroValue / 2)
}
