package oo_design

/**
 * User: Sam Wright
 * Date: 27/01/2013
 * Time: 19:24
 */
object UpperLimit extends App {
  trait Shouter {
    def shout();
  }

  object Monkey extends Shouter {
    override def shout() { println("ooh! ah! ah! ah!") }
  }

  object Dog extends Shouter {
    override def shout() { println("Woof!") }
  }

  // The generic type T must be a subclass of Shouter
  def makeItShout[T <: Shouter](obj: T) { obj.shout() }

  makeItShout(Monkey)
  makeItShout(Dog)

}
