
class EquationSolver(){
  var res = 0.0

  override def toString: String = {
    "Result: " + res
  }
  def <<(eq: Equation) : EquationSolver = {
    eq match{
      case _ : Addition => res += eq.ret
      case _ : Subtraction => res -= eq.ret
      case _ : Division if eq.retSilent!=0 => res /= eq.ret
      case _ : Multiplication => res *= eq.ret
      case _ => println("Unknown / not allowed operation")
    }
    this
  }
  def <<[T](eq: T): EquationSolver = {
    println("Unknown / not allowed operation")
    this
  }

}

abstract class Equation(){
  def ret: Double
  def retSilent: Double
}



case class Addition(i: Double) extends Equation {
  override def ret: Double = {
    println("Adding "+i)
    i
  }
  override def retSilent: Double = i
}
case class Subtraction(i: Double) extends Equation {
  override def ret: Double = {
    println("Subtracting "+i)
    i
  }
  override def retSilent: Double = i
}
case class Multiplication(i: Double) extends Equation {
  override def ret: Double = {
    println("Multiplying by "+i)
    i
  }
  override def retSilent: Double = i
}
case class Division(i: Double) extends Equation {
  override def ret: Double = {
    println("Dividing by "+i)
    i
  }

  override def retSilent: Double = i
}




object Task2{
  def main(args: Array[String]) = {

    val s = new EquationSolver()
    println(s)
    s << Addition(1) << Subtraction(1)
    println(s)
    s << Division(0)
    println(s)
    s << Addition(1) << Multiplication(5)
    println(s)
    s << Division(2)
    println(s)
    s << List[Int](1)
    println(s)

  }
}

