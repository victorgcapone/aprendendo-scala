package gipsy.model

import scala.beans.BeanProperty

class PredictionRequest() {

  // Alternative constructor
  def this(features : Array[Double]){
    this()
    this.features = features
  }

  @BeanProperty
  var features: Array[Double] = Array()
}
