//import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


 // Nous avons essayé d'utiliser Mockito mais impossible car "java: package org.mockito does not exist" alors qu'il est présent dans les imports et dans le pom.xml
 // Nous avons commenté tous les import et le code effectué pour faire un Mock, tous les test sans mock fonctionnent

//@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    private User customUser;

    /*
    @Before
    public void setUp() {

        customUser = Mockito.mock(User.class);

    }*/

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

    /*
    @Test
    public void checkSendMailOk() {
        Mockito.when(this.customUser.sendMail()).thenReturn(true);
        assertTrue(this.customUser.sendMail());
    }*/
}
