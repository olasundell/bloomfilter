package se.atrosys.euler

/**
 * @author ola
 */

class RangeCeilingChecker extends CeilingChecker {
	def hasCeilingBeenReached(i: BigInt) = {
		ceiling <= i
	}
}
