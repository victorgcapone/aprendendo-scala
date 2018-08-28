package learning.algebra

trait Monoide[@specialized(Int, Double, Long, Short, Float) T] extends Semigrupo[T] {
  // Pela definição de monoide, x + id = x (+ é a operação do semigrupo)
  def id: T
}
