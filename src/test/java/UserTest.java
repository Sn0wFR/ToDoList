import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void valideEmail() {
        User u = new User(
                "superpapate@frite.fr",
                "remy",
                "hamed",
                2001,
                1,
                1
        );
        String address = "superpapate@frite.fr";
        assertEquals(address, u.mail);
    }


    @Test
    public void valideFirstName() {
        User u = new User(
                "superpapate@frite.fr",
                "remy",
                "hamed",
                2001,
                1,
                1
        );
        assertTrue(u.checkfNameOrLastName(u.firstName));
    }

    @Test
    public void validelastName() {
        User u = new User(
                "superpapate@frite.fr",
                "remy",
                "hamed",
                2001,
                1,
                1
        );
        assertTrue(u.checkfNameOrLastName(u.lastName));
    }

    @Test
    public void valideDate() {
        User u = new User(
                "superpapate@frite.fr",
                "remy",
                "hamed",
                2001,
                1,
                1
        );
        assertTrue(u.checkDate());
    }

    @Test
    public void badMail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User u = new User(
                    "waïkiki",
                    "remy",
                    "hamed",
                    2001,
                    1,
                    1
            );
        });
        String expectedMessage = "bad mail";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void noFirstName() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User u = new User(
                    "waikiki@hotmail.fr",
                    "",
                    "hamed",
                    2001,
                    1,
                    1
            );
        });
        String expectedMessage = "error: bad first name";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void badYear() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User u = new User(
                    "waïkiki",
                    "",
                    "hamed",
                    0,
                    12,
                    25
            );
        });
        String expectedMessage = "bad date";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void badmonth() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User u = new User(
                    "waikiki@hotmail.fr",
                    "",
                    "hamed",
                    1990,
                    0,
                    25
            );
        });
        String expectedMessage = "error: bad date";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void babySubscribe() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User u = new User(
                    "waikiki@hotmail.fr",
                    "toto",
                    "hamed",
                    2019,
                    12,
                    1
            );
        });
        String expectedMessage = "too young";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


}
