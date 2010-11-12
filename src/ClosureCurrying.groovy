def addNumbers = {a,b,c->
	a * (b + c)
}

assert 2 * (3 + 4) == addNumbers(2,3,4)

def multiplySumBy2 = addNumbers.curry(2)

assert 2 * (3 + 4) == multiplySumBy2(3,4)

def add3AndMultiplyBy2 = multiplySumBy2.curry(3)

assert 2 * (3 + 4) == add3AndMultiplyBy2(4)



