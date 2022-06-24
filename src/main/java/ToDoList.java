import javax.naming.TimeLimitExceededException;
import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ToDoList {

    private final ArrayList<Item> items;
    private final int foo;

    public ToDoList() {
        this.items = new ArrayList<Item>();
        this.foo = 0;
    }

    public boolean add(Item item) throws TimeLimitExceededException, ArrayStoreException, IllegalArgumentException {

        if (item == null){
            throw new IllegalArgumentException("item not set");
        }

        if (this.items.size() == 10) {
            throw new ArrayStoreException("list is full");
        }

        if (this.items.size() != 0) {

            Date itemDate = Date.from(this.items.get(this.items.size() - 1).getCreateDate().atZone(ZoneId.systemDefault()).toInstant());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(itemDate);

            Date current = Date.from(item.getCreateDate().atZone(ZoneId.systemDefault()).toInstant());

            long calc = current.getTime() - itemDate.getTime();

            if (calc < 1800000) {

                throw new TimeLimitExceededException("You have to wait 30 minutes between two items");
            }
        }

        for (Item i : this.items) {
            if (i.getName().equals(item.getName())) {
                throw new IllegalArgumentException("item already exists");
            }
        }

        if(this.items.size() == 8) {

        }

        this.items.add(item);

        return true;
    }

    public boolean delete(int index){
        if (index < 0 || index >= this.items.size()) {
            throw new IllegalArgumentException("index out of bounds");
        }

        this.items.remove(index);
        return true;
    }

    public Item get(int index) {

        if (index < 0 || index >= this.items.size()) {
            throw new IllegalArgumentException("index out of bounds");
        }

        return this.items.get(index);
    }
}