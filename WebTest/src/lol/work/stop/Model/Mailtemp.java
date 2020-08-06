package lol.work.stop.Model;

public class Mailtemp {
    String mailtemp;
    
String username;
String password;
    public Mailtemp() {
    }

    public Mailtemp(String mail,String user,String pass) {
        super();
        this.mailtemp=mail;
        this.username=user;
        this.password=pass;

    }

    public String getMailtemp() {
        return mailtemp;
    }

    public void setMailtemp(String mailtemp) {
        this.mailtemp = mailtemp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
