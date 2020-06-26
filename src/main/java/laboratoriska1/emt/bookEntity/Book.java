package laboratoriska1.emt.bookEntity;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

    private long ID;

    @NotNull(message = "*The name is required")
    @Size(min = 1,message = "*The name is very short")
    private String Bname;

    @NotNull(message = "The number is required")
    @Min(value = 0,message = "*You entered a negative number")
    private int example;

    private int categoryInt;

    private Category category;

    private MultipartFile image;

    private String imageName;

    public Book(){

    }

    public Book(long ID, String bname, int example, int categoryInt, Category category) {
        this.ID = ID;
        Bname = bname;
        this.example = example;
        this.categoryInt = categoryInt;
        this.category = category;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public int getExample() {
        return example;
    }

    public void setExample(int example) {
        this.example = example;
    }

    public int getCategoryInt() {
        return categoryInt;
    }

    public void setCategoryInt(int categoryInt) {
        this.categoryInt = categoryInt;
    }


    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName2(String imageName) {
        this.imageName = imageName;
    }

    public void setImageName(MultipartFile imageName){
        this.imageName = imageName.getOriginalFilename();
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }
}
