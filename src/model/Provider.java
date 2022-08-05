package model;
import java.io.Serializable;

public class Provider implements Serializable {
    private int id;

    private String name;

    private String address;

    private String email;

    private String des;

    public Provider() {
    }

    public Provider(int id, String name, String address, String email, String des) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
