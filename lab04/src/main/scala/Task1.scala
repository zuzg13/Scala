import scala.annotation.tailrec

object Task1 {
  def main(args: Array[String]) = {

    println(join(list=List("a", "b", "c"), separator=',')) // a,b,c
  }

  def join(list: List[String], separator:Char): String ={

    @tailrec
    def joinNext(list: List[String], str: String): String ={
      if(list.isEmpty) {
        str
      } else{
        val newstr = str + (if (str!="") separator.toString else "") +  list.head
        joinNext(list.tail, newstr)
      }
    }
    joinNext(list, "")

  }

}
