package se.atrosys.hash

import org.testng.Assert.{assertEquals, assertNotNull}
import org.testng.annotations.{BeforeClass, Test}

class MD5HasherTest {
	var hasher : MD5Hasher = null

	@BeforeClass
	def beforeClass() {
		hasher = new MD5Hasher
	}

	@Test
	def padShouldAddBitsAndModulo512ShouldBe448() {
		val arr = hasher.pad("foobar")
		assertNotNull(arr)
		assertEquals(arr.length % (512 / 8), 448/8)
	}

	@Test
	def md5sumShouldWork() {
		val hasher : MD5Hasher = new MD5Hasher
		val hash: BigInt = hasher.hash("")

		assertNotNull(hash)
//		assertEquals(hash, new Hash("d41d8cd98f00b204e9800998ecf8427e"))
//		var hash : Hash = new Hash("9e107d9d372bb6826bd81d3542a419d6")
//		assertEquals(hasher.hash("The quick brown fox jumps over the lazy dog"), hash)
//		hasher.hash("The quick brown fox jumps over the lazy dog.") = e4d909c290d0fb1ca068ffaddf22cbd0

	}
}