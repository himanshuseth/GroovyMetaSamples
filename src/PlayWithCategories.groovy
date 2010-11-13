class MySampleCategory {
	static multiplyBy3(Integer self) {
		self * 3
	}
	
	static add3(Integer self) {
		self + 3
	}

}
println MySampleClass.multiplyBy3(2)

use(MySampleCategory) {
	println 2.multiplyBy3()
}

Integer.mixin MySampleCategory
println 2.multiplyBy3()
