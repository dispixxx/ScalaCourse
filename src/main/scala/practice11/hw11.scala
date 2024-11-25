package practice11

object hw11 {

}

object ImplicitIntClass extends App{
  implicit class ImplicitInt(n:Int){
    def prod10 =n*10
    def evenChecker : Boolean =n%2==0
  }
  val n21:Int = 21
  val n20:Int = 20
  println(n21.prod10)
  println(n21.evenChecker)
  println(n20.evenChecker)
}

object Converter extends App{
  private def convertUSDToRUB(dollars:Double)(implicit multiplierUSDtoRUB:Double) = println(s"${dollars} USD = ${dollars*multiplierUSDtoRUB} RUB")

  implicit val multiplierUSDtoRUB: Double = 103
  convertUSDToRUB(1)
  convertUSDToRUB(2.5)
}

object PersonClass extends App{
  case class Person(name:String, age:Int)

  val person1 = Person("Andrew",24)
  val person2 = Person("Max",26)
  val persons = List(Person("Anton",32),person1,person2)
  persons.foreach(println)

  implicit val personOrdering: Ordering[Person] = Ordering.by((p:Person)=>p.age)

  private val sortedPersons = persons.sorted //(personOrdering)
  println(sortedPersons)
}


