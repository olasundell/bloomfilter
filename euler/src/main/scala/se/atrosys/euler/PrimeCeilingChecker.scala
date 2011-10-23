package se.atrosys.euler

import collection.mutable.HashSet

/**
 * @author ola
 */

class PrimeCeilingChecker(ceiling: BigInt) extends AbstractCeilingChecker(ceiling) {
	def hasCeilingBeenReached(i: BigInt) = {
		BigInt.int2bigInt(primesThusFar.size) >= ceiling
	}
}