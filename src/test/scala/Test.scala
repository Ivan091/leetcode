import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.Tables.Table
import org.scalatest.propspec.AnyPropSpec
import org.scalatest.Inspectors.forAll
import org.scalatest.wordspec.AnyWordSpec

final class Test extends AnyWordSpec with Matchers {

  "straight" in {
    Solution.hIndex(Array(3,0,6,1,5)) shouldBe 3
    Solution.hIndex(Array(1,3,1)) shouldBe 1
  } 
}
