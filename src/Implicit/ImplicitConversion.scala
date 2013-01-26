package Implicit

/**
 * User: Sam Wright
 * Date: 26/01/2013
 * Time: 13:43
 */
object ImplicitConversion extends App {

  trait Animal {
    def speak()
  }

  class Bird {
    def fly() { println("flap!") }
  }

  def makeAnimalSpeak(animal: Animal) {
    animal.speak()
  }

  implicit def convertToAnimal(bird: Bird): Animal =
    new Animal {
      def speak() { println("Squwark!") }
    }

  val bird = new Bird()

  makeAnimalSpeak(convertToAnimal(bird))

  makeAnimalSpeak(bird)

  // So bird can now fly and speak!!!
  bird.fly()
  bird.speak()

}

