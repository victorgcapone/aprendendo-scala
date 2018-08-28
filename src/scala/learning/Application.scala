package scala.learning

object Application {
  def main(args: Array[String]){
    println("Hello World!");
    var it = new IntegerIterator(Array[Integer](1,2,3));
    while(it.hasNext){
      println(it.next);
    }
  }
}
