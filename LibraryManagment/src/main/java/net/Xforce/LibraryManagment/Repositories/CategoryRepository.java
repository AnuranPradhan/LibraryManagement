package net.Xforce.LibraryManagment.Repositories;

import net.Xforce.LibraryManagment.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
