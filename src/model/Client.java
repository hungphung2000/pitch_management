package model;
import java.io.Serializable;


public class Client implements Serializable {
    private int id;

    private String name;

    private String address;

    private String tel;

    private String idCard;

    public Client() {
    }

    public Client(int id, String name, String address, String tel, String idCard) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "client_id: " + id + "name: " + name + "address: " + address + "tel: " + tel + "IdCard: " + idCard;
    }
}
