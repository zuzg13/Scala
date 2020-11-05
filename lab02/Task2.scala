object Task2 {
  def main(args: Array[String]): Unit = {

    //first way
    //val lisOfRectangles = List((6.0, 7.0), (4.40, 5.20), (3.05, 8.6),(4.5, 2.5))
    //second way
    var listOfRectangles:List[(Double, Double)] = List()
    listOfRectangles = (6.0, 7.0)::listOfRectangles
    listOfRectangles = (4.40, 5.20)::listOfRectangles
    listOfRectangles = (3.05, 8.6)::listOfRectangles
    listOfRectangles = (4.5, 2.5)::listOfRectangles
    //third way
    /*
    var listOfRectangles: List[(Double, Double)] = List((6.0, 7.0))
    listOfRectangles = listOfRectangles ++ List((4.40, 5.20))
    listOfRectangles = listOfRectangles ++ List((3.05, 8.6))
    listOfRectangles = listOfRectangles ++ List((4.5, 2.5))
    */

    listOfRectangles.foreach(tup=>print(s"$tup \n"))

    biggerThan(listOfRectangles, 10.0).foreach(tup=>area(tup))

  }

  def biggerThan(list: List[(Double, Double)], ar: Double):List[(Double, Double)] = {

    list.filter(area2(_)>ar)
  }

  def area(t: (Double, Double)): Unit = {
    val (a, b) = t;
    val area = a*b;
    print(s"($a, $b)=> area: $area \n");
  }

  def area2(t: (Double, Double)): Double = {
    val (a, b) = t;
    val area = a*b;
    area
  }

}
