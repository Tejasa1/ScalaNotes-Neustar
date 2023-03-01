package playWithDataSet

import scala.collection.immutable.ListMap

object employeeDatasetImpl {

  def main(args : Array[String]): Unit ={

    val filepath = "/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/playWithDataSet/empData.csv"
    val emp = Employee(filepath)

    emp.displayAllRecords()
//    emp.distinctRecords()
//    emp.recordSortedByDOJ()
//    emp.recordSortedByDOB()
//    emp.empAboveAvgSalary()
//    emp.empBelowAvgSalary()

  }

}
