package se.atrosys.hash

/**
 * @author Ola Sundell
 */

class PearsonHasher extends Hasher {
	var lookup : Array[Int] = new Array[Int](256)
	val random : util.Random = new util.Random(0)

	for (i <- 0 to lookup.size - 1) {
		lookup(i) = random.nextInt(256)
	}

	def hash(s: String) = {
		var h : Int = 0
		var index : Int = 0
		//		for each c in C loop
		for (c <- s.toCharArray) {
			index = h ^ c
			h = lookup(index)
		}

		h
	}
}