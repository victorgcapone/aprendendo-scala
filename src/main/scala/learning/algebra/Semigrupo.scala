package learning.algebra

//@specialized faz com que o Scala evite fazer boxing e unboxing de primitivas
trait Semigrupo[@specialized(Int, Double, Long, Float, Short) T] {
  //Pela definição de semigrupo (x+y)+z=x+(y+z)
  def add(x: T, y: T)
}
