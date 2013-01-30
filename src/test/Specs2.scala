package test

import org.specs2._
import specification.Fragments
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * User: Sam Wright
 * Date: 28/01/2013
 * Time: 18:08
 *
 * Needed to attach "specs2" and "scalaz_core" jars to dependencies.
 *
 * ----------- DOESN'T WORK!!! -----------
 */
@RunWith(classOf[ JUnitRunner ])
class Specs2 extends Specification {
  def is: Fragments =

    "Test for ClassToTest"                              ^
                                                        p^
    "Checks for..."                                     ^
    "given string can't be null"                        ! e1^
    "addStringToList must give List(String) given Nil"  ! e2^
                                                        end

  def e1 = new ClassToTest(null) must throwA[AssertionError]

  def e2 = new ClassToTest("String").addStringToList(Nil) must beEqualTo (List("String"))
}

