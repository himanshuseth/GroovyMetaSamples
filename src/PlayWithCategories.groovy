class MySampleCategory {
	static multiplyBy3(Integer self) {
		self * 3
	}
	
	static add3(Integer self) {
		self + 3
	}

}
println "hello"

use(MySampleCategory) {
	println 2.multiplyBy3()
}

Integer.mixin MySampleCategory
println 2.multiplyBy3()
