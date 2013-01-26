package one

/**
 * User: Sam Wright
 * Date: 25/01/2013
 * Time: 13:35
 */
object ScalaClass extends App {
  println("Hello world!")
  def a : Int = 3
  def b = "e"
  println(a + b)
  println(new myint() + 9)
  val d : Int = 6
  def e(i : Int) : Int = {7+8+i}
  println(e(3))

  def func (a : Int, b : Int)  = { a + b } : Int

  def add(a:Int, b:Int) {
    a + b
  }

  def func2(z : (Int) => Int) {
    z(2)
  }

  def func3( a:Int, b:Int, bill : (Int, Int) => Int) = bill(a,b)

  def value : Int = func3(1, 2, func)

//  def value: Int = func3(1, 2, add)

  println(value)


  def createInstance(text:String) : ScalaClass = {
    new ScalaClass(text)
  }

  var instance = createInstance("Hello");

  println(instance.getText())
  println(instance.getText2())
  println(instance.getText3())

  // object has private access to class of same name (as in java)
  instance.ValPriv

  // Standard casting
  val object1: ScalaClass = instance.asInstanceOf[Object].asInstanceOf[ScalaClass]
  println("Object 1 is a: " + object1.getClass)

  // Casting through pattern matching
  val object2: ScalaClass = instance.asInstanceOf[Object] match {
    case a_ScalaClass_object: ScalaClass => a_ScalaClass_object
    case _ => throw new ClassCastException
  }
  println("Object 2 is a: " + object2.getClass)

  // Pattern matching
  def matchTest(x: Any): Any = x match {
      // Matching by value
    case 1 => "One"
    case "two" => 2
      // Matching by type
    case x: Int => "an integer"
    case y: String => "a string"
      // Catchall
    case _ => "what was that? a " + x.getClass()
      // Never accessed (as it comes after the catchall)
    case 4 => "Never accessed"
  }

  println("---- Start of pattern matching ----")
  for (thing <- List(1, "two", 4, "blah", 3.2)) {
    println(matchTest(thing))
  }

}

class ScalaClass(text:String) {
  def getText() : String = {text}

  def getText2(): String = text

  def getText3() = text

  def public_text = text

  val Val = 3
  private val ValPriv = 4

  var Var = 4
  private var VarPriv = 5




}


class myint {
  def +(x: Int): Int = {
    x + 4
  }

  ScalaClass.createInstance("").Var





}

