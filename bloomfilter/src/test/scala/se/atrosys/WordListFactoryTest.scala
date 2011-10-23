package se.atrosys

import org.testng.annotations.Test
import org.testng.Assert.{assertFalse,assertNotNull, assertEquals, assertTrue}


class WordListFactoryTest {
	@Test
	def wordExtractorShouldReturnWord() {
		val factory : WordListFactory = new WordListFactory
		var word = factory.extractWord("1234r4<foobar>ladlas:xyzzy")
		assertNotNull(word, "Word is null.")
		assertFalse(word.isEmpty, "Word is empty. Bugger.")
		assertEquals(word, "ladlas", "Word isn't what it is supposed to be.")

		word = factory.extractWord("#1234r4<foobar>ladlas:xyzzy")
		assertTrue(word.isEmpty, "Word isn't empty, and it is supposed to be.")

		word = factory.extractWord("A1234r4<foobar>ladlas:xyzzy")
		assertTrue(word.isEmpty, "Word isn't empty, and it is supposed to be.")
	}

	@Test
	def wordListFactoryShouldReadWords() {
		val factory : WordListFactory = new WordListFactory

		val wordlist = factory.createWordList()

		assertNotNull(wordlist)
		assertFalse(wordlist.size == 0, "Word list is empty. Bugger!")
	}
}