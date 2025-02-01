object Solution {
  def jump(nums: Array[Int]): Int = {
    def mainLoop(jcnt: Int): List[Int] => Int = {
      case Nil      => jcnt
      case _ :: Nil => jcnt
      case l @ _ :: xs =>
        def loop(d: Int, maxD: Int): List[Int] => Int = {
          case Nil              => maxD
          case x :: xs if x >= d => loop(d + 1, d)(xs)
          case x :: xs          => loop(d + 1, maxD)(xs)
        }
        val skip = loop(0, 0)(l)
        mainLoop(jcnt + 1)(l.drop(skip))
    }
    mainLoop(0)(nums.reverse.toList)
  }
}
