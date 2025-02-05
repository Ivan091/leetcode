import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class Test extends AnyWordSpec with Matchers {

  "simple" in {
    Solution.productExceptSelf(Array(1, 2, 3)) shouldBe Array(6, 3, 2)
  }

  "two" in {
    Solution.productExceptSelf(Array(5, 10)) shouldBe Array(10, 5)
  }

  "fail 1" in {
    Solution.productExceptSelf(Array(2, 3, 5, 0)) shouldBe Array(0, 0, 0, 30)
  }
}
