object Main extends App {

  val persons = List(
    Person(firstName = "Tejas", lastName = "Ambekar", age = 12),
    Person(firstName = "Peter", lastName = "Panther", age = 34),
    Person(firstName = "Nick", lastName = "Maveric", age = 52))
  val adults = persons.filter(_.age > 18)
  val descriptions = adults.map(p => p.description).mkString("\n\t")
  println(s"The adults are \n\t$descriptions")

}
