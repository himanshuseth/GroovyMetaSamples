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

	void testAttributeAccess() {
		ExpandoLite e = new ExpandoLite();
		e.myProp = "myVal"
		e.myProp2 = "myVal2"
		assert e.@dynamicPropMap == [myProp: "myVal", myProp2: "myVal2"]

	}
}
