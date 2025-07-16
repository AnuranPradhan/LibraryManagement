package net.Xforce.LibraryManagment.Controller;

import net.Xforce.LibraryManagment.Entities.Category;
import net.Xforce.LibraryManagment.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/get-category")
    public String getCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "CategoryDirectory/category";
    }

    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable long id, Category category,Model model) {
       model.addAttribute("category", categoryService.getCategoryById(id));
       return "CategoryDirectory/update-category";
    }
    @PostMapping("/save-category/{id}")
    public String saveCategory(@PathVariable long id, Category category, Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "CategoryDirectory/update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "CategoryDirectory/category";
    }
    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable long id, Model model) {
        categoryService.deleteCategoryById(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "CategoryDirectory/category";
    }
    @GetMapping("/add-category")
    public String addCategory(Category category) {
        return "CategoryDirectory/add-category";
    }
    @PostMapping("/added-category")
    public String addedCategory(Category category,Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "CategoryDirectory/add-category";
        }
        categoryService.createCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "CategoryDirectory/category";
    }
}
