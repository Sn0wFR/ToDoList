import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ToDoListTest {

    @Test
    public void addItem() {
        ToDoList toDoList = new ToDoList();
        toDoList.add(new Item("abc", "def", LocalDate.now()));
    }
}
