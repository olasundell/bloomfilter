package se.atrosys

import util.matching.Regex

class WordListFactory {
	// 585919r4<verb>abalienera:abalienera:abalienerade:abalienerat:abalienerar:abalienera:::::::::

	def extractWord(s: String) : String = {
		val WordRegexp = new Regex("""^([0-9]+r[0-9]*)<([a-z]*)>([^:]*).*""")

		s match {
			case WordRegexp(id, wordClass, word) => {
				word
			}
			case _ => {
				""
			}
		}
	}

	def createWordList() : WordList = {
		var wordList : WordList = new WordList

		val sourceFile = io.Source.fromFile("dsso-utf8.txt")
		val contents = sourceFile.mkString
		val lines = contents.split("\n")

		sourceFile.close()

		for (line <- lines) {
			val word = extractWord(line)
			if (word != null && !word.isEmpty) {
				wordList += word
			}
		}

		wordList
	}
}