package listTasks

import scala.collection.immutable.ListMap

case class equalOrNotWithoutFreq(lst1: List[String], lst2: List[String]){
  val mappedLst1 = lst1.foldLeft  (Map.empty[String,Int]) {
    (mp, wordInLst1) => mp + (wordInLst1 -> (mp.getOrElse(wordInLst1,0)+1))
  }

  val mappedLst2 = lst2.foldLeft  (Map.empty[String,Int]) {
    (mp, wordInLst2) => mp + (wordInLst2 -> (mp.getOrElse(wordInLst2,0)+1))
  }

  val resForLst1 = mappedLst1.map(_._1).toSeq.sorted

  val resForLst2 = mappedLst2.map(_._1).toSeq.sorted

  println(s"Comparing Two List without Freq:\n$resForLst1\n$resForLst2\nEqual: ${resForLst1 == resForLst2}")

}
