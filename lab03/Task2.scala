object Task2 {

  def main(args: Array[String]): Unit = {

    val corners = List((0,0),(10,10))
    val points = List((0, 0), (1, 1), (10, 10), (11, 0), (0, 11))

    print("Number of points inside rectangle is " + howManyInside(corners, points, points.length-1, 0))

  }

  @scala.annotation.tailrec def howManyInside(corners: List[(Int, Int)], points: List[(Int, Int)], pointIndx: Int,  howMany: Int) : Int = {
    if(pointIndx < 0){
      return howMany
    }
    def check() : Int = {if(isInside(corners(0), corners(1), points(pointIndx))) 1 else 0}
    val count = howMany + check()
    howManyInside(corners, points, pointIndx-1, count)
  }

  def isInside(leftBottomCorner: (Int, Int), rightTopCorner: (Int, Int), point: (Int, Int)): Boolean =
    point._1 >= leftBottomCorner._1 && point._2 >= leftBottomCorner._2 &&
      point._1 <= rightTopCorner._1 && point._2 <= rightTopCorner._2

}
