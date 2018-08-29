package spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object SparkApplication {
  Logger.getLogger("org").setLevel(Level.ERROR)
  def main(args: Array[String]) = {
    val file = "src/main/iris.csv"
    val spark = SparkSession.builder()
      .appName("spark-app")
      .config("spark.master", "local")
      .getOrCreate()
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
    // Retorna todos os records cujo a primeira coluna tem valor maior 6
    val newData = data.filter({
      _.getDouble(0) > 6
    })
    print(newData.count())
    spark.stop()
  }
}
