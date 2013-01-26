package match_examples

/**
 * User: Sam Wright
 * Date: 25/01/2013
 * Time: 21:16
 */
object CaseClass extends App {

  def thingToString(expression:Thing): String = {
    expression match {
      case Func(thing) => "func(" + thingToString(thing) + ")"
      case Term(value) => value.toString()
      case _ => "what?"
    }
  }

  val f = Func(Func(Term(4)))
  val str = thingToString(f)
  println(str)

  // Case classes don't need 'new' to instantiate
  val term: Term = Term(3)
  // And the constructor values are accessible
  assert(term.value == 3)

  // Above example shows that the match block
  // is deconstructing the Term and Func objects,
  // passing their constructor parameters to the case function.


  trait Thing
  case class Term(value:Int) extends Thing
  case class Func(thing:Thing) extends Thing
}



