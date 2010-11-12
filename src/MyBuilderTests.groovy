class MyBuilderTests extends GroovyTestCase {

	void testMyMarkUpBuilder() {
		String output = '''+ music
  + styles
    + rock
    + blues
    + jazz
  + vendors
    + Best Buy
    + Amazon
''';
		def outlineBuilder = new MyBuilder()
		outlineBuilder.music {
			styles {
				rock()
				blues()
				jazz()
			}
			vendors {
				"Best Buy"()
				Amazon()
			}
		}

		println outlineBuilder.outlineText

		assert output == outlineBuilder.outlineText
	}

}
