package wordCountProgram

import scala.collection.immutable.ListMap

object wordCount {

  def main(args : Array[String]){
    val mappedTxtFile = {
      scala.io.Source.fromFile("/Users/a925791/IdeaProjects/ScalaProject/src/main/scala/wordCountProgram/Book.txt")
        .getLines
        .flatMap(_.split("[\\d\\s-,;.!?)(\"]+"))//use special char**
        .foldLeft(Map.empty[String, Int]) {
          (count, word) => count + (word.toLowerCase -> (count.getOrElse(word.toLowerCase, 0) + 1))
        }
    }

    println(mappedTxtFile.take(10))
    println("\n\n\nMax element printed from book"+mappedTxtFile.maxBy(_._2)+"\n\n\n")

    val res = ListMap(mappedTxtFile.toSeq.sortWith(_._2 > _._2):_*)
    println(res.take(10))

  }

}
