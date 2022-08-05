package model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class Ticket implements Serializable {
    private int id;

    private LocalDate bookingDay;

    private float totalAmount;

    private String note;

    private List<BookedMiniPitch> bookedMiniPitchList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(LocalDate bookingDay) {
        this.bookingDay = bookingDay;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<BookedMiniPitch> getBookedMiniPitchList() {
        return bookedMiniPitchList;
    }

    public void setBookedMiniPitchList(List<BookedMiniPitch> bookedMiniPitchList) {
        this.bookedMiniPitchList = bookedMiniPitchList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Ticket(int id, LocalDate bookingDay, float totalAmount, String note, List<BookedMiniPitch> bookedMiniPitchList, Client client) {
        this.id = id;
        this.bookingDay = bookingDay;
        this.totalAmount = totalAmount;
        this.note = note;
        this.bookedMiniPitchList = bookedMiniPitchList;
        this.client = client;
    }
    private Client client;
    public Ticket() {
    }

    @Override
    public String toString() {
        return id + "," + bookingDay + "," + totalAmount + "";
    }
}
