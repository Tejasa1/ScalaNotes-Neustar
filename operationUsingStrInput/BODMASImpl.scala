package operationUsingStrInput


import operationUsingStrInput.ConvertsNumOp.convert

import scala.collection.mutable


case class BODMASImpl(expr : String){

  val priority = Map(
    '+' -> 1,
    '-' -> 1,
    '/' -> 2,
    '%' -> 2,
    '*' -> 2,
    '(' -> 0,
    ')' -> 0
  )

  def charToNum(s: Char): Int ={
    return (s.toString.toInt)
  }

  val isOperator   = Array('+','-','/','%','*')
  var stackForNums : mutable.Stack[Int] = mutable.Stack()
  var stackForOps  : mutable.Stack[Char] = mutable.Stack()

  val exprCharArr = expr.toCharArray



 def performOperation(op: mutable.Stack[Char], nums: mutable.Stack[Int]): Int ={

   try {
     var num1 = nums.pop()
     var num2 = nums.pop()
     var oop = op.pop()

     var result = convert(num2).apply(oop.toString)(num1)
     return result

   }
   catch{
     case e: NoSuchElementException => println("NoSuchElementException"); return 0
   }



 }


 def operation(): Unit ={

   var i = 0
   while(i < exprCharArr.size){

     var ch = exprCharArr(i)
     println(s" char: $ch")
     if(ch.isDigit)
       {
         stackForNums.push(charToNum(ch))
       }
     else if(ch == '(')
       {
         stackForOps.push(ch)
       }
     else if(ch == ')')
       {
         try {
           while (stackForOps.top != '(') {
             var output = performOperation(stackForOps, stackForNums)
             stackForNums.push(output)
           }
           stackForOps.pop()
         }
         catch {
           case e: IndexOutOfBoundsException => println("IndexOutOfBoundsException")
         }
       }
     else if(isOperator.contains(ch))
       {
         while(stackForOps.nonEmpty && priority(ch) <= priority(stackForOps.top))
           {
             var output = performOperation(stackForOps,stackForNums)
             stackForNums.push(output)
           }
           stackForOps.push(ch)
       }

     i = i+1

   }


   //For Anything left
   while(!stackForOps.isEmpty)
   {
     var output = performOperation(stackForOps,stackForNums)
     stackForNums.push(output)
   }
   println (stackForNums.pop())

 }




}
