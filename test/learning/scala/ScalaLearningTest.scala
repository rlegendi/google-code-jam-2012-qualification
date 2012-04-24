package learning.scala
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import b.Score

object SomeDummyClass {
  def someDummyMethodThatNotReturnsValueWithoutExplicitReturnStatement: Int = {
    if (true) {
      0 // Will not return here without an explicit 'return' statement
    }

    return 1
  }
}

@RunWith(classOf[JUnitRunner])
class ScalaLearningTest extends Specification {
  "If I'm playing with Scala, SomeDummyClass" should {
    "return the value without the return statement" in {
      // TODO Why cannot I leave the brackets for the only argument here?
      // i.e., this is erroneous:
      // SomeDummyClass.someDummyMethod... must be_== 1

      SomeDummyClass.someDummyMethodThatNotReturnsValueWithoutExplicitReturnStatement must be_==(1)
    }
  }
}
