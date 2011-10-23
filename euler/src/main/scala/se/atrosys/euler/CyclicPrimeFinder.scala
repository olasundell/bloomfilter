package se.atrosys.euler

import collection.mutable.{HashSet, ArraySeq}

/**
 * @author ola
 */

class CyclicPrimeFinder(celingChecker: CeilingChecker) {
	val numberSetFactory: PrimeNumberSetFactory = new PrimeNumberSetFactory()
	numberSetFactory.calcPrimes(celingChecker)
	val primeSet = numberSetFactory.getPrimes

	def createIntArr(prime: BigInt) : ArraySeq[Int] = {
		val str = prime.toString()
		val chrArr = str.toCharArray
		val intArr = new ArraySeq[Int](chrArr.length)

		// TODO fugly. This is the C way, I guess. I pray it isn't the Scala way.
		for (i <- 0 to chrArr.length - 1) {
			intArr(i) = chrArr(i).toInt - '0'
		}

		intArr
	}

	// TODO this isn't very Scala-ish either, I guess.
	def intSeqToBigInt(intSeq: Seq[Int]): BigInt = {
		var pwr: BigInt = 1
		var result: BigInt = 0
		val reverseIterator = intSeq.reverseIterator

		for (elem <- reverseIterator) {
			result += pwr * elem
			pwr*=10
		}

		result
	}

	def isCircular(prime: BigInt): Boolean = {
		val intArr: ArraySeq[Int] = createIntArr(prime)
		val permutations = intArr.permutations

		for (perm <- permutations) {
			// TODO find a way to convert a permutation Seq to a BigInt
			val asBigInt: BigInt = intSeqToBigInt(perm)
			if (!primeSet.contains(asBigInt)) {
				return false
			}
		}

		true
	}

	def getCircularPrimes: Set[scala.BigInt] = {
		var circularPrimes: HashSet[BigInt] = new HashSet[BigInt]

		for (p <- primeSet) {
			if (isCircular(p)) {
				circularPrimes.add(p)
			}
		}

		circularPrimes.toSet
	}
}