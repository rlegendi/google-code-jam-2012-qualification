package b

import utils.FileStuff

object Score {
  //  def hasScore(somOfScores: Int, p: Int): Boolean = {
  //    val y = somOfScores / 3
  //    if (2 == p % 3) {
  //      return y == p || y + 1 == p
  //    }
  //
  //    return y - 1 == p || y == p || y + 1 == p
  //  }
  //
  //  def mightHaveExtendedScore(somOfScores: Int, p: Int): Boolean = {
  //    val y = somOfScores / 3
  //    if (2 == p % 3) {
  //      return y - 1 == p || y + 2 == p
  //    }
  //
  //    return y - 2 == p || y + 2 == p
  //  }

//  def hasScore(sumOfScores: Int, p: Int): Boolean = {
//    if (0 == sumOfScores) {
//      // TODO What if I remove return? Is it returned or is the control flow moving towards?
//      //return 1 == p
//      return 0 == p
//    }
//
//    val y = sumOfScores / 3
//    if (0 == sumOfScores % 3) {
//      return y == p
//    }
//    
//    return y == p || y + 1 == p
//  }
//
//  def mightHaveExtendedScore(sumOfScores: Int, p: Int): Boolean = {
//    if (0 == sumOfScores) {
//      return 2 == p
//    }
//
//    val y = sumOfScores / 3
//    if (0 == sumOfScores % 3) {
//      return y - 1 == p || y + 1 == p
//    }
////
////    if (2 == sumOfScores % 3) {
////      return y + 2 == p
////    }
//
//    // 8 == 2 3 3 (mod = 2, y = 2)
//    // 1, 4 WRONG
//    // 2, 2, 4 !!
//
//    // 14 == 4 5 5 (mod = 2, y = 4)
//    // 
//
//    return y - 1 == p || y + 2 == p
//  }
    def hasScore(sumOfScores: Int, p: Int): Boolean = {
    if (0 == sumOfScores) {
      // TODO What if I remove return? Is it returned or is the control flow moving towards?
      //return 1 == p
      return 0 == p
    }

    val y = sumOfScores / 3
    
    if (0 == sumOfScores % 3) {
      return p <= y
    }
    
    if (1 == sumOfScores % 3) {
      return p <= y + 1
    }
    
    if (2 == sumOfScores % 3) {
      // 9 10 10
      // 9 10 11 *
      return p <= y+1
    }
    
    throw new IllegalStateException("" + sumOfScores);
  }

  def mightHaveExtendedScore(sumOfScores: Int, p: Int): Boolean = {
    if (0 == sumOfScores) {
      return 2 == p
    }

    val y = sumOfScores / 3
    if (0 == sumOfScores % 3) {
      return p == y + 1
    }
    
    if (1 == sumOfScores % 3) {
      return false;
    }
    
    if (2 == sumOfScores % 3) {
    	return p == y + 2;
    }
    
    throw new IllegalStateException("" + sumOfScores);
  }


  // FIXME Warning when return is Unit (or not specified) and last line is a value
  def evalSeq(N: Int, S: Int, p: Int, ts: Seq[Int]): Int = {
    val simple = ts.count(Score.hasScore(_, p))
    
    ts.foreach( t => println(Score.hasScore(t, p)))
    val surprising = ts.count(Score.mightHaveExtendedScore(_, p))
    println("N: " + N, "S: " + S, "p: " + p, "simple: " + simple, "surprising: " + surprising, "ts: " + ts, "simple: " + ts.map(Score.hasScore(_, p)) , "extended: " + ts.map(Score.mightHaveExtendedScore(_, p)))
    val res = Math.min(N, simple + Math.min(S, surprising))
    println(res)
    res
  }
}

object DancingWithTheGooglers extends Application {

  // TODO Can I do womething with the return type? What should I use here, Seq?
  def solve(lines: List[String]): List[String] = {
    // TODO
    // lines.foreach( line =>
    // 	val (N, S, p, ts) = line ----- No, bevause I need to convert ts to int...
    // 	...
    // See: http://www.artima.com/forums/flat.jsp?forum=283&thread=243570

    //for ( (s, l) : String, Int <- lines ) {
    //for (i <- 1 to lines.length) {
    val ret = 1.to(lines.length).map {
      x =>
        val s = lines(x - 1)
        val it = s.split(" ").iterator

        val N = it.next.toInt
        val S = it.next.toInt
        val p = it.next.toInt
        // Why do I need the String here?
        val ts = it.toIndexedSeq[String].map(s => s.toInt)

        assert(N == ts.size)
        assert(0 <= S && S <= N)
        assert(0 <= p && p <= 10)
        assert(ts.forall(t => 0 <= t && t <= 30))
        assert(S <= ts.count(t => 2 <= t && t <= 28))

        // TODO How could I define an upper bound for the recursion?
        val y = Score.evalSeq(N, S, p, ts);
        val sol = "Case #" + x + ": " + y
        println(sol)
        sol
    }

    ret.toList
  }

  // Create a list easily?
  //for (s <- List("B-test.in", "B-small-practice.in", "B-large-practice.in")) {
  for (s <- List("B-test.in")) {
    val lines = FileStuff.readStuff("input/B/" + s, 100)
    val result = solve(lines)
    FileStuff.writeStuff("output/B/" + s.replaceAll("in$", "out"), result)
    // FIXME Upper bound if there are many surprising results...
  }

}
