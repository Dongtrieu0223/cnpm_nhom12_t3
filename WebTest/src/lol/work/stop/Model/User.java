package lol.work.stop.Model;

public class User {
    int id;
    String uname;
    String pass;
    int idGroup;
    int active;

    public User() {
    }

    public User(int id, String uname, String pass, int idGroup, int active) {
        super();
        this.id = id;
        this.uname = uname;
        this.pass = pass;
        this.idGroup = idGroup;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int hide) {
        this.active = hide;
    }
    
}
