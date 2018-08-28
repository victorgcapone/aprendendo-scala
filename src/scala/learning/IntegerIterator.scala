package scala.learning

class IntegerIterator(s: Array[Integer]) {
  type Integer;
  private var current = 0;
  def hasNext = current < s.length;
  def next = {
    val old = current;
    current += 1;
    s(old);
  }
}
