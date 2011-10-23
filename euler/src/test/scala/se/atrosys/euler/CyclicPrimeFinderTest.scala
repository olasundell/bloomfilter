package se.atrosys.euler

import org.testng.annotations.{Test, BeforeMethod}
import org.testng.Assert.assertEquals
import org.testng.Assert.assertNotNull
import org.testng.Assert.assertTrue
import collection.mutable.ArraySeq

/**
 * @author ola
 */

class CyclicPrimeFinderTest {
	val CEILING = 100
	val ceilingChecker: RangeCeilingChecker = new RangeCeilingChecker(CEILING)
	var cyclicPrimeFinder: CyclicPrimeFinder = new CyclicPrimeFinder(ceilingChecker)

	@Test
	def createIntArrShouldWork() {
		val resultArr = cyclicPrimeFinder.createIntArr(123)
		val expectedArr: Array[Int] = Array(1,2,3)

		assertNotNull(resultArr)
		assertEquals(resultArr.length, expectedArr.length)

		for (i <- 0 to resultArr.length - 1) {
			assertEquals(resultArr(i), expectedArr(i))
		}
	}

	@Test
	def convertSeqToBigInt() {
		val arr = Array[Int](5,3,2,6,3,2,5,6,7,1,3,9,1,9,2,4,4,4)
		val correct: BigInt = 532632567139192444L
		val result = cyclicPrimeFinder.intSeqToBigInt(arr.toSeq)

		assertEquals(result, correct)
	}

	@Test
	def isCircularShouldWork() {
		val correctSet: Set[BigInt] = Array[BigInt](2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97).toSet

		for (i <- 1 to CEILING) {
			assertTrue(correctSet.contains(i) == cyclicPrimeFinder.isCircular(i))
		}
	}

	@Test
	def circularPrimesShouldReturnCorrectResults() {
		val correctSet: Set[BigInt] = Array[BigInt](2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97).toSet
		val calculatedSet: Set[BigInt] = cyclicPrimeFinder.getCircularPrimes

		assertEquals(correctSet, calculatedSet)
	}
}