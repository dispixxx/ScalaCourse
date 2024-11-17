package practice7

object HomeWork7 {
  //EnumListAndMore
}

object EnumList extends App{

}

object Enum extends App{
  object Speeds extends Enumeration{
    type Speed = Value
    val RESIDENTALSPEED, DEFAULTSPEED, HIGHWAYSPEED = Value
  }

  def isDefaultSpeed(s:Speeds.Speed): Boolean = s match {
    case Speeds.DEFAULTSPEED => true
    case _                   => false
  }

  //  println(isDefaultSpeed(Speeds.DEFAULTSPEED))
  //  println(isDefaultSpeed(Speeds.HIGHWAYSPEED))

  Speeds.values.foreach(println) // print all values.
}

object EnumOverride extends App{
  object SpeedsV2 extends Enumeration{
    type Speed = Value
    val RESIDENTALSPEED = Value(20, "Residental Area Speed")
    val DEFAULTSPEED = Value(60, "Default Speed")
    val HIGHWAYSPEED = Value(120, "Highway Speed")
  }

  val residentalSpeed = SpeedsV2.withName("Residental Area Speed")
  val defaultSpeed = SpeedsV2.withName("Default Speed")
  val highwaySpeed = SpeedsV2.withName("Highway Speed")

  List(residentalSpeed, defaultSpeed, highwaySpeed).foreach{s=>
    println(s"$s, ${s.id}")
  }
}

object EnumWithParam extends App{
  object SpeedsWithValues extends Enumeration{
    type Speed = Value
    val RESIDENTALSPEED = Value(20, "Residental Area Speed")
    val DEFAULTSPEED = Value(60, "Default Speed")
    val HIGHWAYSPEED = Value(120, "Highway Speed")
  }

  object RoadsWithParam extends Enumeration{
    protected case class RoadParam(roadSpeed:SpeedsWithValues.Speed, lineCount:Int, parkingPlace:Boolean = false) extends Val{
      def printRoadInfo(): Unit = println(s"${this.getClass.getSimpleName} ${this}; speed = ${roadSpeed.id} lineCount = ${lineCount}")
    }

    type Road = RoadParam
    val twoLineRoad = RoadParam(roadSpeed = SpeedsWithValues.RESIDENTALSPEED,lineCount = 2)
    val fourLineRoad = RoadParam(roadSpeed = SpeedsWithValues.DEFAULTSPEED, lineCount = 4, parkingPlace = true)
    val sixLineRoad = RoadParam(roadSpeed = SpeedsWithValues.DEFAULTSPEED, lineCount = 6, parkingPlace = false)

    def valueToRoad:Value => RoadParam = _.asInstanceOf[RoadParam]
  }

  RoadsWithParam.values.toList.map(RoadsWithParam.valueToRoad).foreach{s=>
    s.printRoadInfo()
  }
  println("=====")
}

object hw74hw75 extends App{
  object DayOfAWeek extends Enumeration {
    type Day = Value
    val MONDAY = Value(1)
    val TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY = Value
  }

  def printBetweenTwoDays(startDay:DayOfAWeek.Day, endDay:DayOfAWeek.Day): Unit = {
    if (startDay.id <= endDay.id) {
      for (takenId <-  startDay.id+1 until endDay.id)
        println(DayOfAWeek(takenId))
    }
    else {
      for (takenId <- startDay.id-1  until endDay.id by -1)
        println(DayOfAWeek(takenId))
    }
  }

  def printNextDay(day:DayOfAWeek.Day): Unit = {
    val nextDayId: Int = if (day.id != 7) day.id else 1
    println {
      s"Day after $day is " + DayOfAWeek(nextDayId)
    }

  }

  printBetweenTwoDays(DayOfAWeek.FRIDAY,DayOfAWeek.TUESDAY)
  println("=============")
  printNextDay(DayOfAWeek.SUNDAY)
}

object hw76ListDistinct extends App{
  val list:List[Int] = List(1,2,1,3,2,4,5,5,6)

  val listDistinct = (l:List[Int]) => l.distinct
  //def listDistinctDef(l:List[Int]) = l.distinct
  println(listDistinct(list))
}

object hw77List_OptionInt_FlattenSum extends App{
  val listOptionInt: List[Option[Int]] = List(Option(11), Option(22), None, Option(45))
  val listOptionIntNonNone: List[Option[Int]] = List(Option(11), Option(22), Option(45))

  def findAverage(list: List[Option[Int]]): Unit = {
    val sum4Average = list.flatten.sum
    val count4Average = list.flatten.size
    println(s"$sum4Average, $count4Average, ${sum4Average.toDouble / count4Average}")
  }
  findAverage(listOptionInt)
  println("========")

  def findSum(list: List[Option[Int]]): Unit = {
    var sum:Int = 0
    var noneInList = false

    for (elem <- list) {
      elem match {
        case Some(value) => sum += value
        case None => noneInList = true
        case _ => 0
      }
    }
    if(noneInList) println(Option(null)) else println(sum)
  }
  findSum(listOptionInt)
  println("=======")

  def findSumV2(list: List[Option[Int]]): Unit = {
    if (list.forall(_.isDefined)) {
      println(Some(list.flatten.sum).getOrElse(0))
    } else
      println(None)
  }

  findSumV2(listOptionInt)
}

object hw78List_OptionString_Collect extends App{
  val listString :List[Option[String]] = List(Option("C++"), Option("Scala"), Option("Java"), Option("Python"),
    Option("Haskell"), Option("Fortran"))

  def sizeMore5(list: List[Option[String]]): List[String] = {
    list.collect {
      case Some(str) if str.length > 5 => str
    }
  }
  println(sizeMore5(listString))
}

object hw79List_String_intersect extends App{
  val listString1 :List[String] = List(("C++"), ("Scala"), ("Java"), ("Python"))
  val listString2 :List[String] = List(("C#"), ("Scala"), ("Fortran"))

  val resultList = listString1.intersect(listString2)
  println(resultList)
}

object hw710List_Int extends App{
  val list1 = List(1,2,3)
  val list2 = List(0,4,5)
  def getCombination(l1:List[Int] ,l2:List[Int]): List[(Int, Int)] = {
    for {
      l1<-l1
      l2<-l2
    } yield(l1, l2)
  }
  val result: List[(Int, Int)] = getCombination(list1,list2)
  println(result)
}

object r extends App{
  private val l = List(1, 2, 3)

  val f1              = (i: Int) => i + 2

  def f2(i: Int): Int = i * 2

  val lf: List[Int => Int] = List(f1, f2)

  val r = lf.map(f => f(0))

  val l7 = lf.map(l.map)

  println(r)
  println(l7)
}
