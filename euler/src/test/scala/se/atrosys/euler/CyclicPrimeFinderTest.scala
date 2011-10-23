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
	val ceilingChecker: RangeCeilingChecker = new RangeCeilingChecker
	ceilingChecker.setCeiling(100)
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
		val seq: ArraySeq[Int] = new ArraySeq[Int](6)
//		seq()
		//		cyclicPrimeFinder.convertSeqToBigInt()
	}

	@Test
	def isCircularShouldWork() {
		val ceiling: BigInt = 100
		val correctArr: Array[BigInt] = Array[BigInt](2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97)
		val correctSet: Set[BigInt] = correctArr.toSet

		assertTrue(cyclicPrimeFinder.isCircular(2))
	}

	//	@Test
	def circularPrimesShouldReturnCorrectResults() {
		//100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97
		val ceiling: BigInt = 100
		val correctArr: Array[BigInt] = Array[BigInt](2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97)
		val correctSet: Set[BigInt] = correctArr.toSet

		val calculatedSet: Set[BigInt] = cyclicPrimeFinder.getCircularPrimes
	}
}