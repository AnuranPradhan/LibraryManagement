package net.Xforce.LibraryManagment;

import net.Xforce.LibraryManagment.Entities.Author;
import net.Xforce.LibraryManagment.Entities.Book;
import net.Xforce.LibraryManagment.Entities.Category;
import net.Xforce.LibraryManagment.Entities.Publisher;
import net.Xforce.LibraryManagment.Service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagmentApplication {


	public static void main(String[] args) {SpringApplication.run(LibraryManagmentApplication.class, args);}
	@Bean
public CommandLineRunner commandLineRunner(BookService bookService) {
		return (args)->{
			Book book1=new Book("ABC1","desc1","isbn1");
			Author author=new Author("Auth desc1","author1");
			Category category=new Category("Category1");
			Publisher publisher=new Publisher("Publisher1");
			book1.addAuthor(author);
			book1.addCategory(category);
			book1.addPublisher(publisher);
			bookService.createBook(book1);
		};

}
}
