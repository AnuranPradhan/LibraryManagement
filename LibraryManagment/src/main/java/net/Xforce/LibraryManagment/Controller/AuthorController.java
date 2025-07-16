package net.Xforce.LibraryManagment.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.Xforce.LibraryManagment.Entities.Author;

import net.Xforce.LibraryManagment.Service.AuthorService;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
@GetMapping("/get-authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorService.getAllAuthors());
        return "AuthorDirectory/author";
    } 
  
    @GetMapping("/update-author/{id}")
    public String updateauthor(@PathVariable long id, Author author,Model model) {
       model.addAttribute("author", authorService.getAuthorById(id));
       return "AuthorDirectory/update-author";
    }
    @PostMapping("/save-author/{id}")
    public String saveauthor(@PathVariable long id, Author author, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "AuthorDirectory/update-author";
        }
        authorService.updateAuthor(author);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "AuthorDirectory/author";
    }
    @GetMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable long id, Model model) {
        authorService.deleteAuthorById(id);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "AuthorDirectory/author";
    }
    @GetMapping("/add-author")
    public String addauthor(Author author) {
        return "AuthorDirectory/add-author";
    }
    @PostMapping("/added-author")
    public String addedauthor(Author author,Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "AuthorDirectory/add-author";
        }
        authorService.createAuthor(author);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "AuthorDirectory/author";
    }
}
