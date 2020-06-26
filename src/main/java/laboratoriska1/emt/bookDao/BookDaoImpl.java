package laboratoriska1.emt.bookDao;

import laboratoriska1.emt.bookEntity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private List<Book> books;

    public BookDaoImpl(){
        books = new ArrayList<>();
    }


    @Override
    public List<Book> takeBooks() {
        return books;
    }

    @Override
    public Book takeBook(int id) {
        Book book = books.get(id);
        return book;
    }

    @Override
    public void cutBook(int id) {
        books.remove(id);
    }

    @Override
    public void refreshBook(Book book) {

    }

    @Override
    public void sumBook(Book book) {
        books.add(book);
    }
}
