package Invariance

import variance.{SubClass, SuperClass, Class}

/**
 * User: Sam Wright
 * Date: 28/01/2013
 * Time: 13:17
 */
object Invariance extends App {

  def requiresSuperClass(obj: Container[SuperClass]) {}
  def requiresClass(obj: Container[ Class ]) {}
  def requiresSubClass(obj: Container[ SubClass ]) {}

  // Invariant (ie. without + or -) ...
  class Container[ T ]
  val cont = new Container[ Class ]
  // ... means there's no sub/super class relation between containers of different classes

  // requiresSuperClass(cont)
  requiresClass(cont)
  // requiresSubClass(cont)


  // Can't have mutable of type T
  class Element[ T ](var value: T) {
    def setValue(obj: T) { value = obj }
    def getValue(): T = { value }
  }

  val e_superclass = new Element(new SuperClass())
  val e_class = new Element(new Class())
  val e_subclass = new Element(new SubClass())

  // ---- Argument types are contravariant ----

  // If e_class were a subclass of e_superclass.getClass (ie. Element is covariant with T)
  // then I could do e_class.asInstanceOf[Element[SuperClass]].setValue(new SuperClass())
  // but I couldn't do e_class.setValue(new SuperClass()).

  // Conversely, this would work going the other way (ie. Element is contravariant with T)
  // so 'e_class.asInstanceOf[Element[SubClass]].setValue(new SubClass())' is legal.

  // So setValue is only valid when casting to a super class, hence argument types
  // are contravariant.  Hence if there's a 'func(obj: T)' then T can't be covariant.

  // ---- Return types are covariant ----

  // If e_class were a subclass of e_subclass.getClass (ie. Element is contravariant with T)
  // then 'e_class.asInstanceOf[Element[SubClass]].getValue()' returns a SubClass
  // but e_class.getValue() returns a Class that could be any subclass of Class (eg. Sub2Class)
  // which is incompatible with SubClass.

  // Conversely, this would work going the other way (ie. Element is covariant with T)
  // so 'e_class.asInstanceOf[Element[SuperClass]].getValue()' returns a SuperClass,
  // which is compatible with the Class returned by e_class.getValue().

  // So getValue is only valid when casting to a sub class, hence return types
  // are covariant.  Hence if there's a 'func(): T' then T can't be contravariant.

  // ---- Mutable values of type T in Element means Element must be invariant to T ----
  // Because mutable values need a setter and a getter, so T and Element can't be either
  // contravariant or covariant.  This leaves only invariant.

  // ---- Immutable values of type T in Element means Element must be covariant or invariant with T ----
  // Because immutable values need a getter, so T and Element can't be contravariant.
  // This leaves covariant and invariant.

  class CovariantElement[ +T ](val value: T)

  class InvariantElement[ T ](val value: T)

}
