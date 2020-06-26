package laboratoriska1.emt.bookService;

import laboratoriska1.emt.bookEntity.Category;
import laboratoriska1.emt.bookDao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> takeCategories() {
        return categoryDao.takeCategories();
    }

    @Override
    public Category takeCategory(int id) {
        return categoryDao.takeCategory(id);
    }

    @Override
    public void cutCategory(int id) {
        categoryDao.cutCategory(id);
    }

    @Override
    public void refreshCategory() {

    }

    @Override
    public void sumCategory(Category category) {
        categoryDao.sumCategory(category);
    }
}
