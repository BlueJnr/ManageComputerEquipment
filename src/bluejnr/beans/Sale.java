/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.beans;

/**
 *
 * @author kcuadror
 */
public class Sale {
    
    private Equipment equipment;
    private int quantity;
    private double total;

    public Sale(Equipment equipment, int quantity) {
        this.equipment = equipment;
        this.quantity = quantity;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return equipment.getPrice()*quantity;
    }    

    @Override
    public String toString() {
        return "\t" + quantity 
                + "\t\t" + equipment.getName()
                + "\t" + equipment.getManufacter().getName()
                + "\t" + equipment.getCategory()
                + "\t" + equipment.getPrice()
                + "\t" + getTotal();
    }
    
    
}
