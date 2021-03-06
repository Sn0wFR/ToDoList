import org.junit.Test;
import javax.naming.SizeLimitExceededException;
import javax.naming.TimeLimitExceededException;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToDoListTest {

    @Test
    public void checkItemAddIsNull(){
        ToDoList toDoList = new ToDoList();
        assertThrows(IllegalArgumentException.class, () -> toDoList.add(null));
    }

    @Test
    public void checkItemAddIsOk() throws SizeLimitExceededException, TimeLimitExceededException {
        ToDoList toDoList = new ToDoList();

        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
    }

    @Test
    public void checkListIsFull() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        assertTrue(toDoList.add(new Item("ghi", "def", LocalDateTime.now().plusMinutes(62))));
        assertTrue(toDoList.add(new Item("jkl", "def", LocalDateTime.now().plusMinutes(93))));
        assertTrue(toDoList.add(new Item("mno", "def", LocalDateTime.now().plusMinutes(124))));
        assertTrue(toDoList.add(new Item("pqr", "def", LocalDateTime.now().plusMinutes(155))));
        assertTrue(toDoList.add(new Item("stu", "def", LocalDateTime.now().plusMinutes(186))));
        assertTrue(toDoList.add(new Item("vwx", "def", LocalDateTime.now().plusMinutes(217))));
        assertTrue(toDoList.add(new Item("yza", "def", LocalDateTime.now().plusMinutes(248))));
        assertTrue(toDoList.add(new Item("bcd", "def", LocalDateTime.now().plusMinutes(279))));

        assertThrows(ArrayStoreException.class, () -> toDoList.add(new Item("efg", "def", LocalDateTime.now().plusMinutes(320))));

    }

    @Test
    public void checkUniqueItem() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(30))));
        assertThrows(IllegalArgumentException.class, () -> toDoList.add(new Item("def", "ghi", LocalDateTime.now().plusMinutes(60))));

    }

    @Test
    public void checkTimeLimit() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        assertThrows(TimeLimitExceededException.class, () -> toDoList.add(new Item("def", "ghi", LocalDateTime.now().plusMinutes(50))));

    }

    @Test
    public void checkDeleteOk() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        assertTrue(toDoList.delete(1));
    }

    @Test
    public void checkDeleteOutOfBondInf() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        assertThrows(IllegalArgumentException.class, () -> toDoList.delete(-1));
    }

    @Test
    public void checkDeleteOutOfBondSup() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        assertThrows(IllegalArgumentException.class, () -> toDoList.delete(2));
    }

    @Test
    public void checkGetOk() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Item it = new Item("def", "def", LocalDateTime.now().plusMinutes(31));
        assertTrue(toDoList.add(it));
        assertEquals(it, toDoList.get(1));
    }

    @Test
    public void checkGetOutOfBoundInf() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Item it = new Item("def", "def", LocalDateTime.now().plusMinutes(31));
        assertTrue(toDoList.add(it));
        assertThrows(IllegalArgumentException.class, () -> toDoList.get(-1));
    }

    @Test
    public void checkGetOutOfBoundSup() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Item it = new Item("def", "def", LocalDateTime.now().plusMinutes(31));
        assertTrue(toDoList.add(it));
        assertThrows(IllegalArgumentException.class, () -> toDoList.get(2));
    }

}
