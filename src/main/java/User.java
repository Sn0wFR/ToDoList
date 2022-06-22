import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    public String mail;
    public String firstName;
    public String lastName;
    public Date birthday;
    public ToDoList tdlist;

    public User(
            String mail,
            String firstName,
            String lastName,
            String birthday
    ) throws ParseException {
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
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


    /*
    public checkEmail(String str) {

      return CustomEmailValidator(str);
    }*/

    public boolean checkDate(Date d) {

        Date todayDate = new Date();

        int res = todayDate.getYear() - d.getYear();

        return res >= 13;
    }

}
