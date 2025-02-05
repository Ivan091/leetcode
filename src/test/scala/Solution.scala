import scala.annotation.tailrec
import scala.collection.immutable.SortedMap
import scala.math.Ordering.Implicits.*

object Solution {
  def candy(ratings: Array[Int]): Int = {
    if (ratings.isEmpty) { 0 }
    else if (ratings.length == 1) { 1 }
    else {
      val result = new Array[Int](ratings.length)
      val len = ratings.length

      val valuesWithIndexes = SortedMap.from(ratings.toVector.zipWithIndex.groupBy(_._1).view.mapValues(_.map(_._2)))

      def maxAround(i: Int) = {
        if (i == 0) {
          if (ratings(i + 1) == ratings(i)) 1 else result(i + 1) + 1
        } else if (i == len - 1) {
          if (ratings(i - 1) == ratings(i)) 1 else result(i - 1) + 1
        } else {
          val right = if (ratings(i + 1) == ratings(i)) 1 else result(i + 1) + 1
          val left = if (ratings(i - 1) == ratings(i)) 1 else result(i - 1) + 1
          math.max(right, left)
        }
      }

      @tailrec
      def loop(map: SortedMap[Int, Vector[Int]]): Unit = {
        if (map.nonEmpty) {
          val (minV, minIs) = map.min
          minIs.foreach(i => result.update(i, maxAround(i)))
          loop(map - minV)
        }
      }

      loop(valuesWithIndexes)

      result.sum
    }
  }
}
