package laboratoriska1.emt.bookService;

import laboratoriska1.emt.bookEntity.Book;
import laboratoriska1.emt.bookDao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public bookServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> takeBooks() {
        return bookDao.takeBooks();
    }

    @Override
    public Book takeBook(int id) {
        return bookDao.takeBook(id);
    }

    @Override
    public void cutBook(int id) {
        bookDao.cutBook(id);
    }

    @Override
    public void refreshBook(Book book) {
        bookDao.refreshBook(book);
    }

    @Override
    public void sumBook(Book book) {
        bookDao.sumBook(book);
    }
}
