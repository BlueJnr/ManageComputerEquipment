/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.beans;

import bluejnr.util.Util;

/**
 *
 * @author kcuadror
 */
public class Manufacturer {
    
    private int id;
    private String name;
    private String address;
    private String RUC;

    public Manufacturer() {
        this.id = Util.generarId();
    }

    public Manufacturer(String name, String address, String RUC) {
        this.id = Util.generarId();
        this.name = name;
        this.address = address;
        this.RUC = RUC;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Manufacturer{" + "id=" + id + ", name=" + name + ", address=" + address + ", RUC=" + RUC + '}';
    }
    
}
