package functions

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 19:00
 */
object PlaceholderArguments extends App {
  // This pattern allows for invoking a member method chosen at runtime.
  // It works by passing functions as arguments.

  def matches(strings: List[String], matcher: (String,String) => Boolean, query: String) = {
    for (string <- strings if matcher(string, query)) yield string
  }

  // Written in full
  def startsWith(string: String, query: String): Boolean = { string.startsWith(query) }

  // Written in shorthand
  def endsWith: (String, String) => Boolean = _.endsWith(_)

  val lst = List("Bob", "Cat")

  val starts_with_B = matches(lst, startsWith, "B")
  val ends_with_B = matches(lst, endsWith, "t")

  // Written in shorthand inline
  val contains_o = matches(lst, _.contains(_), "o")

  println("From %s:%n".format(lst))

  println("Starts with B: " + starts_with_B)
  println("Ends with t: " + ends_with_B)
  println("Contains o: " + contains_o)
}
