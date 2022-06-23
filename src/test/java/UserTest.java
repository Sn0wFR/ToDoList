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
        assertTrue(u.checkEmail());
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
        User u = new User(
                "waïkiki",
                "remy",
                "hamed",
                2001,
                1,
                1
        );
        assertTrue(u.checkDate());
    }

    @Test
    public void noFirstName() {
        User u = new User(
                "waïkiki",
                "",
                "hamed",
                2001,
                1,
                1
        );
        assertFalse(u.checkfNameOrLastName(u.firstName));
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
        String expectedMessage = "the year must be upper than 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void badmonth() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User u = new User(
                    "waïkiki",
                    "",
                    "hamed",
                    1990,
                    0,
                    25
            );
        });
        String expectedMessage = "the month must be upper than 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void badDay() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User u = new User(
                    "waïkiki",
                    "",
                    "hamed",
                    1990,
                    12,
                    0
            );
        });
        String expectedMessage = "the day must be upper than 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


}
