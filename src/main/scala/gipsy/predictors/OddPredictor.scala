package gipsy.predictors

import gipsy.model.{PredictionRequest, PredictionResponse, Predictor}

//Simple predictor to tell if the first feature is odd
class OddPredictor extends Predictor {
  override def predict(request: PredictionRequest): PredictionResponse = {
    if(request.features.length > 0) {
      return new PredictionResponse(request.features(0) % 2)
    }else{
      throw new IllegalArgumentException("Prediction instance is incompatible")
    }
  }
}
