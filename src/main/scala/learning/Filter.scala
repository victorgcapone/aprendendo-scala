package scala.learning

import java.util

class Filter[T] {
  def filter(it : AbstractIterator[T])(implicit f: T=>Boolean) = {
    var result = new util.LinkedList[T]();
    while(it.hasNext){
      var element = it.next;
      if(f(element)){
        result.add(element);
      }
    }
    result.toArray(new Array[Integer](result.size()));
  }
}
