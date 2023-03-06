package spark_example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object programMainObject {

  def main(args:Array[String]): Unit ={

    val filePath = "/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/spark_example/dataFiles/testData1.csv"

    val filePath1 = "/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/spark_example/dataFiles/empDataFile1.csv"
    val filePath2 = "/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/spark_example/dataFiles/empDataFile2.csv"


//    countingAndPercent(filePath).countAndPercent()
//    fillAndNull(filePath1,filePath2).fillAndNullMethod()
//    fillAndNullCount(filePath1,filePath2).fillAndNullCountMethod()


  }

}
