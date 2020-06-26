package laboratoriska1.emt.bookController;

import laboratoriska1.emt.bookEntity.Book;
import laboratoriska1.emt.bookEntity.Category;
import laboratoriska1.emt.bookService.BookService;
import laboratoriska1.emt.bookService.CategoryService;
import org.hibernate.validator.constraints.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/")
public class BookController {

    Random random;
    public BookService bookService;
    public CategoryService categoryService;
    String way;
    Category category;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService){
        this.bookService = bookService;
        this.categoryService = categoryService;
        random = new Random();
    }

    @PostConstruct
    public void typesOfBooks(){
        category = new Category(0, "Fantasy", "Fantasy is a genre of speculative fiction set in a fictional universe, often inspired by real world myth and folklore.");

        Category category1 = new Category(1, "Romance", "Romance is an emotional feeling of love for, or a strong attraction towards another person.");

        Category category2 = new Category(2, "Poetry", "Poetry is a form of literary art in which language is used for its aesthetic and evocative qualities in addition to, or in lieu of, its apparent meaning.");

        categoryService.sumCategory(category);
        categoryService.sumCategory(category1);
        categoryService.sumCategory(category2);

        Book book = new Book(0, "A GAME OF THRONES",7,0,category);
        Book book1 = new Book(1, "Fifty Shades of Grey",5,0,category1);
        Book book2 = new Book(2, "The Iliad and the Odyssey",2,1,category2);

        book.setImageName2("gameofthrones.jpg");
        book1.setImageName2("fiftyshadesofgrey.jpg");
        book2.setImageName2("iliad.jpg");

        bookService.sumBook(book);
        bookService.sumBook(book1);
        bookService.sumBook(book2);

        Path direct = Paths.get("src","main","resources","static");
        way = direct.toFile().getAbsolutePath();
        System.out.println(way);

    }


    @GetMapping("/form")
    public String form(Model model){
        Book book = new Book();
        List<Category>categories = categoryService.takeCategories();
        model.addAttribute("book",book);
        model.addAttribute("categories",categories);
        return "/books-junior";

    }

    @GetMapping("/book")
    public String takeBooks(Model model){
        List<Book> books = bookService.takeBooks();
        model.addAttribute("books",books);
        return "/books";
    }

    @GetMapping("/books/edit/{id}")
    public String takeBook(@PathVariable("id") int id,Model model){
        List<Category>categories = categoryService.takeCategories();
        model.addAttribute("categories",categories);
        Book book = bookService.takeBook(id);
        model.addAttribute("book",book);
        model.addAttribute("categories", categories);
        return "/books-senior";
    }

    @PostMapping("/books-saveBtn")
    public String sumBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) throws IOException{

        if (bindingResult.hasErrors()){
            return "/books-junior";
        }
        else{
            if (book.getImage() != null){
                MultipartFile multipartFile = book.getImage();
                byte[] bytes = multipartFile.getBytes();

                Path path2 = Paths.get(way + "/" + multipartFile.getOriginalFilename());
                Files.write(path2,bytes);
                book.setImageName2(multipartFile.getOriginalFilename());
            }

            book.setID(bookService.takeBooks().size());
            book.setCategory(categoryService.takeCategory(book.getCategoryInt()));
            bookService.sumBook(book);
            return "redirect:/book";
        }

    }

    @PostMapping("/books/edit")
    public String refreshBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) throws IOException{

        if(bindingResult.hasErrors()){
            return "/books-senior";
        }
        else{
            Book book1 = bookService.takeBook((int) book.getID());

            book1.setCategory(categoryService.takeCategory(book.getCategoryInt()));
            book1.setBname(book.getBname());
            book1.setExample(book.getExample());
        }

        return "redirect:/book";
    }

    @GetMapping("/books/delete/{id}")
    public String cutBook(@PathVariable("id") int id){
        bookService.cutBook(id);
        return "redirect:/book";
    }
}
