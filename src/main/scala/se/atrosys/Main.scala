package se.atrosys

object Main {
	def main ( args : Array[String] ) {
		var filter : BloomFilter = new BloomFilter;
		System.out.println(filter)
		filter.add("foobar")
		System.out.println(filter)
		System.out.println(filter.check("foobar"))
		System.out.println(filter.check("barfoo"))
	}

}