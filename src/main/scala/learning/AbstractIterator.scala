package scala.learning

trait AbstractIterator[T] {
  def hasNext : Boolean;
  def next : T;
}
