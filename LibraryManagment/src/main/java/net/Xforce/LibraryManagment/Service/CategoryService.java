package net.Xforce.LibraryManagment.Service;

import net.Xforce.LibraryManagment.Entities.Category;

import net.Xforce.LibraryManagment.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }
    public Category getCategoryById(long id){
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category By This Id Not Found"));
    }
    public Category createCategory(Category Category) {
        return categoryRepository.save(Category);
    }

    public void deleteCategoryById(long CategoryId) {
        categoryRepository.deleteById(CategoryId);
    }

    public void updateCategory(Category Category){
         categoryRepository.save(Category);
    }
}
