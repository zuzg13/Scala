abstract class Order()
{
  def name: String
  def price: Double
}

class LargeMcSet() extends Order
{
  override def name: String = "Large McSet with"
  override def price: Double = 0.0
}

class NormalMcSet() extends Order
{
  override def name: String = "McSet with"
  override def price: Double = 0.0
}


trait BigMac extends Order{
  override abstract def name: String = super.name +  " BigMac"
  override abstract def price: Double = super.price + 10.0
}

trait McWrap extends Order{
  override abstract def name: String = super.name +  " McWrap"
  override abstract def price: Double = super.price + 9.0
}

trait Fries extends Order{
  override abstract def name: String = {
    var str = ""
    this match {
      case _: LargeMcSet => str = " large "
      case _ => str = " normal "
    }
    super.name +  str + "fries"
  }
  override abstract def price: Double = {
    var mn = 1.0
    this match {
      case _: LargeMcSet => mn *= 1.5
      case _ => mn
    }
    super.price + mn * 5.0
  }
}

trait Coke extends Order{
  override abstract def name: String = {
    var str = ""
    this match {
      case _: LargeMcSet => str = " large "
      case _ => str = " normal "
    }
    super.name +  str + "coke"
  }
  override abstract def price: Double = {
    var mn = 1.0
    this match {
      case _: LargeMcSet => mn *= 1.5
      case _ => mn
    }

    super.price + mn * 4.0
  }
}


object Task1 {
  def main(args: Array[String]): Unit = {
    val firstMcSet = new NormalMcSet with BigMac with Fries with Coke
    val firstMcSetLarge = new LargeMcSet with BigMac with Fries with Coke
    val secondMcSet = new LargeMcSet with McWrap with Fries

    println(firstMcSet.name + " " + firstMcSet.price)
    println(firstMcSetLarge.name + " " + firstMcSetLarge.price)
    println(secondMcSet.name + " " + secondMcSet.price)

  }
}
