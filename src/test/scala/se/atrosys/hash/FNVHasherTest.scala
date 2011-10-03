package se.atrosys.hash

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class FNVHasherTest extends FlatSpec with ShouldMatchers {
	"FNV hasher" should "create a non-null and non-empty hash" in {
		val hasher : Hasher = new FNVHasher
		val hash: BigInt = hasher.hash("foobar")
		hash should not be null
		hash should not be 0
	}
//
//	it should "throw NoSuchElementException if an empty stack is popped" in {
//		val emptyStack = new Stack[String]
//		evaluating { emptyStack.pop() } should produce [NoSuchElementException]
//	}
}
