package listTasks

import scala.collection.immutable.ListMap

case class equalOrNot(lst1: List[String], lst2: List[String]){

  val mappedLst1 = lst1.foldLeft  (Map.empty[String,Int]) {
    (mp, wordInLst1) => mp + (wordInLst1 -> (mp.getOrElse(wordInLst1,0)+1))
  }

  val mappedLst2 = lst2.foldLeft  (Map.empty[String,Int]) {
    (mp, wordInLst2) => mp + (wordInLst2 -> (mp.getOrElse(wordInLst2,0)+1))
  }

  val resForLst1 = Map(
    mappedLst1.toSeq.sortBy(_._2):_*
  )

  val resForLst2 = Map(
    mappedLst2.toSeq.sortBy(_._2):_*
  )

  println(s"Comparing Two List with Freq:\n$resForLst1\n$resForLst2\nEqual: ${resForLst1 == resForLst2}")



}
