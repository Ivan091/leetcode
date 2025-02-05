import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class Test extends AnyWordSpec with Matchers {

  "simple" in {
    println{
      Solution.candy(Array(1,2,2))
    }
  }

  "two" in {
  }

  "fail 1" in {
  }
}
