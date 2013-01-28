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

}
