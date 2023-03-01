package editDistance

object editMainObj {

  def main(args: Array[String]): Unit ={

    val str1 = "etjas"
    val str2 = "tejas"

    if(!str1.isEmpty && !str2.isEmpty){
      editCaseClass(str1,str2).editDistance()
    }
    else{
      println(Math.max(str1.size,str2.size))
    }

  }

}
