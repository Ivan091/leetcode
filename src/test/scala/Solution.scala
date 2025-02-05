import java.util
import scala.util.Random

class RandomizedSet() {

  val innerVector = new util.ArrayList[Int]()
  val innerMap = new util.HashMap[Int, Int]()
  val rnd = new Random()

  def insert(`val`: Int): Boolean = {
    if (innerMap.containsKey(`val`)) {
      false
    } else {
      innerVector.add(`val`)
      innerMap.put(`val`, innerVector.size() - 1)
      true
    }
  }

  def remove(`val`: Int): Boolean = {
    if (innerMap.containsKey(`val`)) {
      val index = innerMap.get(`val`)
      if (index == innerVector.size() - 1) {
        innerVector.remove(innerVector.size() - 1)
      } else {
        val prev = innerVector.get(innerVector.size() - 1)
        innerMap.put(prev, index)
        innerVector.set(index, innerVector.get(innerVector.size() - 1))
        innerVector.remove(innerVector.size() - 1)
      }
      innerMap.remove(`val`)
      true
    } else {
      false
    }
  }

  def getRandom(): Int = {
    val idx = rnd.nextInt(innerVector.size())
    innerVector.get(idx)
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * val obj = new RandomizedSet()
 * val param_1 = obj.insert(`val`)
 * val param_2 = obj.remove(`val`)
 * val param_3 = obj.getRandom()
 */
