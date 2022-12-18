package com.rf.khan.api.java8.methodreference;

public class BookImpl {

	public static void main(String[] args) {
		BookInterface bookInterface = (name, description) -> {
			return new Book(name, description);
		};

		Book book = bookInterface.getBookInfo("Java", "java by Arif Khan");
		System.out.println(book.toString());

		BookInterface bookInterfacRef = Book::new;
		Book books = bookInterfacRef.getBookInfo("C++", "Let's learn data structure");
		System.out.println(books.toString());

	}
}
