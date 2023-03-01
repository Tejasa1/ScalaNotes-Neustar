package listTasks

import scala.collection.immutable.ListMap

object listTasks {

  def main(args: Array[String]): Unit ={

    val lst1 = List("tejas", "dipak", "karan", "dipak","dipak")
    val lst2 = List("karan", "dipak", "dipak", "tejas")


    val lst3 = List()
    val lst4 = List()


    equalOrNot(lst3,lst4)
    println("\n\n\n")
    equalOrNotWithoutFreq(lst3,lst4)
    println("\n\n\n")
    extraLeft(lst3,lst4)
    println("\n\n\n")
    extraLeft(lst4,lst3)








  }

}
