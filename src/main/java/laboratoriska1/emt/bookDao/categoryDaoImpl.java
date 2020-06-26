package laboratoriska1.emt.bookDao;

import laboratoriska1.emt.bookEntity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class categoryDaoImpl implements CategoryDao {

    private List<Category> categories;

    public categoryDaoImpl(){
        categories = new ArrayList<>();
    }

    @Override
    public List<Category> takeCategories() {
        return categories;
    }

    @Override
    public Category takeCategory(int id) {
        Category category = categories.get(id);
        return category;
    }

    @Override
    public void cutCategory(int id) {
        categories.remove(id);
    }

    @Override
    public void refreshCategory() {

    }

    @Override
    public void sumCategory(Category category) {
        categories.add(category);
    }
}
