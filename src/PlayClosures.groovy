class TestingClosures {
//	def playw(String msg) {
	def play(String msg) {
		println "playing message ${msg} from class"
	}
}

def play(String msg) {
	println "playing message ${msg} from script"
}

def test = {
	play "test closure"
}
test.delegate = new TestingClosures()
test.resolveStrategy = Closure.DELEGATE_ONLY
//test.resolveStrategy = Closure.DELEGATE_FIRST

test.call()