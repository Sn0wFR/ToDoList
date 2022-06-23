import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class ToDoList {

    private ArrayList<Item> items;

    public ToDoList() {
        this.items = new ArrayList<Item>();
    }

    public boolean add(Item item) {

        if(this.items.size() == 10){
            return false;
        }

        Instant instant = Instant.from(this.items.get(this.items.size() - 1).getCreateDate());
        Instant now = Instant.now();

        if((instant.toEpochMilli() - now.toEpochMilli()) < (30 * 60000)){
            return false;
        }

        for (Item i : this.items) {
            if(i.getName().equals(item.getName())){
                return false;
            }
        }

        this.items.add(item);

        return true;
    }

    public void delete(int index){
        this.items.remove(index);
    }

    public Item get(int index){
        return this.items.get(index);
    }

    public ArrayList<Item> getList(){
        return this.items;
    }

}