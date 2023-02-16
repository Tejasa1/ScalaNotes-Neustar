package movie_project

case class Movie(id:Int, name:String, category:String,  rating:Int){

  def displayAllMovies() = println(s"$id  $name  $category  $rating")

  def boxOfficeReview(movies: Movie): String = {

    val result = movies.rating match{
      case movies.rating if(movies.rating <=5) => "Flop"
      case movies.rating if(movies.rating >5)  => "Hit"
      case _ => "NA"
    }
  result
  }

}
