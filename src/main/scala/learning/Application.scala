package scala.learning

object Application {
  def main(args: Array[String]){
    println("Hello World!");
    var it = new IntegerIterator(Array[Integer](1,2,3,4,6));

    var filter = new Filter[Integer]

    // Filtro implícito para o escopo, sempre que
    // alguem precisar de um implicito com o tipo Integer => Boolean, vai usar esse
    implicit def f(x: Integer): Boolean = {
      x % 2 == 0
    }

    var filtered = new IntegerIterator(filter.filter(it))
    while (filtered hasNext){
      println(filtered next)
    }

  }
}
