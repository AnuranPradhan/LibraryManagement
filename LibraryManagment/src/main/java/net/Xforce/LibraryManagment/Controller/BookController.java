package net.Xforce.LibraryManagment.Controller;


import net.Xforce.LibraryManagment.Entities.Book;
import net.Xforce.LibraryManagment.Service.AuthorService;
import net.Xforce.LibraryManagment.Service.BookService;
import net.Xforce.LibraryManagment.Service.CategoryService;
import net.Xforce.LibraryManagment.Service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
 private BookService bookService;
    @Autowired
    private AuthorService authorService;
@Autowired
    private CategoryService categoryService;
@Autowired
private PublisherService publisherService;

@GetMapping("/get-books")
public String getBooks(Model model){
    List<Book> books = bookService.getAllBooks();
    model.addAttribute("books", books);
    return "BookDirectory/book";
}

@GetMapping("/book/{id}")
public String getBookById(Model model,@PathVariable long id){
bookService.getBookById(id);
model.addAttribute("book", bookService.getBookById(id));
return "BookDirectory/list-book";
}

@GetMapping("/delete/{id}")
public String deleteBookById(@PathVariable long id,Model model){
    bookService.deleteBookById(id);
    model.addAttribute("books", bookService.getAllBooks());
    return "BookDirectory/book";
}
@GetMapping("/update/{id}")
public String updateBook(@PathVariable long id, Model model){
    model.addAttribute("book", bookService.getBookById(id));
    model.addAttribute("authors", authorService.getAllAuthors());
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("publishers", publisherService.getAllPublishers());
    return "BookDirectory/update-book";
}
    @PostMapping("/save-update/{id}")
    public String updatedPage(@PathVariable long id, Book book, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "BookDirectory/update-book";
        }
        bookService.updateBook(book);
        model.addAttribute("books", bookService.getAllBooks());
        return "BookDirectory/book";
    }
@GetMapping("/add-book")
public String addBook(Book book,Model model){
    model.addAttribute("authors", authorService.getAllAuthors());
    model.addAttribute("categories", categoryService.getAllCategories());
    model.addAttribute("publishers", publisherService.getAllPublishers());
    return "BookDirectory/add-book";
}
@PostMapping("/save-book")
public String saveBook(Book book, BindingResult bindingResult, Model model){
    if (bindingResult.hasErrors()) {
        return "BookDirectory/add-book";
    }
    bookService.createBook(book);
    model.addAttribute("books", bookService.getAllBooks());
    return "BookDirectory/book";
}


}
