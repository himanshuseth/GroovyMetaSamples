class TestingClosures {
	int count = 20
//	def playw(String msg) {
	def play(String msg) {
		println "playing message ${msg} from class $count"
	}
}

int count = 10
def play(String msg) {
	println "playing message ${msg} from script $count"
}

def test = {countx->
	play "test closure with count val"
	println "count : $countx"
}

test.delegate = new TestingClosures()
//test.resolveStrategy = Closure.DELEGATE_ONLY
test.resolveStrategy = Closure.DELEGATE_FIRST

test(count)
test(20)
//test.call()
/*
def eachClosure = {
	println "predefined closure : ${it}"
}
 list = [1,2,4,5]
list.each eachClosure
*/
