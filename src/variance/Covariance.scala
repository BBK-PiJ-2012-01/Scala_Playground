package variance

import variance.{SubClass, SuperClass, Class}

/**
 * User: Sam Wright
 * Date: 28/01/2013
 * Time: 14:06
 */
object Covariance extends App {

  def requiresSuperClass(obj: CovariantContainer[ SuperClass ]) {}
  def requiresClass(obj: CovariantContainer[ Class ]) {}
  def requiresSubClass(obj: CovariantContainer[ SubClass ]) {}

  // Covariant means container of superclass is superclass of container of class,
  // and container of subclass is subclass of container of class
  class CovariantContainer[ +T ]
  val covariant_cont = new CovariantContainer[ Class ]
  // ie. the inheritance of the CovariantContainer[T] classes follow the inheritance of the T classes

  requiresSuperClass(covariant_cont)
  requiresClass(covariant_cont)
  // requiresSubClass(covariant_cont)


}
