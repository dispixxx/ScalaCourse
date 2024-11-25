package practice10

object hw10 {

}

object hw10Test extends App {

  val isPerfectSquare: PartialFunction[Int, Int] = {
    case x if Math.sqrt(x).isValidInt => x
  }

  def filterPerfectSquares(numbers: List[Int]): List[Int] = {
    numbers.collect(isPerfectSquare)
  }

  // Пример использования
  val numbers = List(4, 15, 16, 23, 25, 30, 36, 40)
  val result = filterPerfectSquares(numbers)

  println(result) // : List(4, 16, 25, 36)
}

