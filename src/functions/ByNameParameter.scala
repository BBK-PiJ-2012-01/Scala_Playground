package functions

/**
 * By setting the argument as being 'arg: => Type', it is evaluated
 * each time it is called in the function.
 */
object ByNameParameter extends App {
  var _counter_ = -1

  def counter(): Int = {
    _counter_ += 1
    _counter_
  }

  def resetCounter() {
    _counter_ = -1
  }

  def printByValue(c: Int) {
    println("counter is " + c)
    println("counter is " + c)
    println("counter is " + c)
    resetCounter()
  }

  def printByName(c: => Int) {
    println("counter is " + c)
    println("counter is " + c)
    println("counter is " + c)
    resetCounter()
  }

  println(" --- By Value ---")
  printByValue(counter)
  println("\n --- By Name ---")
  printByName(counter)

}
