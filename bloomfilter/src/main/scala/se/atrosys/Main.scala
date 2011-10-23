package se.atrosys

object Main {
	def main ( args : Array[String] ) {
		val filter : BloomFilter = new BloomFilter(30);
		val wordList : WordList = new WordListFactory().createWordList();

		for (word <- wordList) {
			filter.add(word)
		}

		println(filter)
	}

}