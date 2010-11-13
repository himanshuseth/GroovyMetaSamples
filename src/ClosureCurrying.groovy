def addNumbers = {a,b,c->
	a * (b + c)
}

assert 2 * (3 + 4) == addNumbers(2,3,4)

def multiplySumBy2 = addNumbers.curry(2)

assert 2 * (3 + 4) == multiplySumBy2(3,4) //addNumbers(2,3,4)

def add3AndMultiplyBy2 = multiplySumBy2.curry(3)

def test = addNumbers.ncurry(1,3,4)
assert 2 * (3 + 4) == add3AndMultiplyBy2(4)
assert 2 * (3 + 4) == test(2)



