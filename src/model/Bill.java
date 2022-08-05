package model;
import java.io.Serializable;
import java.time.LocalDate;

public class Bill implements Serializable {
    private int id;

    private LocalDate paymentDate;

    private String paymentType;

    private String note;

    private Ticket ticket;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bill() {
    }

    public Bill(int id, LocalDate paymentDate, String paymentType, String note, Ticket ticket, User user) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.note = note;
        this.ticket = ticket;
        this.user = user;
    }
}
