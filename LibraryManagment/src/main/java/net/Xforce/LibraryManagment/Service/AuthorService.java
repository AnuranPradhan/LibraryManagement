package net.Xforce.LibraryManagment.Service;

import net.Xforce.LibraryManagment.Entities.Author;

import net.Xforce.LibraryManagment.Repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getAllAuthors() {

        return authorRepository.findAll();
    }
    public Author getAuthorById(long id){
        return authorRepository.findById(id).orElseThrow(()->new RuntimeException("Author By This Id Not Found"));
    }
    public Author createAuthor(Author Author) {
        return authorRepository.save(Author);
    }

    public void deleteAuthorById(long AuthorId) {
        authorRepository.deleteById(AuthorId);
    }

    public void updateAuthor(Author Author){
         authorRepository.save(Author);
    }
}
