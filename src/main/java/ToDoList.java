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

        /*
        if(this.items[0]){
            return false;
        }*/

        for (Item i : this.items) {
            if(i.getName().equals(item.getName())){
                return false;
            }
        }

        this.items.add(item);

        return true;
    }

    /*
    public delete(){

    }*/

    public ArrayList<Item> getList(){
        return this.items;
    }

}