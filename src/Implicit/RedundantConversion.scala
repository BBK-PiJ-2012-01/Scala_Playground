package Implicit

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 15:28
 */
object RedundantConversion extends App {
  class A(var value: Int) {
    def print() = { println("A: " + value) }
  }

  class B(var value: Int) {
    def print() = { println("B: " + value) }

    def setVal(value: Int) = { this.value = value }

    def printB() = print
  }

  implicit def convertAtoB(a: A): B = new B(a.value)


  var a: A = new A(1)
  a.print()

  // Every implicit conversion to B creates a new B object.
  // Changes done in the new B object are lost.
  // Calls to 'print' first go to the native 'A.print' method
  // (so 'B.print' is never called).
  a.setVal(2)
  a.print()
  a.printB()

}

