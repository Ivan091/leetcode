import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.util

object Solution {
  def merge(result: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    val nums1 = util.Arrays.copyOf(result, m)

    var i, j, k = 0
    while (k < result.length) {
      val n1 = if (i < nums1.length) nums1(i) else Int.MaxValue
      val n2 = if (j < nums2.length) nums2(j) else Int.MaxValue
      if (n1 < n2) {
        result.update(k, n1)
        i += 1
      } else if (n2 <= n1) {
        result.update(k, n2)
        j += 1
      }
      k += 1
    }
  }
}

class SolutionTest extends AnyWordSpec with Matchers {

  "test" in {
    val nums1 = Array(1, 2, 3, 0, 0, 0)
    val nums2 = Array(2, 5, 6)
    Solution.merge(nums1, 3, nums2, 3)
    nums1 shouldEqual Array(1, 2, 2, 3, 5, 6)
  }

  "test 2" in {
    val nums1 = Array(2, 0)
    val nums2 = Array(1)
    Solution.merge(nums1, 1, nums2, 1)
    nums1 shouldEqual Array(1, 2)
  }
}
