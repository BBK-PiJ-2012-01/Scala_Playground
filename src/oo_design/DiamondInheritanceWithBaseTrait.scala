package oo_design

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 12:22
 */
object DiamondInheritanceWithBaseTrait extends App {
  trait BaseTrait {
    def speak(): String;
  }

  trait Dog extends BaseTrait {
    override def speak(): String = { "Woof" }
  }

  trait Cat extends BaseTrait {
    override def speak(): String = { "Meow" }
  }

  class CatDog extends Cat with Dog {}

  class DogCat extends Dog with Cat {}


  println("extends Cat with Dog: " + new CatDog().speak())
  println("extends Dog with Cat: " + new DogCat().speak())
}

