package gipsy.model

import scala.beans.BeanProperty

// We annotate the result so it will be serialized
class PredictionResponse(@BeanProperty var result: Double) {

}
