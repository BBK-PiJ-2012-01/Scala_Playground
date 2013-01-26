package one

import java.util.NoSuchElementException

/**
 * User: Sam Wright
 * Date: 25/01/2013
 * Time: 17:28
 */
class GenericStack[T] {
  private var elems: List[T] = List()

  // :: is the 'cons' operator.  It sets the head (x)
  // and the tail (elems) of the list.
  def push(x: T) {elems = x :: elems}
  // Can also be used in a match
  def printHeadAndTail() {
    elems match {
      case Nil => "list is empty"
      case head :: tail => "head is %s, tail is %s".format(head, tail)
    }
  }

  def pop(): T = {
    val result:T = elems.head
    elems = elems.tail
    return result
  }

  def isEmpty(): Boolean = { elems == Nil }
}


object StackTest extends App {
  val stack: GenericStack[Int] = new GenericStack[Int]
  stack.push(1)
  stack.push(2)
  stack.push(3)
  while(!stack.isEmpty()) {
    println("Popped: " + stack.pop())
  }

  try {
    println("Popped an empty list and got: " + stack.pop())
  } catch {
    case err: NoSuchElementException => println("no such element!")
  }

}