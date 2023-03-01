package operationUsingStrInput

import scala.collection.mutable

case class performOps(){
//+, -, *, /, %, ^, (, ), 0-9
def operate(new_str:List[String]): Int ={
  val arrOfOps = Array("*","+","-","/","(",")")
  val arrayOfNums = Array("0","1","2","3","4","5","6","7","8","9")
  var result: Int = 0
  if(!arrOfOps.contains(new_str(0))){
    result = new_str(0).toInt
  }
  println(result)

  var i = 0
  println(new_str)
  while(i  != new_str.size){

    if(arrOfOps.contains(new_str(i))){

      if(new_str(i).equals("("))
      {
        var beforeOp =""
        if(i>0) { beforeOp = new_str(i-1)}
        var tempStr:List[String] = List()
        while(new_str(i+1) != ")")
        {
          i = i+1
          tempStr = tempStr.appended(new_str(i))

        }
        println(tempStr)
        if(!beforeOp.isEmpty) {
          if(i+2 == new_str.size-1)
          {
            result = operate(List(result.toString,beforeOp,operate(tempStr).toString))
          }
          result = operate(List(result.toString,beforeOp,operate(tempStr).toString))
        }
        else{
          result = operate(tempStr)
        }
        println("result at :"+result)
      }
      if(new_str(i)=="/" && !arrOfOps.contains(new_str(i+1)))
      {
        result = result / new_str(i+1).toInt

      }
      else if(new_str(i)=="*" && !arrOfOps.contains(new_str(i+1)))
      {
        result = result * new_str(i+1).toInt

      }
      else if(new_str(i)=="+" && !arrOfOps.contains(new_str(i+1)))
      {
        result = result + new_str(i+1).toInt

      }
      else if(new_str(i)=="-" && !arrOfOps.contains(new_str(i+1)))
      {
        result = result - new_str(i+1).toInt

      }
    }
    println(s"for iteration : $i result is : $result")
    i = i+1
  }
  result

}

}
