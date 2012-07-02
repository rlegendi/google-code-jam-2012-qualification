package c
import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RecycledNumbersTest extends Specification {
  "Rotating strings" should {
    "abcd rotated by 0 is abcd" in {
      RecycledNumbers.rotate("abcd", 0) must be_==("abcd")
    }

    "abc rotated by 1 is bca" in {
      RecycledNumbers.rotate("abc", 1) must be_==("bca")
    }

    "abcde rotated by 2 is cdeab" in {
      RecycledNumbers.rotate("abcde", 2) must be_==("cdeab")
    }

    "abcd rotated by -1 is dabc" in {
      RecycledNumbers.rotate("abcd", -1) must be_==("dabc")
    }

    "abcdefgh rotated by -3 is fghabcde" in {
      RecycledNumbers.rotate("abcdefgh", -3) must be_==("fghabcde")
    }

  }
}
