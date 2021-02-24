object Task2 {
  def main(args: Array[String]): Unit = {
    val subjects = List(

      ("Matematyka dyskretna", 1, 1, 4, false),

      ("Algorytmy i struktury danych", 1, 2, 6, true),

        ("Teoria obwodów i sygnałów", 1, 3, 3, false),

      ("Układy elektroniczne", 1, 4, 5, true),

      ("Bazy danych 1", 1, 5, 5, false),

      ("Inżynieria oprogramowania", 1, 6, 5, true),

      ("Komputeryzacja pomiarów", 1, 7, 3, false),

      ("Modelowanie procesrów fizycznych", 2, 1, 5, true),

      ("Techniki mikroprocesorowe", 2, 2, 5, false),

      ("Programowanie zespołowe", 2, 3, 5, false)

    )

    // subjects, degree type, year, ects exam

    //partition instead of 2 filters



    // list of subjects for bachalor degree
    println("list of subjects for bachalor degree \n" + subjects.filter(_._2 == 1))

    // list of subjects for masters degree

    println("\nlist of subjects for masters degree \n" + subjects.filter(_._2 == 2))

    // list of subjects with exams and ECTS > 5

    val moreThan5ECTS: List[String] = subjects.filter(_._4 > 5).dropWhile(subject => !subject._5)map(x => x._1)
    println("\nlist of subjects with exams and ECTS > 5:")
    println(moreThan5ECTS)

    // list of subjects just with (name, ects)

    val name_and_ects = subjects.map(subject => (subject._1, subject._4))
    println("\nlist of subjects just with (name, ects):")
    println(name_and_ects)

    // list of subjects, where key is number of ECTS and value is list of subjects for that ECTS count (grouped by ECTS)

    //val mapOfSubjects = subjects.map(x => x._4 -> subjects.filter(_._4 == x._4).map(y=>y._1)).toMap
    val mapOfSubjects = name_and_ects.groupBy(_._2)
    println("\nlist of subjects, where key is number of ECTS and value is list of subjects for that ECTS count (grouped by ECTS) ")
    println(mapOfSubjects)

    // number of ECTS points of all bachalors subjects

    val sumOfBachalorsSubjectsECTS = subjects.filter(_._2 == 1).map(x => x._4).sum
    println("\nnumber of ECTS points of all bachalors subjects =" + sumOfBachalorsSubjectsECTS)

    // number of ECTS points of all masters subjects, which doesn't have exam

    val sumOfMastersSubjectsECTSwithoutExam = subjects.filter(_._2 == 2).filter(!_._5).map(x=>x._4).sum
    println("\nnumber of ECTS points of all masters subjects, which doesn't have exam = " + sumOfMastersSubjectsECTSwithoutExam)

    // sorted list of subjects (by name) for bachalors degree

    val sortedByName = subjects.filter(_._2 == 1).sortBy(_._1)
    println("\nsorted list of subjects (by name) for bachalors degree:")
    println(sortedByName)


  }
}
