import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.naming.SizeLimitExceededException;
import javax.naming.TimeLimitExceededException;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class ToDoListTest {

    @Test
    public void checkItemAddIsNull(){
        ToDoList toDoList = new ToDoList();

        Assertions.assertThrows(IllegalArgumentException.class, () -> toDoList.add(null));
    }

    @Test
    public void checkItemAddIsOk() throws SizeLimitExceededException, TimeLimitExceededException {
        ToDoList toDoList = new ToDoList();

        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
    }

    @Test
    public void checkListIsFull() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Assertions.assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        Assertions.assertTrue(toDoList.add(new Item("ghi", "def", LocalDateTime.now().plusMinutes(62))));
        Assertions.assertTrue(toDoList.add(new Item("jkl", "def", LocalDateTime.now().plusMinutes(93))));
        Assertions.assertTrue(toDoList.add(new Item("mno", "def", LocalDateTime.now().plusMinutes(124))));
        Assertions.assertTrue(toDoList.add(new Item("pqr", "def", LocalDateTime.now().plusMinutes(155))));
        Assertions.assertTrue(toDoList.add(new Item("stu", "def", LocalDateTime.now().plusMinutes(186))));
        Assertions.assertTrue(toDoList.add(new Item("vwx", "def", LocalDateTime.now().plusMinutes(217))));
        Assertions.assertTrue(toDoList.add(new Item("yza", "def", LocalDateTime.now().plusMinutes(248))));
        Assertions.assertTrue(toDoList.add(new Item("bcd", "def", LocalDateTime.now().plusMinutes(279))));

        Assertions.assertThrows(ArrayStoreException.class, () -> toDoList.add(new Item("efg", "def", LocalDateTime.now().plusMinutes(300))));

    }

    @Test
    public void checkUniqueItem() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Assertions.assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(30))));
        Assertions.assertThrows(IllegalArgumentException.class, () -> toDoList.add(new Item("def", "ghi", LocalDateTime.now().plusMinutes(60))));

    }

    @Test
    public void checkTimeLimit() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Assertions.assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        Assertions.assertThrows(TimeLimitExceededException.class, () -> toDoList.add(new Item("def", "ghi", LocalDateTime.now().plusMinutes(50))));

    }

    @Test
    public void checkDeleteOk() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Assertions.assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        Assertions.assertTrue(toDoList.delete(1));
    }

    @Test
    public void checkDeleteOutOfBondInf() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Assertions.assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        Assertions.assertThrows(IllegalArgumentException.class, () -> toDoList.delete(-1));
    }

    @Test
    public void checkDeleteOutOfBondSup() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Assertions.assertTrue(toDoList.add(new Item("def", "def", LocalDateTime.now().plusMinutes(31))));
        Assertions.assertThrows(IllegalArgumentException.class, () -> toDoList.delete(2));
    }

    @Test
    public void checkGetOk() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Item it = new Item("def", "def", LocalDateTime.now().plusMinutes(31));
        Assertions.assertTrue(toDoList.add(it));
        Assertions.assertEquals(it, toDoList.get(1));
    }

    @Test
    public void checkGetOutOfBoundInf() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Item it = new Item("def", "def", LocalDateTime.now().plusMinutes(31));
        Assertions.assertTrue(toDoList.add(it));
        Assertions.assertThrows(IllegalArgumentException.class, () -> toDoList.get(-1));
    }

    @Test
    public void checkGetOutOfBoundSup() throws TimeLimitExceededException, SizeLimitExceededException {
        ToDoList toDoList = new ToDoList();
        Assertions.assertTrue(toDoList.add(new Item("abc", "def", LocalDateTime.now())));
        Item it = new Item("def", "def", LocalDateTime.now().plusMinutes(31));
        Assertions.assertTrue(toDoList.add(it));
        Assertions.assertThrows(IllegalArgumentException.class, () -> toDoList.get(2));
    }

}
