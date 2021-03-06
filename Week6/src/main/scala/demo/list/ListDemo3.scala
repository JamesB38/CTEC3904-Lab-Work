package demo.list

object ListDemo3 {

  val wordList: List[String] = List("The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog")
  val aardvark: List[Char] = "aardvark".toList
  val numList: List[Int] = List(3, 1, 4, 1, 5, 9, 2, 6, 5)
  val bitList: List[Int] = List(1, 0, 1, 1, 0, 1, 1, 0)
  val charList: List[Char] = ('a' to 'z').toList
  val intList: List[Int] = (0 to 9).toList
  val vowels: List[Char] = "aeiou".toList
  val funList: List[Int => Int] = List( _+1, _*2, _*10, _/2 )

  /*
   * EXERCISE ListDemo3.1
   * Using list comprehensions (for ( ... ) yield ...), and drawing values
   * from the predefined lists above, construct each of the following:
   * (a) List(0, 1, 4, 9, 16, 25, 36, 49, 64, 81)
   * (b) List(true, false, true, false, true, false, true, false, true, false)
   * (c) List(A, A, R, D, V, A, R, K)
   * (d) List(11, 20, 100, 5)
   * (e) List(0, 3, 6, 9)
   * (f) List(b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z)
   * (g) List(ehT, depmuj, revo, eht)
   *
   * -- In the following examples, although the lists are output in
   * -- the usual way, List( ..., ..., ..., etc. ), the presentation
   * -- below uses additional layout (spacing, newlines) to highlight
   * -- the patterns that were used to create them.
   *
   * (h) List((a,a), (a,e), (a,i), (a,o), (a,u),
   *          (e,a), (e,e), (e,i), (e,o), (e,u),
   *          (i,a), (i,e), (i,i), (i,o), (i,u),
   *          (o,a), (o,e), (o,i), (o,o), (o,u),
   *          (u,a), (u,e), (u,i), (u,o), (u,u))
   *
   * (i) List(       (a,e), (a,i), (a,o), (a,u),
   *          (e,a),        (e,i), (e,o), (e,u),
   *          (i,a), (i,e),        (i,o), (i,u),
   *          (o,a), (o,e), (o,i),        (o,u),
   *          (u,a), (u,e), (u,i), (u,o)       )
   *
   * (j) List(1,  2,  3,  4,  5,  6,  7,  8,  9, 10,
   *          0,  2,  4,  6,  8, 10, 12, 14, 16, 18,
   *          0, 10, 20, 30, 40, 50, 60, 70, 80, 90,
   *          0,  0,  1,  1,  2,  2,  3,  3,  4,  4)
   */

  def exerciseListDemo3_1() {
    val a = for (i <- intList) yield i * i
    val b = for (i <- intList) yield !(i%2 == 1)
    val c = for (i <- aardvark) yield i.toUpper
    val d = for (i <- funList) yield i(10)
//    val e = for (i <- )
    val f = for (i <- charList.tail) yield i
    val g = for (i <- wordList.take(1) ::: wordList.takeRight(5).dropRight(2)) yield i.reverse
    val h = for (i <- vowels; j <- vowels) yield (i,j)
    val i = for (i <- vowels; j <- vowels) yield if(i != j){
                                                    (i,j)
                                                  }

    val j = for (i <- 1 to 4; j <- intList) yield if(i == 1) j+1 else if (i == 2) j * 2 else if (i == 3) j * 10 else j/2

    println(a)
    println(b)
    println(c)
    println(d)
//    println(e)
    println(f)
    println(g)
    println(h)
    println(i)
    println(j)
  }


  /*
   * EXERCISE ListDemo3.2
   * Re-write the answers to ListDemo3.1(a)-(g) only use map and filter
   * instead of list comprehensions. For example, the first one (a) is
   * done for you.
   */

