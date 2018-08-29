package gipsy.api

import gipsy.model.PredictionRequest
import gipsy.model.PredictionResponse
import gipsy.predictors.OddPredictor
import org.springframework.web.bind.annotation._

@RestController
@RequestMapping(Array("/predict"))
class PredictionController {

  @PostMapping(Array("/"))
  @ResponseBody
  def doPredicit(@RequestBody request: PredictionRequest) : PredictionResponse ={
    return (new OddPredictor()).predict(request)
  }

  @GetMapping(Array("/"))
  def isUp(): String= {
    "Yes"
  }
}
