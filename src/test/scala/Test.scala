import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class Test extends AnyWordSpec with Matchers {

  "simple" in {
    Solution.trap(Array(1, 2, 1, 3, 2, 2, 4, 3)) shouldBe 3
  }

  "ex1" in {
    Solution.trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) shouldBe 6
  }

  "ex2" in {
    Solution.trap(Array(4, 2, 0, 3, 2, 5)) shouldBe 9
  }
}
