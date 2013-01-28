package oo_design

/**
 * User: Sam Wright
 * Date: 27/01/2013
 * Time: 19:29
 */
object LowerLimit extends App {

  class Dog {
    def shout() { println("woof") }
  }

  class Poodle extends Dog {
    override def shout() { println("WOOF!") }
    def prance() { println("prancing commencing...") }
  }

  // Can start with a Container[Poodle], then prepend a Dog
  // to get a Container[Dog] (which is legal because Dog >: Poodle)
  case class Container[+T](val head: T, given_tail: Container[T]) {
    def tail = given_tail match {
      case tail: Container[T] => tail
      case null => Nil
    }

    def prepend[S >: T](new_head: S): Container[S] = {
      Container(new_head, this)
    }
  }

  val poodle_lst = Container(new Poodle(), null)
  println("poodle_lst = " + poodle_lst)

  val dog_lst = poodle_lst.prepend(new Dog())
  println("dog_lst = " + dog_lst)
}
