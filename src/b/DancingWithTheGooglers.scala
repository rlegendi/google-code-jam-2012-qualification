package b

import utils.FileStuff
import utils.CodeJamStuff

object Score {
  def bestScoreOfSumAbove(sumOfScores: Int, p: Int): Boolean = {
    if (0 == sumOfScores) {
      return 0 == p
    }

    val y = sumOfScores / 3

    if (0 == sumOfScores % 3) {
      // 9 9 9
      // 8 9 10 *
      return p <= y
    }

    if (1 == sumOfScores % 3) {
      // 9 9 10
      // 8 9 10 *
      return p <= y + 1
    }

    if (2 == sumOfScores % 3) {
      // 9 10 10
      // 9 10 11 *
      return p <= y + 1
    }

    throw new IllegalStateException("" + sumOfScores);
  }

  def bestScoreOfSurprisingSumAbove(sumOfScores: Int, p: Int): Boolean = {
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

  def evalSeq(N: Int, S: Int, p: Int, ts: Seq[Int]): Int = {
    // Nota Bene the simple and surprising results 
    val simple = ts.count(Score.bestScoreOfSumAbove(_, p))
    val surprising = ts.count(Score.bestScoreOfSurprisingSumAbove(_, p))
    //println("N: " + N, "S: " + S, "p: " + p, "simple: " + simple, "surprising: " + surprising, "ts: " + ts, "simple: " + ts.map(Score.hasScore(_, p)), "extended: " + ts.map(Score.mightHaveExtendedScore(_, p)))
    Math.min(N, simple + Math.min(S, surprising))
  }
}

object DancingWithTheGooglers extends Application {
  def solve(lines: List[String]): List[String] = {
    1.to(lines.length).map {
      x =>
        // I need Array here, because split() returns an array
        // http://stackoverflow.com/questions/10303182/multiple-assignment-in-scala-without-using-array

        // The variables in which you want to extract the values must begin with a lower-case letter.
        // http://stackoverflow.com/questions/8204219/multiple-assignment-via-pattern-matching-with-array-is-not-working-with-uppercas

        val n :: s :: p :: ts = lines(x - 1).split("\\s+").map(_.toInt).toList

        assert(n == ts.size)
        assert(0 <= s && s <= n)
        assert(0 <= p && p <= 10)
        assert(ts.forall(t => 0 <= t && t <= 30))
        assert(s <= ts.count(t => 2 <= t && t <= 28))

        "Case #" + x + ": " + Score.evalSeq(n, s, p, ts);
    }.toList
  }

  CodeJamStuff.processInputs("B", solve, 100)
}
