package gipsy.model

trait Predictor {
  def predict(request: PredictionRequest) : PredictionResponse
}
