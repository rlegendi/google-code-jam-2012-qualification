package b

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ScoreTest extends Specification {
  "For the given example, class Score.hasScore " should {
    "sum score 13 must not contain a score of 3" in {
      Score.bestScoreOfSumAbove(13, 3) must beTrue
    }

    "sum score 13 must contain a score of 4" in {
      Score.bestScoreOfSumAbove(13, 4) must beTrue
    }

    "sum score 13 must contain a score of 5" in {
      Score.bestScoreOfSumAbove(13, 5) must beTrue
    }

    "sum score 13 must not contain a score of 6" in {
      Score.bestScoreOfSumAbove(13, 6) must beFalse
    }

    "sum score 14 must not contain a score of 3" in {
      Score.bestScoreOfSumAbove(14, 3) must beTrue
    }

    "sum score 14 must contain a score of 4" in {
      Score.bestScoreOfSumAbove(14, 4) must beTrue
    }

    "sum score 14 must contain a score of 5" in {
      Score.bestScoreOfSumAbove(14, 5) must beTrue
    }

    "sum score 14 must not contain a score of 6" in {
      Score.bestScoreOfSumAbove(14, 6) must beFalse
    }

    "sum score 15 must not contain a score of 4" in {
      Score.bestScoreOfSumAbove(15, 4) must beTrue
    }

    "sum score 15 must contain a score of 5" in {
      Score.bestScoreOfSumAbove(15, 5) must beTrue
    }

    "sum score 15 must not contain a score of 6" in {
      Score.bestScoreOfSumAbove(15, 6) must beFalse
    }
  }

  "For the given example, class Score.mightHaveExtendedScore " should {

    "surprising sum score 13 must not contain a score of 3" in {
      Score.bestScoreOfSurprisingSumAbove(13, 2) must beFalse
    }

    "surprising sum score 13 must contain a score of 3" in {
      Score.bestScoreOfSurprisingSumAbove(13, 3) must beFalse // 4 4 5
    }

    "surprising sum score 13 must contain a score of 6" in {
      Score.bestScoreOfSurprisingSumAbove(13, 6) must beFalse // 4 4 5 --> 3 5 5 max.
    }

    "surprising sum score 13 must not contain a score of 7" in {
      Score.bestScoreOfSurprisingSumAbove(13, 7) must beFalse
    }

    "surprising sum score 14 must not contain a score of 2" in {
      Score.bestScoreOfSurprisingSumAbove(14, 2) must beFalse
    }

    "surprising sum score 14 must contain a score of 3" in {
      Score.bestScoreOfSurprisingSumAbove(14, 3) must beFalse // 4 4 6
    }

    "surprising sum score 14 must contain a score of 6" in {
      Score.bestScoreOfSurprisingSumAbove(14, 6) must beTrue
    }

    "surprising sum score 14 must not contain a score of 7" in {
      Score.bestScoreOfSurprisingSumAbove(14, 7) must beFalse
    }

    "surprising sum score 15 must not contain a score of 3" in {
      Score.bestScoreOfSurprisingSumAbove(15, 3) must beFalse
    }

    "surprising sum score 15 must contain a score of 4" in {
      Score.bestScoreOfSurprisingSumAbove(15, 4) must beFalse // 5 5 5
    }

    "surprising sum score 15 must contain a score of 6" in {
      Score.bestScoreOfSurprisingSumAbove(15, 6) must beTrue
    }

    "surprising sum score 15 must not contain a score of 7" in {
      Score.bestScoreOfSurprisingSumAbove(15, 7) must beFalse
    }
  }

  "For the given example series, Series" should {
    "#1 result in 3" in {
      Score.evalSeq(3, 1, 5, List(15, 13, 11)) must be_==(3)
    }

    "#2 result in 2" in {
      Score.evalSeq(3, 0, 8, List(23, 22, 21)) must be_==(2)
      // 7 7 8 (1)
      // 7 8 8 (2)
    }

    "#3 result in 1" in {
      Score.evalSeq(2, 1, 1, List(8, 0)) must be_==(1)
    }

    "#4 result in 3" in {
      Score.evalSeq(6, 2, 8, List(29, 20, 8, 18, 18, 21)) must be_==(3)
    }
  }
}
