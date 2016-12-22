package _17_TableView;

import javafx.beans.property.StringProperty;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(){
        this.name = "";
        this.price = 0;
        this.quantity = 0;
    }

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}