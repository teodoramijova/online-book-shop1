package laboratoriska1.emt.bookEntity;

public class Category {

    private long ID;

    private String NAME;

    private String DETAILS;

    public Category(){

    }

    public Category(long ID, String NAME, String DETAILS) {
        this.ID = ID;
        this.NAME = NAME;
        this.DETAILS = DETAILS;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDETAILS() {
        return DETAILS;
    }

    public void setDETAILS(String DETAILS) {
        this.DETAILS = DETAILS;
    }
}
