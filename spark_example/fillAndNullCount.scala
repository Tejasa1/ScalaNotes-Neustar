package spark_example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, count, when}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

case class fillAndNullCount(filePath1: String, filePath2: String) {


  def fillAndNullCountMethod(): Unit ={
    val spark = SparkSession.builder()
      .master("local[3]")
      .appName("joinAndCompare2")
      .getOrCreate()

    val schemaForFile1 = StructType(Array(
      StructField("e1id",IntegerType,true),
      StructField("e1birthMonth",StringType,true)
    ))

    val schemaForFile2 = StructType(Array(
      StructField("e2id",IntegerType,true),
      StructField("e2name",StringType,true),
      StructField("e2birthMonth",StringType,true)
    ))


    val empDataFile1 = spark.read
      .format("csv")
      .option("header","true")
      .schema(schemaForFile1)
      .load(filePath1)

    val empDataFile2 = spark.read
      .format("csv")
      .option("header","true")
      .schema(schemaForFile2)
      .load(filePath2)


    val innerDF = empDataFile1.join(empDataFile2,empDataFile1("e1id")===empDataFile2("e2id"),"inner")

    val result = innerDF
      .agg(
        count( when( col("e1birthMonth").isNotNull && col("e2birthMonth").isNull,1) ).alias("fillToNull"),
        count( when( col("e1birthMonth").isNull && col("e2birthMonth").isNotNull,1) ).alias("nullToFill"),
        count( when( col("e1birthMonth").notEqual(col("e2birthMonth")),1) ).alias("changed"),
        count( when( col("e1birthMonth").isNull && col("e2birthMonth").isNull || (col("e1birthMonth" ) === col("e2birthMonth")),1) ).alias("matched")
      )



    result.show()
  }

}
