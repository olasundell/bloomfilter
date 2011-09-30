package se.atrosys

import java.lang.StringBuffer

class BloomFilter(var filterSize : Int) {
	val filterSizeMax : Int = 2 << filterSize;
	var filter : Array[Boolean] = new Array[Boolean](filterSize);

	def add(str: String) {
		val hash : Int = str.hashCode() % filterSizeMax
		for (i <- 0 until filterSize) {
			val bit: Int = 2 << i
			filter(i) = filter(i) || (hash & bit) == bit
		}
	}

	def check(str: String) : Boolean = {
		val hash : Int = str.hashCode() % filterSizeMax
		for (i <- 0 until filterSize) {
			val bit: Int = 2 << i
			// poor man's xor
			if (filter(i) != ((hash & bit) == bit)) {
				return false;
			}
		}

		true;
	}

	def getFilterSizeMax : Long = {
		filterSizeMax
	}

	override
	def toString : String = {
		val buffer : StringBuffer = new StringBuffer()

		for (f <- filter) {
			if (f) {
				buffer.append(1)
			} else {
				buffer.append(0)
			}
		}

		buffer.toString
	}
}
