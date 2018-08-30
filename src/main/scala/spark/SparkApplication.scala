package spark


import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.array
import org.apache.spark.sql.functions._
import org.apache.spark.ml.linalg.Vector

object SparkApplication {
  Logger.getLogger("org").setLevel(Level.ERROR)
  def main(args: Array[String]) = {
    val file = "src/main/iris.csv"
    val spark = SparkSession.builder()
      .appName("spark-app")
      .config("spark.master", "local")
      .getOrCreate()
    import spark.implicits._
    // Lê o nosso CSV
    val data = spark.read
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(file)
      .cache()
    // Imprime alguns dados
    data.explain()
    data.printSchema()
    //Agrupa as features em uma única coluna vetor
    val groupedData = data.select(array($"petal_length", $"petal_width",
                                        $"sepal_length", $"sepal_width") as "features",
                                        $"species" as "label")
                          //Transforma as labels em números
                          .withColumn("label", when($"label".equalTo("versicolor"), 1.0)
                            .otherwise(when($"label".equalTo("virginica"), 2.0)
                            .otherwise(3.0)))
                          // Transforma em um dataset de pontos com labels
                          .map(r => {new LabeledPoint(r.getAs[Double]("label"), r.getAs[Vector]("features"))})
    groupedData.printSchema()
    groupedData.show(10)
    // Amostra de 70% sem reposição para o treino
    val train = groupedData.sample(false, 0.7)
    // O resto é teste
    val test = groupedData.except(train)
    println(test.count(), train.count())

    spark.stop()
  }
}
