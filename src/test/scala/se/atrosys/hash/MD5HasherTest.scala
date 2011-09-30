package se.atrosys.hash

import org.testng.annotations.Test
import org.testng.Assert.assertEquals

/**
 * Created by IntelliJ IDEA.
 * User: ola
 * Date: 9/30/11
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */

class MD5HasherTest {
	@Test
	def md5sumShouldWork() {
		val hasher : MD5Hasher = new MD5Hasher
		assertEquals(hasher.hash(""), new Hash("d41d8cd98f00b204e9800998ecf8427e"))
//		var hash : Hash = new Hash("9e107d9d372bb6826bd81d3542a419d6")
//		assertEquals(hasher.hash("The quick brown fox jumps over the lazy dog"), hash)
//		hasher.hash("The quick brown fox jumps over the lazy dog.") = e4d909c290d0fb1ca068ffaddf22cbd0

	}
}