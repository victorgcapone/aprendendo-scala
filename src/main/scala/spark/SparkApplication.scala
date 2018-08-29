package spark


import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.array

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
