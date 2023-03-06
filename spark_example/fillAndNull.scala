package spark_example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{col, when}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

case class fillAndNull(filePath1: String ,filePath2: String){
  def fillAndNullMethod(): Unit ={
    val spark = SparkSession.builder()
      .master("local[3]")
      .appName("joinAndCompare")
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

    empDataFile1.show()
    empDataFile2.show()

    val innerDF = empDataFile1.join(empDataFile2,empDataFile1("e1id")===empDataFile2("e2id"),"inner")
      .withColumn("nullToFill", when( col("e1birthMonth" ).isNull && col("e2birthMonth").isNotNull, 1 ).otherwise(0))
      .withColumn("fillToNull", when( col("e1birthMonth" ).isNotNull && col("e2birthMonth").isNull, 1 ).otherwise(0))
      .withColumn("changed", when( col("e1birthMonth" ).notEqual(col("e2birthMonth")) , 1 ).otherwise(0))
      .withColumn("matched", when( (col("e1birthMonth").isNull && col("e2birthMonth").isNull) || col("e1birthMonth" ).equalTo(col("e2birthMonth"))  , 1 ).otherwise(0))



    innerDF.show()

  }
}
