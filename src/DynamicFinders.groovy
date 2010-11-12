import groovy.sql.Sql;

url = "jdbc:hsqldb:mem:testDb"
driver = "org.hsqldb.jdbcDriver"
user = "sa"
pass = ""

sql = Sql.newInstance(url, user, pass, driver)

//create table
sql.execute('''
		CREATE table book (
			author varchar,
			title varchar 
		)
''')

//Insert Data
(1..<4).each {
	sql.execute('insert into book (author, title) values(?,?)', ["auth$it", "book$it"])
}
Book.metaClass.static.methodMissing = {methodName, args ->
	println "In methodMissing fro method $methodName"
	def impl = {methodArg ->
		def books = []
		String propertyName = methodName[9..-1]
		String query = "select * from book where ${propertyName}=?"
		sql.eachRow(query, [methodArg]) {row ->
			books << new Book(title: row.title, author: row.author)
		}
		return books
	}
	Book.metaClass.static."${methodName}" = impl
	impl(* args)
}

//query Now
def books = Book.findAllByTitle("book1")
books.each {Book book ->
	println "author : ${book.author}, title : ${book.title}"
}
books = Book.findAllByTitle("book2")
books.each {Book book ->
	println "author : ${book.author}, title : ${book.title}"
}
books = Book.findAllByAuthor("auth3")
books.each {Book book ->
	println "author : ${book.author}, title : ${book.title}"
}
books = Book.findAllByAuthor("auth4")
books.each {Book book ->
	println "author : ${book.author}, title : ${book.title}"
}
