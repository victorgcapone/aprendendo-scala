package scala.learning

trait AbstractIterator {
  type T;
  def hasNext : Boolean;
  def next : T;
}
