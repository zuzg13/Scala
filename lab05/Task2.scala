trait HumanComparator{
  def distance: Double
  def rightWhereYouAre() : Boolean = distance == 0.0
  def inYourNeighborhood() : Boolean = distance > 0.0 && distance < 10.0
  def farAway() : Boolean = distance >= 10.0
  def toHuman: String = {
    if(rightWhereYouAre()) "Right where you are"
    else if(inYourNeighborhood()) "In your neighborhood"
    else "Far away"
  }
}

class Distance(val d: Double){
    def distance: Double = d
}

class Formatted(val f: Double) extends Distance(f) with HumanComparator {

}

class TDistance(tuple: (Int, Int), tuple1: (Int, Int)){
  def distance: Double = Math.sqrt((tuple1._1-tuple._1)*(tuple1._1-tuple._1) + (tuple1._2-tuple._2)*(tuple1._2-tuple._2))
}

object Task2 {
  def main(args: Array[String]): Unit = {
    val x = new Formatted(0.0)
    println(x.toHuman) // Right where you are

    val y = new Formatted(5.0)
    println(y.toHuman) // In your neighborhood

    val z = new Formatted(25.0)
    println(z.toHuman) // Far away
    println(f"${z.rightWhereYouAre()} ${z.inYourNeighborhood()} ${z.farAway()}") // false false true

    val dist = new TDistance((1, 1), (4, 4)) with HumanComparator
    println(dist.toHuman) // In your neighborhood
  }
}