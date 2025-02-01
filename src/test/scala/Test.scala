import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.Tables.Table
import org.scalatest.propspec.AnyPropSpec
import org.scalatest.Inspectors.forAll
import org.scalatest.wordspec.AnyWordSpec

final class Test extends AnyWordSpec with Matchers {

  "straight" in {
    Solution.jump(Array(1, 1, 1)) shouldBe 2
  }

  "long" in {
    Solution.jump(Array(3, 0, 0)) shouldBe 1
  }

  "selective" in {
    Solution.jump(Array(2, 8, 1, 1, 1, 1)) shouldBe 2
  }

  "growing" in {
    Solution.jump(Array(1, 2, 3, 4, 5)) shouldBe 3
  }

  "peanuts" in {
    Solution.jump(Array(1, 1, 1, 1, 1, 1, 1, 1)) shouldBe 7
  }
}
