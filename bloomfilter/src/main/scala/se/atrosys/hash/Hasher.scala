package se.atrosys.hash

trait Hasher {
	def hash(s : String) : BigInt
}