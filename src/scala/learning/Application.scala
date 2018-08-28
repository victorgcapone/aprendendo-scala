package scala.learning

object Application {
  def main(args: Array[String]){
    println("Hello World!");
    var it = new IntegerIterator(Array[Integer](1,2,3));
    var filter = new Filter[Integer]((e: Integer) => {
      e < 3
    })
    var filtered = new IntegerIterator(filter.filter(it));
    while (filtered hasNext){
      println(filtered next);
    }

  }
}
