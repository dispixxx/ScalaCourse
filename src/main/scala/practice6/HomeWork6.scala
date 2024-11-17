package practice6

object HomeWork6 {

}

import scala.util.{Failure, Success, Try}

object TryFromLecture extends App {
  val t = Try(1)
  val b1 = t.isFailure
  val b2 = t.isSuccess

  def mayBeThrown(): Try[String] = Try {
    throw new Exception("boom")
  }

  val funcMayBeThrown = mayBeThrown()
  funcMayBeThrown match {
    case Failure(exception) =>
    //println(s"${exception.getMessage} Failure")
    case Success(value)     =>
    //println(s"$value Success")
  }

  val x1 = funcMayBeThrown.getOrElse(11)
  val x2: Try[String] = funcMayBeThrown.map{i =>
    println(i)
    s"$i"
  }
  println(x2)
}

object hwEither extends App {

  val nums: List[Int] = List(0, 1, 2, 4, 5, 6, 7, 8, 9, 10)
  val num0 = 0
  val num1 = 1

  def nullChecker(num: Int) = {
    if (num != 0) Left(num) else Right(Option(null))
  }

  val myEitherNum0 = nullChecker(num0)
  val myEitherNum1 = nullChecker(num1)
  println(myEitherNum0)
  println(myEitherNum1)
  println("--------------")

  val MyEvenNums: List[Either[String, Int]] = nums.map { number =>
    if ((number % 2 != 0) && (number != 0))
      Left(s"$number is not EVEN")
    else
      Right(number)
  }
  println(MyEvenNums)
}

object hwLast {
  val a = 10
  val b = 5

  def divide(num1:Int, num2:Int): Unit = {

  }

}

