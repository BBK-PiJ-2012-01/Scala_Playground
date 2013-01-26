package one

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 12:46
 */
object Generics extends App {
  def print[T <: Animal](obj: T) = { obj.speak() }

  val dolphin = new Dolphin {
    def swim() { println("swish...swish...") }
    def speak() { println("Click!") }
  }

  new GenericClass[Dolphin].print(dolphin)
  print(dolphin)
}

class GenericClass[T <: Animal] {
  def print(obj: T) { obj.speak() }
}


trait Animal {
  def speak()
}

trait Dolphin extends Animal {
  def swim()
}

