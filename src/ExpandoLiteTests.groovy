class ExpandoLiteTests extends GroovyTestCase {

	void testDynamicPropertyAccess() {
		ExpandoLite e = new ExpandoLite();
		e.myProp = "myVal"
		assertEquals "myVal", e.myProp
	}

	void testDynamicMethodInvocation() {
		ExpandoLite e = new ExpandoLite();
		e.addNumbers = {a, b ->
			a + b
		}
		assertEquals 100, e.addNumbers(30, 70)
	}
}
