package se.atrosys.euler

/**
 * @author ola
 */

class ConsecutivePrimeSumFinder(ceilingChecker: CeilingChecker) {
	val numberSetFactory: PrimeNumberSetFactory = new PrimeNumberSetFactory()
	numberSetFactory.calcPrimes(ceilingChecker)
	val primeSet = numberSetFactory.getPrimes
	val sortedSet = numberSetFactory.getSortedPrimes

	def findBiggestPrimeInRange(): BigInt = {
		0
	}

	def isSeqConsecutivePrimeSum(seq: Seq[BigInt]) {
//		seq.fold(_ + _)
	}
}