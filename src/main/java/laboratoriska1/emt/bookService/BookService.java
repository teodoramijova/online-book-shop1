package laboratoriska1.emt.bookService;

import laboratoriska1.emt.bookEntity.Book;

import java.util.List;

public interface BookService {

    public List<Book> takeBooks();

    public Book takeBook(int id);

    public void cutBook(int id);

    public void refreshBook(Book book);

    public void sumBook(Book book);


}
