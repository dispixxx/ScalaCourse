package practice5

object OptionHelp extends App {
  val o1 = List(1,3,2,4,5,0)
  println(s"o1.headOption: ${o1.headOption} Возвращает первый элемент, обернутый в Option")
  println(s"o1.last: ${o1.last} Возвращает последний элемент списка")
  println(s"o1.lastOption: ${o1.lastOption} Возвращает последний элемент, обернутый в Option")
  println(s"o1.tail: ${o1.tail} Возвращает список без первого элемента")
  println(s"o1.take(1): ${o1.take(1)} Возвращает первый элемент в виде списка")
  println(s"o1.find(_ > 1): ${o1.find(_ > 1)} Находит первый элемент, который больше 1, обернутый в Option")
  println(s"o1.collect(_ > 1) : ${o1.collect(_ > 1)} Собирает элементы, которые больше 1")
  println(s"o1.count(_ > 1): ${o1.count(_ > 1)} Подсчитывает количество элементов, которые больше 1")
  println(s"o1.sum: ${o1.sum} Суммирует все элементы списка")
  println(s"o1.drop(1): ${o1.drop(1)} Возвращает список без первого элемента")
  println(s"o1.dropRight(1): ${o1.dropRight(1)} Возвращает список без последнего элемента")
  println(s"o1.dropWhile(_ > 1): ${o1.dropWhile(_ > 1)} Удаляет элементы с начала списка, пока они больше 1")
  //println(s"o1.fold(1)(_ + 1): ${o1.fold(1)(_ + 1)} Складывает элементы списка, начиная с 1")
  println(s"o1.foldLeft(\"1\")((x,y) => s\"x y \"): ${o1.foldLeft("1")((x, y) => s"$x $y")} Применяет левое свертка к элементам, начиная с \"1\"")
  println(s"o1.foldRight(\"1\")((x,y) => s\"x y \"): ${o1.foldRight("1")((x, y) => s"$x $y")} Применяет правое свертка к элементам, начиная с \"1\"")

}
