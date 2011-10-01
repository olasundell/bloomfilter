package se.atrosys.hash

/**
 * @author Ola Sundell
 */

class FNVHasher extends Hasher {

	val fnvOffsetBasis: Int = 16777619
	val fnvPrime: Long = 2166136261L

	def hash(s: String) = {
		var h : Long = fnvOffsetBasis
		for (c <- s.toCharArray) {
			h = h * fnvPrime
			h = h ^ c
		}
		h
	}
}