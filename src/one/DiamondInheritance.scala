package one

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 12:08
 */
object DiamondInheritance extends App {
  val obj = new FooBar()

  println(obj.bar())
  println(obj.foo())
  println(obj.foobar())
}

trait FooableTrait {
  def foo() = { "foo : foo" }
  def foobar() = { "foo : foobar" }
}

trait BarableTrait {
  def bar() = { "bar : bar" }
  def foobar() = { "bar : foobar" }
}

class FooBar extends FooableTrait with BarableTrait {
  override def foobar() = super[BarableTrait].foobar()
}

