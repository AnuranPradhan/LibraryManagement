package net.Xforce.LibraryManagment.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.Xforce.LibraryManagment.Entities.Book;
@Repository
public interface BookRepositories extends JpaRepository<Book, Long>{
	  
}
