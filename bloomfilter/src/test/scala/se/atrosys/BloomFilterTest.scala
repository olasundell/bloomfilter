package se.atrosys

import org.testng.annotations.{Test}
import org.testng.Assert.assertTrue
import org.testng.Assert.assertFalse

class BloomFilterTest {
	@Test
	def addAndCheck() {
		val filter : BloomFilter = new BloomFilter(17)
		filter.add("foobar")
		assertTrue(filter.check("foobar"))
		assertFalse(filter.check("barfoo"))
		assertFalse(filter.check("qweasd"))
	}
}