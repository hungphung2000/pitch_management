package model;
import java.io.Serializable;
public class Pitch implements Serializable {
    private int id;

    private String name;

    private String address;

    private String des;

    public Pitch(int id, String name, String address, String des) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.des = des;
    }

    public Pitch() {
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
