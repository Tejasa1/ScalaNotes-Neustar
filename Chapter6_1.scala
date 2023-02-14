package org.example

object Chapter6_1 extends App{

  class Shapes{
    def Area(l:Double, b:Double, r:Double)= 0.0
  }

  class circle extends Shapes{
    override def Area(l:Double, b:Double, r:Double)=(3.14*r*r)
  }

  class rectangle extends Shapes{
    override def Area(l: Double, b: Double, r: Double): Double = (l*b)
  }





      var rect = new rectangle()
      var cir = new circle()

      println(rect.Area(2,6,0))
      println(cir.Area(0,0,5))




}
