package editDistance

case class editCaseClass(str1: String, str2: String){

  def editDistance(): Unit = {

    var editPoints = Array.ofDim[Int](str1.size+1, str2.size+1)
    println(editPoints.size, editPoints(0).size)

    for (i <- 0 to editPoints.size-1) {
      editPoints(i)(0) = i
    }

    for (i <- 0 to editPoints(0).size - 1) {
      editPoints(0)(i) = i
    }





    for (i <- 1 to editPoints.size - 1) {
      for (j <- 1 to editPoints(0).size - 1) {
        if (str1(i - 1) == str2(j - 1)) {
          editPoints(i)(j) = editPoints(i - 1)(j - 1)
        }
        else {
          editPoints(i)(j) = Math.min(Math.min(editPoints(i - 1)(j), editPoints(i)(j - 1)), editPoints(i - 1)(j - 1)) + 1
        }

      }

    }





    for (i <- 0 to editPoints.size - 1) {
      for (j <- 0 to editPoints(0).size - 1) {
        println(s"editPoints[$i][$j] = ${editPoints(i)(j)}")
      }
    }


    println(s"Minimum number of edits it will require is: ${editPoints(editPoints.size-1)(editPoints(0).size-1)}")


  }
}
