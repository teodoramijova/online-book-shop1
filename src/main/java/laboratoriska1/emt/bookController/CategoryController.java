package laboratoriska1.emt.bookController;

import laboratoriska1.emt.bookEntity.Category;
import laboratoriska1.emt.bookService.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;
    Random random;

    public CategoryController(CategoryService categoryService){
    this.categoryService = categoryService;
    random = new Random();
    }

    @PostConstruct
    public void update(){
        Category category = new Category(3, "Drama", "Drama is the specific mode of fiction represented in performance: a play, opera, mime, ballet, etc., performed in a theatre, or on radio or television.");

        categoryService.sumCategory(category);
    }

    @GetMapping("/categories")
    public List<Category> takeCategories(){
        return categoryService.takeCategories();
    }

    @DeleteMapping("/categories/{id}")
    public void cutCategory(@PathVariable("id") int id) {
        categoryService.cutCategory(id);
    }

    @PostMapping("/categories")
    public void sumBook(@RequestBody Category category){
        category.setID(categoryService.takeCategories().size()+1);
        categoryService.sumCategory(category);
    }
}
