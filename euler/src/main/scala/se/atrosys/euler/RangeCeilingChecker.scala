package se.atrosys.euler

/**
 * @author ola
 */

class RangeCeilingChecker(ceiling: BigInt) extends AbstractCeilingChecker(ceiling) {
	def hasCeilingBeenReached(i: BigInt) = {
		ceiling <= i
	}
}
