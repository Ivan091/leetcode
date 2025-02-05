import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class Test extends AnyWordSpec with Matchers {

  "simple" in {
    println{
      Solution.canCompleteCircuit(Array(1, 2, 3, 4, 5), Array(3, 4, 5, 1, 2))
    }
  }

  "two" in {
  }

  "fail 1" in {
  }
}
