package org.example

object Chapter5 extends App{

  //normal addition using expression
  val num = 1+2
  println(num)

  //addition by invoking ".+()" method
  val num2 = 1.+(2)
  println(num2)


  var name = "Tejas"
  println(name indexOf 'j') //invokes name.indexOf('j')
  println(name indexOf ('s',1)) //indexOf( search element , starting index)

//  value types
//  Byte | Short | Int | Long | Char | Float | Double | Boolean



  //Rich Wrappers used here
  println(0 max 5)
  println(0 min 5)
  println(- 2.7 abs)
  println(-2.7 round)
  println(1.5 isInfinity)
  println(4 to 6)
  println((1.0 / 0) isInfinity)
  println("robert" drop 2)
  println("bob" capitalize)











}
