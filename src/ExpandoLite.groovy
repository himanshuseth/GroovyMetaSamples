class ExpandoLite {

	def dynamicPropMap = [:]

	void setProperty(String propertyName, value) {
		dynamicPropMap[propertyName] = value
	}

	def getProperty(String propertyName) {
		dynamicPropMap[propertyName]
	}

	def methodMissing(String methodName, args) {
		def method = dynamicPropMap[methodName]
		if (method instanceof Closure) {
			return method(* args)
		}
		throw new MissingMethodException("No Method found ${methodName} with args ${args}")

	}
}
