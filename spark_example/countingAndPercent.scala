package spark_example


import org.apache.commons.collections.CollectionUtils
import org.apache.commons.collections.CollectionUtils.select

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.functions.{col, lit, sum, when}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}


case class countingAndPercent (filePath: String){

  def countAndPercent(): Unit ={
    val spark = SparkSession.builder()
      .master("local[2]")
      .appName("countDataColumns")
      .getOrCreate()


//    val schema = StructType( Array(
//      StructField("INDEX", IntegerType,true),
//      StructField("FNAME", StringType,true),
//      StructField("LNAME", StringType,true),
//      StructField("AGE", IntegerType,true)
//    ))
//

    val fileDF  = spark.read.format("csv")
      .option("inferSchema","true")
      .option("header","true")
      .load(filePath)

    fileDF.show()
    fileDF.printSchema()
    val fileDFCount = fileDF.count()




//    val filledCounts = if(fileDF.columns.isEmpty) {
//      fileDF
//    }
//    else{
//      fileDF.columns.foldLeft(fileDF){
//        (accumulator , new_col) => accumulator
//          .withColumn(s"filled_count_$new_col" , expr(s"count(case when ${new_col} is not null then 1 end)"))
//      }
//    }

//--------------------------------------------------------------------------------------------------------------------------


//    val filledCounts = if(fileDF.columns.isEmpty){
//      fileDF
//    }
//    else{
//      fileDF.columns.foldLeft(fileDF){
//        (acc, new_col) => acc.agg(count(when(col(new_col).isNotNull,1)).alias(s"filled_count_$new_col"))
//      }
//    }

//---------------------------------------------------------------------------------------------------------------------------------


//    val filledCounts : RelationalGroupedDataset = fileDF.groupBy().agg(
//      fileDF.columns.map(
//        c => count(when(col(c).isNotNull,1)).alias(s"filled_col_$c")
//      ):_*
//    )


//    filledCounts.show()

//---------------------WORKING-------------------------------------------------------------------------------------------------------
//    val filledPercentage = if(fileDF.columns.isEmpty){
//      fileDF
//    }
//    else
//      {
//        fileDF.columns.foldLeft(fileDF){
//          (acc,col_next) => acc.withColumn(
//            s"filled_percent_$col_next" , format_number(
//              col(col_next).isNull.cast("int").*(lit(-1).+(lit(1))).+(lit(1)).*(lit(100))./(fileDFCount),2
//            )
//          )
//        }.na.fill(0,fileDF.columns.map(col => s"filled_percent_$col"))
//      }
//-----------------------------------------------WORKING----------------------------------------------------------------------------------------------






    val filledPercentRows = fileDF.columns.map(
      c => {
        val notNullCount = fileDF.filter(col(c).isNotNull).count()
        val fillPercent = (notNullCount.toDouble / fileDFCount.toDouble) * 100.0
        (c,fillPercent)
      }
    )

//    val fillPercentSchema = StructType(Seq(StructField("column",StringType), StructField("fillPercent",DoubleType)))

    val filledPercentage = spark.createDataFrame(filledPercentRows).toDF("column","fillPercent")


    filledPercentage.show()


//    filledPercentage.show()

//
//    val fileDF_modified = fileDF
//      .groupBy("INDEX")
//      .agg(
//        count(when(col("INDEX").isNull || col("INDEX").isNaN,1)).alias("nullCountForINDEX"),
//        count(when(col("FNAME").isNull || col("FNAME") == "",1)).alias("nullCountForFNAME"),
//        count(when(col("LNAME").isNull || col("LNAME") == "",1)).alias("nullCountForLNAME"),
//        count(when(col("AGE").isNull || col("AGE").isNaN,1)).alias("nullCountForAGE")
//      )
//
//    fileDF_modified.show()
//
//    println( fileDF.count() +" "+ fileDF.columns.size )
//
//    val fileDF_modified1 = fileDF
//      .groupBy("INDEX")
//      .agg(
//        count(when(col("INDEX").isNotNull,1)).alias("notNullCountForINDEX"),
//        count(when(col("FNAME").isNotNull,1)).alias("notNullCountForFNAME"),
//        count(when(col("LNAME").isNotNull,1)).alias("notNullCountForLNAME"),
//        count(when(col("AGE").isNotNull,1)).alias("notNullCountForAGE")
//      )
//
//    val fillPercent = fileDF_modified1.selectExpr(
//      s"(notNullCountForINDEX/$fileDFCount)*100 as fillPercentForINDEX",
//      s"(notNullCountForFNAME/$fileDFCount)*100 as fillPercentForFNAME",
//      s"(notNullCountForLNAME/$fileDFCount)*100 as fillPercentForLNAME",
//      s"(notNullCountForAGE/$fileDFCount)*100 as fillPercentForAGE"
//    )
//
//    fillPercent.show()
  }

}
