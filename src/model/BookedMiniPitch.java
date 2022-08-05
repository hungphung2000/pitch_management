package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
public class BookedMiniPitch implements Serializable {
    private int id;

    private float price;

    private LocalDate checkin;

    private LocalDate checkout;

    private String note;

    private MiniPitch miniPitch;

    private List<ItemOrder> itemOrderList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MiniPitch getMiniPitch() {
        return miniPitch;
    }

    public void setMiniPitch(MiniPitch miniPitch) {
        this.miniPitch = miniPitch;
    }

    public List<ItemOrder> getItemOrderList() {
        return itemOrderList;
    }

    public void setItemOrderList(List<ItemOrder> itemOrderList) {
        this.itemOrderList = itemOrderList;
    }

    public BookedMiniPitch(int id, float price, LocalDate checkin, LocalDate checkout, String note, MiniPitch miniPitch, List<ItemOrder> itemOrderList) {
        this.id = id;
        this.price = price;
        this.checkin = checkin;
        this.checkout = checkout;
        this.note = note;
        this.miniPitch = miniPitch;
        this.itemOrderList = itemOrderList;
    }

    public BookedMiniPitch() {
    }
}
