package se.atrosys.euler

import collection.mutable.HashSet

/**
 * @author ola
 */

trait CeilingChecker {
	var ceiling: BigInt = 0
	var primesThusFar: HashSet[BigInt] = null

	def hasCeilingBeenReached(i:BigInt) : Boolean

	def configure(hashSet: HashSet[BigInt]) {
		this.primesThusFar = hashSet
	}

	def setCeiling(ceiling: BigInt) {
		this.ceiling = ceiling
	}
}