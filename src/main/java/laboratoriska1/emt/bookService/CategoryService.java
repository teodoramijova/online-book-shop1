package laboratoriska1.emt.bookService;

import laboratoriska1.emt.bookEntity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> takeCategories();

    public Category takeCategory(int id);

    public void cutCategory(int id);

    public void refreshCategory();

    public void sumCategory(Category category);
}
