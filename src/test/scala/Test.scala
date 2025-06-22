import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class Test extends AnyWordSpec with Matchers {

  "ex1" in {
    val f = new MedianFinder()
    f.addNum(1)
    f.addNum(2)
    f.findMedian() shouldEqual 1.5
    f.addNum(3)
    f.findMedian() shouldEqual 2.0
  }

  "pass 4" in {
    val f = new MedianFinder()
    f.addNum(-1)
    f.findMedian() shouldEqual -1
    f.addNum(-2)
    f.findMedian() shouldEqual -1.5
    f.addNum(-3)
    f.findMedian() shouldEqual -2
    f.addNum(-4)
    f.findMedian() shouldEqual -2.5
    f.addNum(-5)
    f.findMedian() shouldEqual -3
  }
}
