package practice5

object HomeWork5 {

}

object OptionTest extends App{
  val o1 = Option(1)
  //private val multiplyByThree: Int => Int = _ * 3
  val result: Int = o1.map(_* 2).getOrElse(0)
  println(result)
}

object OptionStringChecker extends App{
  val optionString = Option("Scala better Java")
  val o2 =optionString.getOrElse(0)
  //println(o2.getClass)

  def checkString(option: Option[String], word:String): Unit = {
    option match{
      case Some(value) if value.contains(word) => println(s"word: '${word}' was found")
      case Some(_)                         => println(s"word: '${word}' wasn't found")
      case None                                =>println("error")
    }
  }

  def checkString2(option: Option[String], word:String): Unit = {
    if (option.exists(_.contains(word))) {
      println(s"word: '$word' was found")
    }
    else{
      println(s"word: '$word' wasn't found")
    }
  }
  checkString(optionString,"Scala")

  checkString2(optionString,"Scala")
}

object OptionIntChecker extends App{
  val age: Option[Int] = Option(16)

  def checkAge(option: Option[Int]): Unit = {
    option match {
      case Some(value)if value < 6 => println(s"$value is a Child ")
      case Some(value)if 6 <= value && value < 14 => println(s"$value is a Teenager ")
      case Some(value)if 14 <= value && value <18 => println(s"$value is a Young")
      case Some(value)if 18 <= value && value < 35 => println(s"$value is a Adult")
      case Some(value)if value >= 35 => println(s"$value is a Elerly")
      case None => println("Error")
    }
  }
  checkAge(Option(5))
  checkAge(Option(6))
  checkAge(Option(13))
  checkAge(Option(14))
  checkAge(Option(18))
  checkAge(Option(35))
  checkAge(Option(85))

}

