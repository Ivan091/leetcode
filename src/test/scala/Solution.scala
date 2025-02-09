object Solution {
  def trap(height: Array[Int]): Int = {
    
    def max: List[(Int, Int)] => List[(Int, Int)] = l => l.sortBy { case (h, _) => -h }

    def calcPeaks: List[(Int, Int)] => Int = { list =>
      def calcPeaksInternal(acc: Int, li: Int, ri: Int): List[(Int, Int)] => Int = {
        case Nil => acc
        case x -> xi :: xs if xi >= ri =>
          val waterLevel = math.min(x, height(ri))
          val waterVolume = Range.inclusive(ri + 1, xi - 1).foldLeft(0) { case (acc, h) => acc + waterLevel - height(h) }
          calcPeaksInternal(acc + waterVolume, li, xi)(xs)
        case x -> xi :: xs if xi <= li =>
          val waterLevel = math.min(x, height(li))
          val waterVolume = Range.inclusive(xi + 1, li - 1).foldLeft(0) { case (acc, h) => acc + waterLevel - height(h) }
          calcPeaksInternal(acc + waterVolume, xi, ri)(xs)
        case x -> xi :: xs => calcPeaksInternal(acc, li, ri)(xs)
      }

      println(list)
      list match {
        case Nil           => 0
        case p -> pi :: xs => calcPeaksInternal(0, pi, pi)(xs)
      }
    }

    (calcPeaks compose max)(height.toList.zipWithIndex)
  }
}
