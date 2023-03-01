package operationUsingStrInput

import scala.collection.mutable

object OpsObj {

  def main(args: Array[String]): Unit ={
//    val new_str = "(5-8+3*9)+4-9+9".split("").toList
//    val new_str1 = "9-5*(0-1)+7*5".split("").toList
//    println(new_str1)
//    println(performOps().operate(new_str1))





//--------------------------------------Test Area-------------------------------------------------------------------------


    println(
      " * : " +'*'.toInt ,
      " / : " +'/'.toInt ,
      " + : " +'+'.toInt ,
      " % : " +'%'.toInt ,
      " ^ : " +'^'.toInt ,
      " 1 : " +"1".toInt ,
      " 9 : " +"9".toInt ,
      " 5 : " +"5".toInt
    )



    val anything = "(5-8+3*9)+4-9+9".toCharArray

//    anything.foreach(print)

    var rr : mutable.Stack[Int] = mutable.Stack(1,2,3,4,5)
//    println(rr)
//    println(rr.top)
//    println(rr)
//    println(rr.pop())
//    println(rr)

BODMASImpl("(3*(-6)+2)").operation()

  }

}
