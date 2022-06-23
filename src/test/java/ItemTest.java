import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;




public class ItemTest {


    @Test
    public void InstanceItemChecking(){
        LocalDate localDate = LocalDate.now();
        Item item=new Item("Quiche lorraine","Des oeufs, une pâte brisée, de la crème, du fromage et des lardons",localDate);
        Assertions.assertTrue(item!=null);

    }
    @Test
    public void NotcreateItemChecking(){
        LocalDate localDate = LocalDate.now();
        Item firstItem = new Item("Clafoutis aux cerises", "", localDate);
        Assertions.assertTrue(firstItem.getContent().length()==0||firstItem.getName().length()==0||localDate==null);
    }
    @Test
    public void sizeContentValidChecking() {
        LocalDate localDate = LocalDate.now();
        Item firstItem = new Item("Poule au pot", "Version ancienne", localDate);
        Assertions.assertTrue(firstItem.getContent().length()<=10000);

    }
    @Test
    public void sizeContentNotVlidChecking() {
        LocalDate localDate = LocalDate.now();
        Item firstItem = new Item("Hachis parmentier", "Version traditionnelle", localDate);
        Assertions.assertFalse(firstItem.getContent().length()>1000);

    }
    @Test
    public void notNullContentChecking() {
        LocalDate localDate = LocalDate.now();
        Item i = new Item("Filet mignon en croûte", "Version classique", localDate);
        Assertions.assertTrue(i.getContent().length()>0);
    }
    @Test
    public void nameContentChecking() {
        LocalDate localDate = LocalDate.now();
        Item i = new Item("Gigot d'agneau à l'ail et au romarin", "epices-gigot", localDate);
        Assertions.assertTrue(i.getName().length()>0);

    }
    @Test
    public void nameNullContentChecking() {
        LocalDate localDate = LocalDate.now();
        Item i = new Item("", "epices-gigot", localDate);
        Assertions.assertFalse(i.getName().length()>0);

    }
    @Test
    public void NullContentChecking() {
        LocalDate localDate = LocalDate.now();
        Item i = new Item("Pot au feu de boeuf ", "", localDate);
        Assertions.assertFalse(i.getContent().length()>0);
    }





}
