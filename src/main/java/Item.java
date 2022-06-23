import javax.naming.SizeLimitExceededException;
import java.time.LocalDateTime;

public class Item {
    private String name;
    private String content;
    private LocalDateTime createDate;

    public Item( String name, String content, LocalDateTime createDate) throws SizeLimitExceededException {
        if(name == null) {
            throw new IllegalArgumentException("name not set");
        }else if (content == null) {
            throw new IllegalArgumentException("content not set");
        }else if (createDate == null) {
            throw new IllegalArgumentException("createDate not set");
        }else if(content.length() > 1000) {
            throw new SizeLimitExceededException("content is too long");
        }
        this.name = name;
        this.content = content;
        this.createDate = createDate;
    }

    public boolean setName(String name){
        if (name == null) {
            throw new IllegalArgumentException("name not set");
        }
        this.name=name;
        return true;
    }

    public boolean setContent(String content){
        if (content == null) {
            throw new IllegalArgumentException("content not set");
        }
        this.content=content;
        return true;
    }

    public boolean setDate(LocalDateTime createDate){
        if (createDate == null) {
            throw new IllegalArgumentException("createDate not set");
        }
        this.createDate=createDate;
        return true;
    }

    public String getName(){
        return this.name;
    }

    public String getContent(){
        return this.content;
    }

    public LocalDateTime getCreateDate(){
        return this.createDate;
    }

}
