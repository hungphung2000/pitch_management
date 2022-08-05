package model;

import java.io.Serializable;

public class ItemOrder implements Serializable {
    private int id;
    private int quantity;
    private float price;
    private Item item;
    private float totalAmount;

    private int bookedMiniPitchId;
    public ItemOrder() {
    }

    public int getBookedMiniPitchId() {
        return bookedMiniPitchId;
    }

    public void setBookedMiniPitchId(int bookedMiniPitchId) {
        this.bookedMiniPitchId = bookedMiniPitchId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ItemOrder(int id, int quantity, float price, float totalAmount, Item item) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.totalAmount = totalAmount;
        this.item = item;
    }

    @Override
    public String toString() {
        return "itemorder_id: " + "quantity: " + quantity + "price: " + price + "total_amount: " + totalAmount;
    }
}
