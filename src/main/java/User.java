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
            this.mail = mail;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = LocalDate.of(year,month, day);
            this.tdlist = null;
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



    public Boolean checkEmail() {

        if (this.mail == null || this.mail.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +"[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(this.mail).matches()) {
            return true;
        }
        return false;
    }

    public boolean checkDate() {

        LocalDate todayDate = LocalDate.now();

        int res = todayDate.minusYears((long) this.birthday.getYear()).getYear();

        return res >= 13;
    }

}
