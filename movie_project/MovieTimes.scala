package movie_project
import movie_project.ProductionHouse
object MovieTimes {
  def main(args:Array[String]): Unit = {

    val movies = List(
      Movie(11,"movie_name_1", "Horror", 9),
      Movie(22,"movie_name_2", "Horror", 5),
      Movie(33,"movie_name_3", "Action", 6),
      Movie(44,"movie_name_4", "Thriller", 4),
      Movie(55,"movie_name_5", "Funny", 2),
      Movie(66,"movie_name_6", "Dance", 7),
      Movie(77,"movie_name_7", "Horror", 4)
    )



    val productionHouses = List(
      ProductionHouse(1001, List(11,77,33), "Tejas", 30, 40),
      ProductionHouse(1002, List(44,55), "Dipak", 100, 40),
      ProductionHouse(1003, List(22,66), "Atharva", 10, 90)
    )




    def getAllMovies() = {
      println("All Movies Available:")
      movies.map(_.displayAllMovies()).mkString("\n")
    }
    getAllMovies()




    def IMDBreview() = {
      println("\n\n\nIMDB Review for all Movies:")
      movies.map(x => println(s"${x.name} : ${x.rating}/10 : ${x.boxOfficeReview(x)}"))
    }
    IMDBreview()



    println("\n\n\nAll the production houses that produce films:")
    productionHouses.map(_.displayAllProductionHouse()).mkString("\n")



    val flopAndHit = movies.map(x=> (x.id, x.boxOfficeReview(x)))
    def flopFilmsByProductionHouse() = {
      println("\n\n\n\nonly flops by any production house")
      productionHouses.map(_.flopFilmsByProductionHouses(flopAndHit))
    }
    flopFilmsByProductionHouse()


    def hitFilmsByProductionHouse() = {
      println("\n\n\n\nonly Hit by any production house")
      productionHouses.map(_.hitFilmsByProductionHouses(flopAndHit))
    }
    hitFilmsByProductionHouse()



    def profitByProductionHouse() = {
      println("\n\n\nProduction Houses which have made profits")
      productionHouses.filter(x => x.cost<x.revenue).map(y => println(s"${y.pid} : +${y.revenue-y.cost}"))
    }
    profitByProductionHouse()





    def lossByProductionHouse() = {
      println("\n\n\nProduction Houses which have made loss")
      productionHouses.filter(x => x.cost > x.revenue).map(y => println(s"${y.pid} : ${y.revenue - y.cost}"))
    }
    lossByProductionHouse()
  }

}
