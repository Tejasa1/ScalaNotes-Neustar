import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, util}

object Main {

def main(args: Array[String]): Unit = {
  val spark = SparkSession.builder.master("local").appName("readWrite").getOrCreate()
  val sc = spark.sparkContext

//  val data = "C:/Users/Nilesh/IdeaProjects/AboutSpark/src/main/scala/data.csv"
  val employeeData = "C:/Users/Nilesh/IdeaProjects/AboutSpark/src/main/scala/employeeData.csv"

  val df1 = sc.textFile("C:/Users/Nilesh/IdeaProjects/AboutSpark/src/main/scala/employeeData.csv")

//  val df = spark.read.option("header","true").option("inferSchema","true").csv(employeeData)
//  df.show()

//  val dfall = df.dropDuplicates().orderBy("Number of employees")
//  dfall.show()
//    orderBy('datestr').dropDuplicates(subset =['rollno'] )

  df1.collect()
  val df1_df = df1.map(_.split(",")).map(x => employeeClass(x(0).toInt,x(1),x(2),x(3),x(4),x(5),x(6).toInt,x(7),x(8).toInt))



  spark.stop()

}

}
