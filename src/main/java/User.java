import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class User {
    public String mail;
    public String firstName;
    public String lastName;
    public LocalDate birthday;
    public ToDoList tdlist;

    public User(
            String mail,
            String firstName,
            String lastName,
            int year,
            int month,
            int day
    ) {
        if(!this.checkDateInput(year,month,day))
            throw new IllegalArgumentException("error: bad date");

        if (!this.checkEmail(mail))
            throw new IllegalArgumentException("error: bad mail");

        if(!this.checkfNameOrLastName(firstName))
            throw new IllegalArgumentException("error: bad first name");

        if(!this.checkfNameOrLastName(lastName))
            throw new IllegalArgumentException("error: bad last name");

            this.mail = mail;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = LocalDate.of(year,month, day);
            this.tdlist = null;

        if(!this.checkDate())
            throw new IllegalArgumentException("too young");
    }

    public void setTdlist(ToDoList tdlist) {
        this.tdlist = tdlist;
    }

    public boolean checkfNameOrLastName(String str) {
        if (str == null || (str.length() <= 0)) {
            System.err.println("name or last name not set");
            return false;
        }
        return true;
    }



    public Boolean checkEmail(String mail) {

        if (mail == null || mail.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (mail.length() < 8)
            return false;

        if (mail.length() > 40)
            return false;

        if (pattern.matcher(mail).matches()) {
            return true;
        }
        return false;
    }

    public boolean checkDateInput( int year, int month, int day) {
        if (year <= 0 )
            return false;

        if (month <= 0 )
            return false;

        if (month > 12 )
            return false;

        if (day <= 0)
            return false;

        if (day > 31)
            return false;
        return true;
    }
    public boolean checkDate() {

        LocalDate todayDate = LocalDate.now();

        int res = todayDate.minusYears((long) this.birthday.getYear()).getYear();

        return res >= 13;
    }

    public boolean sendMail() {
        return false;
    }
}
