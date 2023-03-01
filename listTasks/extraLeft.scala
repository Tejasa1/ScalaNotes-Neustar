package listTasks

case class extraLeft(lst1: List[String], lst2: List[String]){
  val unwanted = lst2.toSet
  println(s"Print elements which are left in the list:\n$lst1 - $unwanted")
  println("Left out: "+(lst1.filterNot(unwanted)))

//  println(s"\n\nPrint elements which are left in the list:\n$lst1 - $lst2 = "+(lst1 diff lst2))
//  println(s"\n$lst2 - $lst1 = "+(lst2 diff lst1))

}
