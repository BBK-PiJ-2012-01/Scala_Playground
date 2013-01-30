package test

/**
 * User: Sam Wright
 * Date: 28/01/2013
 * Time: 18:09
 */
class ClassToTest(val string: String) {
  require(string != null)

  def addStringToList(lst: List[String]) {
    return string :: lst
  }
}
