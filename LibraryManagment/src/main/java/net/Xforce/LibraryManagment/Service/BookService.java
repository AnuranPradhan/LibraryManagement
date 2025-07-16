package net.Xforce.LibraryManagment.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.Xforce.LibraryManagment.Entities.Book;
import net.Xforce.LibraryManagment.Repositories.BookRepositories;

@Service
public class BookService {

	@Autowired
private  BookRepositories bookRepositories;


	public List<Book> getAllBooks() {

		return bookRepositories.findAll();
	}
public Book getBookById(long id){
		return bookRepositories.findById(id).orElseThrow(()->new RuntimeException("Book By This Id Not Found"));
}
	public Book createBook(Book book) {
		return bookRepositories.save(book);
	}

	public void deleteBookById(long bookId) {
	bookRepositories.deleteById(bookId);
	}

	public void updateBook(Book book){
		 bookRepositories.save(book);
	}

}
