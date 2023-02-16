package readAndWrite
import scala.io.Source
object ReadAndWrite extends App {


val mappedTxtFile = {
  scala.io.Source.fromFile("C:/Users/Nilesh/IdeaProjects/Mini_Project/src/main/scala/readAndWrite/(1) The Hunger Games.txt")
    .getLines
    .flatMap(_.split(" "))
    .foldLeft(Map.empty[String, Int]) {
      (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
    }
}
  println(s"$mappedTxtFile")
  println("\n\n\nMax element printed from book"+mappedTxtFile.maxBy(_._2))

//  println(mappedTxtFile.valuesIterator.reduceLeft((x,y) => if (x > y) x else y))

//  println(mappedTxtFile)

  // C:/Users/Nilesh/IdeaProjects/Mini_Project/src/main/scala/readAndWrite/(1) The Hunger Games.txt

//  val lst = List(1,2,3,4,5,6,7)
//  println(lst.reduceRight((x,y) => {println(x +" + "+ y); x+y}))
//  println(lst.reduceLeft((x,y) => {println(x +" + "+ y); x+y}))

  val filename = Source.fromFile("C:/Users/Nilesh/IdeaProjects/Mini_Project/src/main/scala/readAndWrite/Details.txt").getLines

//  filename.foreach(println)

  val gotFile = filename.flatMap(_.split(" "))

//  println(filename
//    .getLines
//    .flatMap(_.split(" "))
//    .foldLeft(Map.empty[String,Int]){
//        (count,word) => count + (word -> (count.getOrElse(word,0)+1))
//  })


  val mapped = gotFile.foldLeft(Map.empty[String,Int]) {
    (count,word) => count + (word -> (count.getOrElse(word,0)+1))
  }


  println(mapped)
  println(mapped.maxBy(_._2))




  val str = "tejas is good"
  val seqeq = str.flatMap(_.toString.split(""))
  println(seqeq.foldLeft(Map.empty[String , Int]) {
    (countMap,word) => countMap + (word  ->  (countMap.getOrElse(word,0)+1))
  }

  )
//
//  val lst1 = Seq("Tejas", "Ambekar")
//  val ff = lst1.map(_.toLowerCase())
//  val ff2 = ff.flatten
//  println(ff2)
//
//
//  val result = lst1.flatMap(_.toLowerCase())
//  println(result)

}
