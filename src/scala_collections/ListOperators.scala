package scala_collections

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 23:17
 */
object ListOperators extends App {
  val lst1 = List(1,0)
  val lst2 = 3 :: 2 :: lst1
  val lst3 = 5 :: 4 :: Nil

  // concatenation
  val lst_all1 = lst3 ++ lst2
  val lst_all2 = lst3 ::: lst2
  println(lst_all1)
  println(lst_all2)

  // zip
  val zipped = List('a','b','c') zip List('1','2','3')
  val concatted = for ( (a: Char, b: Char) <- zipped) yield { "%c : %c".format(a,b) }
  println(concatted)

  // map
  val lst3_plus_one = lst3 map (_ + 1)
  println("lst3_plus_one = " + lst3_plus_one)

  // flatMap
  // For each element, the function creates a list.
  // All these lists are concatenated (ie. flattened)
  // eg1. on the twelfth day of Christmas...
  def getDecade(in: Int): List[Int] = {
    in match {
      case n if n <= 0 => Nil
      case n if n < 10 => getDecade(10 * n + 9)
      case n if n % 10 == 0 => n :: Nil
      case _ => in :: getDecade(in - 1)
    }
  }

  val decades = List(3,2,1).flatMap(getDecade(_))
  println(s"decades = $decades")

  // flatMap eg2. map and reduce!
  val num_strs = List("1","2","3","four","5")
  val nums: List[Int] = num_strs.flatMap(string_to_int)
  println("nums = " + nums)

  def string_to_int(str: String): List[Int] = {
    try {
      List(str.toInt)
    } catch {
      case _ => Nil
    }
  }

  // foldLeft: start with ":start: ", then apply function foreach in list
  val lst2_foldLeft = lst2.foldLeft(":start: ")("%s %d ".format(_,_))
  println("lst2_foldLeft = " + lst2_foldLeft)

  // foldRight: start with the last in list and apply f:(last," :start:"),
  // and continue working back to the head
  val lst2_foldRight = lst2.foldRight(" :start:")(" %d %s ".format(_,_))
  println("lst2_foldRight = " + lst2_foldRight)

  // filter
  val only_evens = lst2 filter (_ % 2 == 0)
  println("only_evens: " +  only_evens)

  // partition
  val partitioned = lst2.partition( _ >= 2)
  println("partitioned = " + partitioned)
}

