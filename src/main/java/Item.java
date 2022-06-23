import java.util.Date;

public class Item {
    private String name;
    private String content;
    private Date createDate;

    public Item(String e, String name, String content, Date createDate) {
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

    public void setDate(Date createDate){
        this.createDate=createDate;
    }

    public String getName(){
        return this.name;
    }

    public String getContent(){
        return this.content;
    }

    public Date getCreateDate(){
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
