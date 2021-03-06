
import org.junit.Test;

import javax.naming.SizeLimitExceededException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ItemTest {

    @Test
    public void InstanceItemChecking() throws SizeLimitExceededException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Item item = new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime);
        assertNotNull(item);

    }

    @Test
    public void checkNameIsNull() {
        LocalDateTime localDateTime = LocalDateTime.now();
        assertThrows(IllegalArgumentException.class, () -> new Item(null, "Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime));
    }

    @Test
    public void checkContentIsNull() {
        LocalDateTime localDateTime = LocalDateTime.now();
        assertThrows(IllegalArgumentException.class, () -> new Item("Quiche lorraine", null, localDateTime));
    }

    @Test
    public void checkContentIsTooLong() {
        LocalDateTime localDateTime = LocalDateTime.now();
        assertThrows(SizeLimitExceededException.class, () -> new Item("Quiche lorraine", "a".repeat(1001), localDateTime));
    }

    @Test
    public void checkDateIsNull() {
        LocalDateTime localDateTime = LocalDateTime.now();
        assertThrows(IllegalArgumentException.class, () -> new Item("Quiche lorraine", "Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", null));
    }

    @Test
    public void checkSetNameOk() throws SizeLimitExceededException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Item item = new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime);
        assertTrue(item.setName("Quiche lorraine V12 bi-turbo tdci"));
    }

    @Test
    public void checkSetNameIsNull() throws SizeLimitExceededException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Item item = new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime);
        assertThrows(IllegalArgumentException.class, () -> item.setName(null));
    }

    @Test
    public void checkSetContentOk() throws SizeLimitExceededException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Item item = new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime);
        assertTrue(item.setContent("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
    }

    @Test
    public void checkSetContentIsNull() throws SizeLimitExceededException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Item item = new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime);
        assertThrows(IllegalArgumentException.class, () -> item.setContent(null));
    }

    @Test
    public void checkSetDateOk() throws SizeLimitExceededException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Item item = new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime);
        assertTrue(item.setDate(LocalDateTime.now()));
    }

    @Test
    public void checkSetDateIsNull() throws SizeLimitExceededException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Item item = new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons", localDateTime);
        assertThrows(IllegalArgumentException.class, () -> item.setDate(null));
    }


}
