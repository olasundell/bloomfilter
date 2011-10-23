package se.atrosys.euler

import collection.mutable.HashSet

/**
 * @author ola
 */

trait CeilingChecker {
	var primesThusFar: HashSet[BigInt] = null

	def hasCeilingBeenReached(i:BigInt) : Boolean

	def configure(hashSet: HashSet[BigInt]) {
		this.primesThusFar = hashSet
	}
}