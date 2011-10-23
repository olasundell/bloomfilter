package se.atrosys.euler

import org.testng.annotations.Test
import org.testng.annotations.BeforeMethod
import org.testng.Assert.assertTrue
import org.testng.Assert.assertFalse
import org.testng.Assert.assertEquals
import org.testng.Assert.assertNotNull
import collection.mutable.ArraySeq

/**
 * @author ola
 */

class PrimeNumberSetFactoryTest {
	var primeChecker: PrimeNumberSetFactory = null

	@BeforeMethod
	def beforeMethod() {
		primeChecker = new PrimeNumberSetFactory()
	}

	@Test
	def makeSureisPrimeWorks() {
		assertTrue(primeChecker.isPrimeThusFar(2))
		assertFalse(primeChecker.isPrimeThusFar(4))
	}

	@Test
	def primeCeilingCheckerShouldReturnProperlySizedPrimeSet() {
		val ceiling: BigInt = 101
		val primeCeilingChecker: CeilingChecker = new PrimeCeilingChecker(ceiling)
		primeChecker.calcPrimes(primeCeilingChecker)
		assertEquals(BigInt.int2bigInt(primeChecker.getPrimes.size), ceiling)
	}

	@Test
	def rangeCeilingCheckerShouldReturnProperlySizedPrimeSet() {
		val ceiling: BigInt = 1001
		val rangeCeilingChecker: CeilingChecker = new RangeCeilingChecker(ceiling)
		primeChecker.calcPrimes(rangeCeilingChecker)
		assertTrue(BigInt.int2bigInt(primeChecker.getPrimes.size) < ceiling)
		// there should be a prime in the 900s, I reckon.
		assertTrue(primeChecker.getSortedPrimes.last < ceiling)
	}

}
