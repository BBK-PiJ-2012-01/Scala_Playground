package test

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.{OneInstancePerTest, FlatSpec, FunSuite}

/**
 * User: Sam Wright
 * Date: 28/01/2013
 * Time: 19:04
 *
 * // Need Scalatest and junit
 */
@RunWith(classOf[JUnitRunner])
class ScalaTests extends FlatSpec {

  // This lets objects be recreated for each test
  def fixture() = new {
    var builder = new StringBuilder("Scala is ")
  }

  "A ClassToTest" should "throw NullPointerException if instantiated with null" in {
    intercept[IllegalArgumentException] {
      val obj = new ClassToTest(null)
    }
  }

  it should "take any other String that can be accessed" in {
    val obj = new ClassToTest("hello")
    assert("hello" === obj.string)
    expectResult("hello") { obj.string }
  }

  ignore should "do this thing I've not thought about yet" in {
    ???
  }

  // Using fixture to get common object
  it should "prove that Scala is fun" in {
    val f = fixture()
    f.builder.append("fun")
    expectResult("Scala is fun"){ f.builder.toString() }
  }


  // Or can mixin traits that hold useful objects
  trait Builder {
    val builder = new StringBuilder("Scala is ")
  }
  trait ThisList {
    var lst = 2 :: 1 :: Nil
  }

  it should "be able to use traits" in new Builder with ThisList {
    builder.append("cool")
    lst = 3 :: lst
    expectResult(3 :: 2 :: 1 :: Nil) {lst}
  }

}

@RunWith(classOf[ JUnitRunner ])
class AnotherTest extends FlatSpec with OneInstancePerTest {
  // Or do something similar to junit
  var lst = 2 :: 1 :: Nil

  "This test" should "be able to change lst" in {
    lst = 3 :: lst
    expectResult(3::2::1::Nil) {lst}
  }

  it should "and be able to change lst again" in {
    lst = 3 :: lst
    expectResult(3 :: 2 :: 1 :: Nil) {lst}
  }
}

@RunWith(classOf[ JUnitRunner ])
class ThirdTest extends FlatSpec {

  var lst: List[Int] = Nil

  override def withFixture(test: NoArgTest) {
    // Perform setup
    lst = 2::1::Nil
    try {
      super.withFixture(test) // Invoke the test function
    }
    finally {
      lst = Nil
    }
  }
}