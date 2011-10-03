package se.atrosys.hash

class MD5Hasher extends Hasher {
	val r = Array(7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
		5,  9, 14, 20, 5,  9, 14, 20, 5,  9, 14, 20, 5,  9, 14, 20,
		4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
		6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21)

	val k = Array(0xd76aa478, 0xe8c7b756, 0x242070db, 0xc1bdceee,
		0xf57c0faf, 0x4787c62a, 0xa8304613, 0xfd469501,
		0x698098d8, 0x8b44f7af, 0xffff5bb1, 0x895cd7be,
		0x6b901122, 0xfd987193, 0xa679438e, 0x49b40821,
		0xf61e2562, 0xc040b340, 0x265e5a51, 0xe9b6c7aa,
		0xd62f105d, 0x02441453, 0xd8a1e681, 0xe7d3fbc8,
		0x21e1cde6, 0xc33707d6, 0xf4d50d87, 0x455a14ed,
		0xa9e3e905, 0xfcefa3f8, 0x676f02d9, 0x8d2a4c8a,
		0xfffa3942, 0x8771f681, 0x6d9d6122, 0xfde5380c,
		0xa4beea44, 0x4bdecfa9, 0xf6bb4b60, 0xbebfbc70,
		0x289b7ec6, 0xeaa127fa, 0xd4ef3085, 0x04881d05,
		0xd9d4d039, 0xe6db99e5, 0x1fa27cf8, 0xc4ac5665,
		0xf4292244, 0x432aff97, 0xab9423a7, 0xfc93a039,
		0x655b59c3, 0x8f0ccc92, 0xffeff47d, 0x85845dd1,
		0x6fa87e4f, 0xfe2ce6e0, 0xa3014314, 0x4e0811a1,
		0xf7537e82, 0xbd3af235, 0x2ad7d2bb, 0xeb86d391)

	var h0 : Int = 0x67452301
	var h1 : Int = 0xEFCDAB89
	var h2 : Int = 0x98BADCFE
	var h3 : Int = 0x10325476

	//append "1" bit to message
	//append "0" bits until message length in bits ≡ 448 (mod 512)
	//append length to message
	def createPaddedLength(length: Int) : Int = {
		var padLen: Int = 0

		if (length % 64 > 56) {
			padLen += 64 - length % 64
			padLen += 56
		} else {
			padLen += 56 - length % 64
		}
		length + padLen
	}

	def pad(s : String) : Array[Int] = {
		val paddedLength = createPaddedLength(s.length)
		var arr: Array[Int] = new Array[Int](paddedLength)

		arr
	}

	def hash(s : String) : BigInt = {
		var h0, h1, h2, h3: Int = 0
		//Process the message in successive 512-bit chunks:
//for each 512-bit chunk of message
		for (chunk <- s.grouped(64).toList) {
			//    break chunk into sixteen 32-bit little-endian words w[j], 0 ≤ j ≤ 15
			val words = chunk.grouped(4).toList
			var a = h0
			var b = h1
			var c = h2
			var d = h3

			for (i <- 0 to 63) {
				var f, g: Int = 0
				i match {
				case x if 0 until 15 contains x =>
					f = (b & c) | ((~b) & d)
					g = i
				case x if 16 until 31 contains x =>
					f = (d & b) | ((~d) & c)
					g = (5*i + 1) % 16
				case x if 32 until 47 contains x =>
					f = b ^ c ^ d
					g = (3*i + 5) % 16
				case x if 48 until 63 contains x =>
					f = c ^ (b | (~d))
					g = (7*i) % 16
				case _ =>
					throw new RuntimeException("Apparently a for loop which is supposed to go to 63 has gone beyond its limits")
				}
				        val temp = d
				        d = c
				        c = b
				        b = b + leftrotate((a + f + k(i) + Integer.valueOf(words(g))) , r(i))
				        a = temp
			}
			h0 = h0 + a
			h1 = h1 + b
			h2 = h2 + c
			h3 = h3 + d
		}
		// TODO return a bigint representing the hash.
		h0
//		BigInt.
//		BigInt.apply(new Array(h0, h1, h2, h3))
	}

	def leftrotate (x: Int, c: Int): Int = {
		(x << c) | (x >> (32-c))
	}

	// TODO fix bytesplit
//	def bytesplit(value: Int): Array[Byte] = {
//		Array(
//			(value >>> 24).toByte,
//			(value >>> 16),
//			(value >>> 8),
//			value)
//	}
}