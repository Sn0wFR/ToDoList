import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

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


}
