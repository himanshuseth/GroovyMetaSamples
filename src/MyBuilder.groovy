class MyBuilder {

	String outlineText = ""
	int depth = 0

	def methodMissing(String methodName, args) {
		outlineText += ("  " * depth) + "+" + " ${methodName}\n"
		if (args) {
			def argument = args[0]
			if (argument && argument instanceof Closure) {
				depth++
				Closure clone = argument.clone()
				clone.delegate = this
				clone.call()
				depth--
			}

		}


	}

}