  def exerciseListDemo3_2() {
    val a = intList.map(i => i*i)
    val b = intList.map(i => i%2 == 0)
    val c = aardvark.map(i => i.toUpper)
    val d = funList.map(i => i(10))
    val e = intList.filter(i => i%3 == 0)
    val f = charList.filter(i => i!= 'a')

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)

  }

  /*
   * EXERCISE ListDemo3.3
   *
   * Use zip to construct the following lists. You may use other list
   * methods where this might be helpful. You should also make use of
   * the pre-defined lists from the top of this file.
   * (a) List((a,a), (e,e), (i,i), (o,o), (u,u))
   * (b) List((0,a), (1,a), (2,r), (3,d), (4,v), (5,a), (6,r), (7,k))
   * (c) List((a,e), (e,i), (i,o), (o,u))
   * (d) List((The,jumped), (quick,over), (brown,the), (fox,lazy))
   * (e) List((a,A), (e,E), (i,I), (o,O), (u,U))
   * (f) List(((0,T),The), ((1,q),quick), ((2,b),brown), ((3,f),fox), ((4,j),jumped))
   * (g) List(((The,quick),brown), ((quick,brown),fox), ((brown,fox),jumped),
   *          ((fox,jumped),over), ((jumped,over),the), ((over,the),lazy),
   *          ((the,lazy),dog))
   */
  def exerciseListDemo3_3() {
    val a = vowels zip vowels
    val b = intList zip aardvark
    val c = vowels zip vowels.tail
    val d = wordList zip wordList.drop(4)
    val e = vowels zip vowels.map(i => i.toUpper)
    val f = intList zip wordList.map(i => i.head) zip wordList.take(5)
  //    val g = ???

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    //    println(g)
  }

  /*
   * Variations: We leave you to look up zipAll which runs to the
   * length of the longest list using a supplied default value as
   * padding. Thus
   *   List(1, 2, 3, 4, 5).zipAll(List('a', 'b'), 0, 'x')
   * = List((1,a), (2,b), (3,x), (4,x), (5,x))
   * and
   *   List(1, 2).zipAll(List('a', 'b', 'c', 'd'), 0, 'x')
   * = List((1,a), (2,b), (0,c), (0,d))
   *
   * Try some of your own experiments with zipAll using the Scala
   * interpreter (REPL).
   */

  /*
   * EXERCISE ListDemo3.4
   *
   * The code in the following example gets the filenames of the
   * Scala programs in the demo folder. The variable DEMO_ROOT
   * holds the pathname of the demo folder. In Eclipse pathnames
   * are relative to the project, so src->demo navigates to the
   * demo subfolder.
   */
  def exerciseListDemo3_4() {

    println(
      """
        |ListDemo3_4
        |Edit the source code to ensure you are using the correct
        |version of DEMO_ROOT for the IDE you are using. If the
        |program throws an exception you need to edit it and re-run.
      """.stripMargin)

    val DEMO_ROOT = "src/demo" // use this version with Eclipse
//    val DEMO_ROOT = "src/main/scala/demo" // use this version with IntelliJ
    val demoFolder = new java.io.File(DEMO_ROOT).listFiles
    val demoPrograms =
      (for (f <- demoFolder if f.isDirectory)
        yield f.listFiles)
        .flatten
        .toList
        .map(_.toString)
        .filter(_.endsWith(".scala"))

    /*
     * Print out what we've found. Note that demoPrograms is a
     * list of strings so to print them out vertically on the
     * console we use mkString("\n") which builds a string from
     * a list of strings by inserting a newline at the end of
     * each individual string and then concatenating the results
     * together.
     */
    println(demoPrograms.mkString("\n"))

    /*
     * Part (a)
     *
     * Print out the filenames coupled with a counter (1, 2, ...)
     * For example:
     *
     * (1,src\demo\editor\ImmutableEditorDemo1.scala)
     * (2,src\demo\editor\ImmutableEditorDemo2.scala)
     * (3,src\demo\editor\ImmutableEditorDemo3.scala)
     * (4,src\demo\editor\MutableEditorDemo1.scala)
     * etc.
     *
     */
    println( /* print the answer */ )

    /*
     * Part (b)
     *
     * Print out the pathnames in demoPrograms with each pathname paired
     * with the length of that pathname. E.g.
     *
     * (src\demo\editor\ImmutableEditorDemo1.scala,42)
     * etc.
     *
     */
    println( /* print the answer */ )

    /*
     * Part (c)
     * 
     * Print out the demo program information in the following way:
     * a list of pairs in which the folder name is paired with the
     * number of demo programs in that folder.
     *
     * (editor,11)
     * (function,4)
     * (list,4)
     * (tree,3)
     */
    println( /* print the answer */ )

  }

  def main(args: Array[String]): Unit = {

//    exerciseListDemo3_1()
//    exerciseListDemo3_2()
    exerciseListDemo3_3()
//    exerciseListDemo3_4()

  }
}
