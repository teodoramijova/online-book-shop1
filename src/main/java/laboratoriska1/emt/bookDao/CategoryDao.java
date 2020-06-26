package laboratoriska1.emt.bookDao;

import laboratoriska1.emt.bookEntity.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> takeCategories();

    public Category takeCategory(int id);

    public void cutCategory(int id);

    public void refreshCategory();

    public void sumCategory(Category category);
}
