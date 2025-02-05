import java.util
import scala.annotation.tailrec

object Solution {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {

    val result = util.Arrays.copyOf(nums, nums.length)

    @tailrec
    def loop1(idx: Int)(p: Int): Unit = {
      if (idx < nums.length) {
        val newP = nums(idx) * p
        nums.update(idx, newP)
        loop1(idx + 1)(newP)
      }
    }
    loop1(0)(1)

    def loop2(idx: Int)(p: Int): Unit = {
      if (idx == result.length - 1) {
        val newP = p * result(idx)
        result.update(idx, nums(idx - 1))
        loop2(idx - 1)(newP)
      } else if (idx == 0) {
        result.update(0, p)
      } else {
        val newP = p * result(idx)
        result.update(idx, nums(idx - 1) * p)
        loop2(idx - 1)(newP)
      }
    }
    loop2(result.length - 1)(1)
    result
  }
}
