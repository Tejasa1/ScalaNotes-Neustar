package operationUsingStrInput

case class NumOp( num1 : Int ){

    def apply(op:String)(num2:Int):Int = {
      op match {
        case "+" => num1+num2
        case "-" => num1-num2
        case "*" => num1*num2
        case "/" => num1/num2
        case "%" => num1%num2
        case _ => 0
      }
    }
  }

object ConvertsNumOp{
     def convert(a:Int):NumOp= NumOp(a)
}
