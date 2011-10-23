package se.atrosys.euler

import collection.mutable.HashSet

/**
 * @author ola
 */

class PrimeCeilingChecker extends CeilingChecker {
	def hasCeilingBeenReached(i: BigInt) = {
		BigInt.int2bigInt(primesThusFar.size) >= this.ceiling
	}
}