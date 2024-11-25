package practice9

object HomeWork9 {

}

object ListHOF extends App {

  def doFuncToEverything(num: Int, list: List[Int => Int]): List[Int] = {
    val tempList: List[Int] = list.map(f => f(num))
    tempList
  }

  val fMultiplyByTwo :Int => Int = i => i*2
  val fMultiplyByThree :Int => Int = i => i*3
  val fQuad :Int => Int = (i:Int) => i*i
  val listOfFunc = List(fMultiplyByTwo,fMultiplyByThree,fQuad)

  //doFuncToEverything(4,listOfFunc)
  println(doFuncToEverything(4,listOfFunc))

}

object ListHOF2 extends App{

  def doListFuncToFunc(list: List[Int => Int]): Int => Int = {
    list.foldLeft((x:Int) => x){
      (acc,func)=> (x:Int) =>func(acc(x))
    }
  }

  val fMultiplyByTwo :Int => Int = i => i*2
  val fMultiplyByThree :Int => Int = i => i*3
  val listOfFunc = List(fMultiplyByTwo,fMultiplyByThree)
  val allFunc: Int => Int = doListFuncToFunc(listOfFunc)
  val result = allFunc(3)
  println(result)

}

object Curry extends App {

  def funcToStr(str:String)(numInt:Int)(numDouble:Double): String  = {
    val newStr: String = s"${str} ${numInt.toString} ${numDouble.toString}"
    newStr
  }
  val result = funcToStr("1")(2)(3d)
  println(result)

  def curryFuncToStr(str:String): (Int, Double) => String ={
    (num:Int, dbl:Double) => s"$str $num $dbl"
  }

  val anotherCurried1: (Int, Double) => String = curryFuncToStr("666")
  val anotherCurried2: String = curryFuncToStr("666")(6, 6.6f) //or anotherCurried1(6, 6.6f)
  println(anotherCurried2)
}
