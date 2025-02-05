object Solution {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    def loop: List[(Int, Int)] => Int = {
      case Nil => -1
      case (d, i) :: Nil if d >= 0 => i
      case _ :: Nil => -1
      case (0, _) :: xs => loop(xs)
      case (d1, i1) :: (d2, i2) :: xs if d1 <= 0 && d2 <= 0 => loop((d1 + d2, i1) :: xs)
      case (d1, i1) :: (d2, i2) :: xs if d1 >= 0 && d2 >= 0 => loop((d1 + d2, i1) :: xs)
      case (d1, i1) :: (d2, i2) :: xs if d1 >= d2 => loop((d1 + d2, i1) :: xs)
      case one :: two :: xs => loop(two :: xs ::: List(one))
    }

    loop((gas zip cost).map { case (gas, cost) => gas - cost }.zipWithIndex.toList)
  }
}
