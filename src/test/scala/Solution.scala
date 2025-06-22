object Solution {
	def canConstruct(ransomNote: String, magazine: String): Boolean = {

		def loop(map: Map[Char, Int]): List[Char] => Boolean = {
			case x :: xs =>
				if (map.contains(x)) {
					val newMap =
						map.updatedWith(x) {
							case Some(cnt) if cnt <= 1 => Option.empty
							case Some(cnt) => Option(cnt - 1)
							case None => None
						}
					loop(newMap)(xs)
				} else {
					false
				}
			case Nil => true
		}

		val magazineMap = magazine.toVector.groupBy(identity).map { case (k, v) => (k, v.size) }
		loop(magazineMap)(ransomNote.toList)
	}
}
