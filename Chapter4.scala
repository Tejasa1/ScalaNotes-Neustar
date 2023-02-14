package org.example

object Chapter4 extends App{

  class master{
    //sum is private here can be access only within this class
    private var sum = 0

    //sum can be manipulated within class
    def add(element : Int): Unit = sum += element

    def display(): Unit = println(sum)
  }

  val obj1 = new master()
  obj1.add(42)
  obj1.display()


  //sum is inaccessible error
//  println(obj1.sum)



//  they both can access each others private elements
//  Companion class
//  class CheckSum{
//    private var age = 10
//  }
//
//  Companion object : object with same name as class
//  object CheckSum{
//    def main(args : Array[String]): Unit = {
//      var obj = new CheckSum()
//      println(obj.age)
//    }
//  }


}
