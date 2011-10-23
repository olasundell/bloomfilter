package se.atrosys.euler

import org.testng.Assert.assertEquals

/**
 * @author ola
 */

class ConsecutivePrimeSumFinderTest {
	val CEILING = 100
	val ceilingChecker: RangeCeilingChecker = new RangeCeilingChecker(CEILING)
	var consecutiveFinder: ConsecutivePrimeSumFinder = new ConsecutivePrimeSumFinder(ceilingChecker)

	def findBiggestPrimeInRangeShouldWork() {
		assertEquals(consecutiveFinder.findBiggestPrimeInRange(), 47)
	}
}