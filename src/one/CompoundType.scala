package one

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 11:39
 */
object CompoundType {
  // We want object to implement both Fooable and Barable
  def barAndFoo(obj: Fooable with Barable) {
    obj.foo()
    obj.bar()
  }
}

trait Fooable {
  def foo()
}

trait Barable {
  def bar()
}