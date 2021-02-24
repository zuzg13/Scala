import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util._
import math.{ min, max }

object Task2 {
  def mapReduce(s: List[Int]): Future[(Int, Int)] = {
    val splitted = s.grouped(s.length / 10).toSeq // This splits list of Numbers into 10 sequences of numbers - it's first point from plan

    Future.sequence(splitted.map(x=>Future[(Int, Int)]{
      (x.foldLeft(10)(min), x.foldLeft(10)(max))
    })) map {
      result => result.reduce((x,y) => (min(x._1, y._1), max(x._2, y._2)))
    }

  }

  def main(args: Array[String]): Unit = {
    val rNumbers = List.fill(100)(Random.nextInt())

    //println((rNumbers.min, rNumbers.max)) // You can check if the result is correct
    val r = mapReduce(rNumbers)

    r onComplete {
      case Success(res) => println(res) // Should be tuple: (MinNumber, MaxNumber)
    }

    Await.ready(r, Duration(10, SECONDS))
  }
}