package movie_project
import movie_project._
case class ProductionHouse(pid: Int, mid:List[Int], director:String, cost:Int, revenue:Int){

  def displayAllProductionHouse() = println(s"$pid  $mid  $director  $cost  $revenue")

  def flopFilmsByProductionHouses(idAndFlopOrHit:List[(Int, String)]): Unit =
    idAndFlopOrHit.map(x => if(mid.contains(x._1))  { if(x._2 == "Flop") println(s"$pid : ${x._1} : ${x._2}") } )

  def hitFilmsByProductionHouses(idAndFlopOrHit: List[(Int, String)]): Unit =
    idAndFlopOrHit.map(x => if (mid.contains(x._1)) {
      if (x._2 == "Hit") println(s"$pid : ${x._1} : ${x._2}")
    })



}
