package org.example


//Classes And Objects
object Chapter2 extends App {

  /**
   two types var and val
   var : non-final
   val : final
   */

  //here type "String" is optional
  val val_1 : String = "Hello val" //equivalent: val val_1 = "Hello val"

  var var_1 : String = "Hello var" //equivalent: var var_1 = "Hello var"


  class person(name:String , age:Int)
//  equivalent:
//  class person{
//    String name;
//    int age;
//    public person(String name, int age){
//      this.name = name;
//      this.age = age;
//    }


  //Functions
  def fun1(num1:Int,num2:Int) = println("Line no : 32 : fun1 : "+(num1+num2))
  fun1(3,4)


  def greatOrNot(x:Int , y:Int) = if(x>y) 1 else 0 //same as Ternary Operators
  println("Line no : 36 : greatOrNot : "+greatOrNot(9,6))


  //Loops
  var i = 0
  print("Line no : 42 : while loop : ")
  while(i<10) {
    print(i+" ")
    i+=1
  }
  println()

  val numList = List(1,2,3,4,5)
  print("Line no : 49 : for loop : ")
  for(n<-numList)
    print(n+" ")
  println()


  print("Line no : 53 : foreach")
  numList.foreach(n=>print(n+" "))
  println()


  print("Line no : 60 : ")
  val listOfList : List[List[Int]] = List(
    List(1,2),
    List(2,3),
    List(3,4)
  )
  print(listOfList)
  println()
  print("Line no : 68 : ")
  listOfList.foreach(n=>print(n))


}
