package se.atrosys.hash

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class PearsonHasherTest extends FlatSpec with ShouldMatchers {
	"Pearson hasher" should "create a non-null and non-empty hash" in {
		val hasher : Hasher = new PearsonHasher
		val hash: BigInt = hasher.hash("foobar")
		hash should not be null
		hash should not be 0
	}
}

