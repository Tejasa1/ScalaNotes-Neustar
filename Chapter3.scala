package org.example
import scala.collection.immutable.HashSet
import scala.collection.mutable
import scala.collection.mutable.Set

object Chapter3 extends App{

  val greetStrings = new Array[String](3)
  greetStrings.update(0, "Hello")
  greetStrings.update(1, ", ")
  greetStrings.update(2, "world!\n")
  for (i <- (0.to(2)))
    print(greetStrings.apply(i))


  //Lists

  //To concat two list we use ":::"
  val lst1 = List(1,2,3)
  val lst2 = List(10,11,12)
  val lst3 = lst1 ::: lst2
  println(lst1)
  println(lst2)
  println(lst3)


  //Cons -> "::" is used to append element in the begining of list
  println(1::lst1)
  println(  List(12,12)  :::  List(33,33)  )

  //list operation
  println(List(1,2,3,5,6,7,8,9,9).length)
  println(List(1,2,3,5,6,7,8,9,9).drop(2)) //drop first 2 elements
  println(List(1,2,3,5,6,7,8,9,9).dropRight(2)) //drop last 2 elements
  println(List(1,2,3,5,6,7,8,9,9).exists(n=> n == 6)) //6 exsits in List or not
  println(List(1,2,3,5,6,7,8,9,9).forall(n=> n%2==0)) //check if all elements in list are divisible by 2 or not
  println(List(1,2,3,5,6,7,8,9,9).isEmpty)
  println(List(1,2,3,5,6,7,8,9,9).map(n=> n+1)) //add 1 to each element
  println(List(1,2,3,5,6,7,8,9,9).reverse)


  /**
   * Use of Tuples
   */

  //HashSet derived from immutable class and keep the insertion order
  val hashSet = HashSet("Tomatoes", "Chilies")
  println(hashSet + "Coriander")

  //Set derived from mutable class and connot keep insertion order
  val set = Set("Tomatoes", "Chilies")
  println(set + "Coriander")


  val mapping = Map[Int,String](
    1->"Tejas",
    2->"Ambekar",
    3->"Neustar"
  )
  println(mapping)



}
