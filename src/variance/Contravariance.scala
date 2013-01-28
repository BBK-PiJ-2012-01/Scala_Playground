package variance

import variance.{SubClass, SuperClass, Class}

/**
 * User: Sam Wright
 * Date: 28/01/2013
 * Time: 14:06
 */
object Contravariance extends App {

  def requiresSuperClass(obj: ContravariantContainer[ SuperClass ]) {}
  def requiresClass(obj: ContravariantContainer[ Class ]) {}
  def requiresSubClass(obj: ContravariantContainer[ SubClass ]) {}

  // Contravariant means container of superclass is superclass of container of class,
  // and container of subclass is subclass of container of class
  class ContravariantContainer[ -T ]
  val contravariant_cont = new ContravariantContainer[ Class ]

  // ie. the inheritance of the ContravariantContainer[T] classes follow the opposite
  // of the inheritance of the T classes

  // requiresSuperClass(contravariant_cont)
  requiresClass(contravariant_cont)
  requiresSubClass(contravariant_cont)
}
