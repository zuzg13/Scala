class SDistance(val km: Int = 0, val m: Int = 0, val cm: Int= 0) {

  override def toString():String = {
    "Kilometers: "+km+", Meters : "+m+", Centimeters: "+cm
  }

  def convertDistance : Double = 1000 * km + m + 0.01 * cm

  def ==(distance: SDistance): Boolean = {
    this.convertDistance == distance.convertDistance
  }

  def !=(distance: SDistance): Boolean = {
    this.convertDistance != distance.convertDistance
  }

  def >(distance: SDistance): Boolean = {
    this.convertDistance>distance.convertDistance
  }

  def <(distance: SDistance): Boolean = {
    this.convertDistance<distance.convertDistance
  }

  def add(num: Int, dist:SDistance.Value):SDistance = {
    if (dist == SDistance.Kilometers) new SDistance(this.km + num, this.m, this.cm)
    else if (dist == SDistance.Meters) new SDistance(this.km, this.m+num, this.cm)
    else new SDistance(this.km, this.m, this.cm+num)
  }
}

object SDistance extends Enumeration{
  val Kilometers, Meters, Centimeters = Value
  def apply(i: Int, i1: Int, i2: Int):SDistance= {
    new SDistance(i, i1, i2)
  }
}


object Task1 {

  def main(args: Array[String]): Unit = {
    val firstDistance = SDistance(2, 2, 2)
    val secondDistance = SDistance(2, 2, 2)
    val thirdDistance = SDistance(2, 2, 3)
    val fourthDistance = SDistance(2, 2, 1)

    println("Distances:")
    println(firstDistance) // Kilometers: 2, Meters : 2, Centimeters: 2
    println(secondDistance) // Kilometers: 2, Meters : 2, Centimeters: 2
    println(thirdDistance) // Kilometers: 2, Meters : 2, Centimeters: 3
    println(fourthDistance) // Kilometers: 2, Meters : 2, Centimeters: 1

    println("2:")
    println(firstDistance == secondDistance) // true
    println(firstDistance != secondDistance) // false
    println(firstDistance > secondDistance) // false
    println(firstDistance < secondDistance) // false

    println("3:")
    println(firstDistance == thirdDistance) // false
    println(firstDistance != thirdDistance) // true
    println(firstDistance > thirdDistance) // false
    println(firstDistance < thirdDistance) // true

    println("4:")
    println(firstDistance == fourthDistance) // false
    println(firstDistance != fourthDistance) // true
    println(firstDistance > fourthDistance) // true
    println(firstDistance < fourthDistance) // false

    val fifthDistance = firstDistance.add(2, SDistance.Kilometers) // here you have to be able to add also meters or centimeters
    println(fifthDistance) // Kilometers: 4, Meters: 2, Centimeters: 2
  }

}




