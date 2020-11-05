object Task1 {

  def main(args: Array[String]): Unit = {

    val equation = "2 + 2";
    println(s"Answer: ${solveEquation(equation)}")

    val equation2 = "2 - 2";
    println(s"Answer: ${solveEquation(equation2)}")

    val equation3 = "2 * 2";
    println(s"Answer: ${solveEquation(equation3)}")

    val equation4 = "2 / 2";
    println(s"Answer: ${solveEquation(equation4)}")


  }

  def solveEquation(equation: String) : Int = {

    var arr:Array[String] = equation.split(" ")
    var funs:Map[Char, (Int, Int)=>Int] = Map('+' -> add, '-'->subtract, '*'->multiply, '/'->divide)

    funs.apply(arr(1)(0))(arr(0).toInt,arr(2).toInt)
  }

  def add(a: Int, b:Int): Int = a+b
  def subtract(a: Int, b:Int): Int =  a-b
  def multiply(a: Int, b:Int): Int = a*b
  def divide(a: Int, b:Int): Int = a/b

}

