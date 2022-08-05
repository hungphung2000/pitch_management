package model;
import java.io.Serializable;

public class MiniPitch implements Serializable {

    private String id;

    private String name;

    private float price;

    private String des;

    public MiniPitch() {
    }

    public MiniPitch(String id, String name, float price, String des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.des = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
