package model;
import java.io.Serializable;
public class User implements Serializable {
    
    private int id;

    private String username;

    private String password;

    private String name;

    private String pos;

    public User(int id, String username, String password, String name, String pos) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.pos = pos;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
