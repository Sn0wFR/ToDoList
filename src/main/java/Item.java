import java.time.LocalDate;
import java.util.Date;

public class Item {
    private String name;
    private String content;
    private LocalDate createDate;

    public Item( String name, String content, LocalDate createDate) {
        this.content = content;
        this.name = name;
        this.createDate = createDate;
    }

    public void  setName(String name){
        this.name=name;
    }

    public void setContent(String name){
        this.content=content;
    }

    public void setDate(LocalDate createDate){
        this.createDate=createDate;
    }

    public String getName(){
        return this.name;
    }

    public String getContent(){
        return this.content;
    }

    public LocalDate getCreateDate(){
        return this.createDate;
    }

    public boolean MaxContent(String content) {

        int length = this.content.length();

        if (length > 1000) {
            return false;
        }
        return true;


    }



}
