package se.atrosys.euler

import collection.SortedSet
import collection.immutable.TreeSet
import collection.mutable.{ArraySeq, HashSet, SetBuilder, LinkedList}

/**
 * @author ola
 */

class PrimeNumberSetFactory() {


	var primesThusFar: HashSet[BigInt] = new HashSet[BigInt]()

	primesThusFar.add(2)
	primesThusFar.add(3)

	def calcPrimes(ceilingChecker: CeilingChecker) {
		var i : BigInt =5
		ceilingChecker.configure(primesThusFar)
		while (!ceilingChecker.hasCeilingBeenReached(i)) {
			if (isPrimeThusFar(i)) {
				primesThusFar.add(i)
			}
			i += 2;
		}
	}

	def ceilingNotReached(ceiling: Int): Boolean = {
		primesThusFar.size < ceiling
	}

	def isPrimeThusFar(i: BigInt) : Boolean = {
		if (primesThusFar.contains(i)) {
			return true
		}

		for (p <- primesThusFar) {
			if (i % p == 0) {
				return false;
			}
		}

		true
	}

	def getPrimes: HashSet[BigInt] = {
		primesThusFar
	}

	def getSortedPrimes: SortedSet[BigInt] = {
		var sortedSet: TreeSet[BigInt] = new TreeSet[BigInt]
		sortedSet ++= primesThusFar
		sortedSet
	}

}