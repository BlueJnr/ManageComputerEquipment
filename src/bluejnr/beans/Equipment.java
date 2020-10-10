/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.beans;

import bluejnr.util.Category;
import bluejnr.util.Status;

/**
 *
 * @author kcuadror
 */
public class Equipment {
    
    private String name;
    private int stock;
    private double price;
    private Category category;
    private Status status;
    private Manufacturer manufacter;

    public Equipment() {
    }

    public Equipment(String name, int stock, Category category, Status state, Manufacturer manufacter) {
        this.name = name;
        this.stock = stock;
        this.category = category;
        this.assignPrice();
        this.status = state;
        this.manufacter = manufacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.assignPrice();
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Manufacturer getManufacter() {
        return manufacter;
    }

    public void setManufacter(Manufacturer manufacter) {
        this.manufacter = manufacter;
    }
    
    private void assignPrice () {
        switch (category){
            case A :
                this.price = 5000;
                break;
            case B :
                this.price = 250;
                break;
            case C :
                this.price = 150;
                break;
            default :
                this.price = 0;
                break;
        }
    }

    @Override
    public String toString() {
        return "Equipment{" + "name=" + name + ", stock=" + stock + ", price=S/." + price + ", category=" + category + ", status=" + status + ", manufacter=" + manufacter + '}';
    }
    
}
