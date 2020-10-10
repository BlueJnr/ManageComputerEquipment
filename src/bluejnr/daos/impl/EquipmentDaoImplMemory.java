/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.daos.impl;

import bluejnr.beans.Equipment;
import bluejnr.beans.Sale;
import bluejnr.daos.EquipmentDao;
import bluejnr.util.Category;
import bluejnr.util.Status;
import static bluejnr.util.Status.NOT_AVAILABLE;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kcuadror
 */
public class EquipmentDaoImplMemory implements EquipmentDao{
    
    private List<Equipment> equipments;

    public EquipmentDaoImplMemory() {
        equipments = new ArrayList<>();
    }
    
    @Override
    public List<Equipment> findEquipmentByCategory(Category category) {
        List<Equipment> equipmentsByCategory = new ArrayList<>();
        for (Equipment equipment : equipments) {
            if (equipment.getCategory() == category)
                equipmentsByCategory.add(equipment);
        }
        return equipmentsByCategory;
    }
    
    @Override
    public List<Equipment> findEquipmentByStatus(Status status) {
        List<Equipment> equipmentsByCategory = new ArrayList<>();
        for (Equipment equipment : equipments) {
            if (equipment.getStatus() == status)
                equipmentsByCategory.add(equipment);
        }
        return equipmentsByCategory;
    }
    
    @Override
    public Sale sellEquipmentByName(String name, int quantity) {
        Equipment equipmentsold = null;
        for(Equipment equipment:equipments) {
            if(equipment.getName().equals(name)){
                equipment.setStock(equipment.getStock() - quantity);
                equipmentsold = equipment;
                break;
            }
        }
        return new Sale(equipmentsold, quantity);
    }

    @Override
    public double getValorizedStockByCategory(Category category) {
        double valorizedStockByCategory = 0;
        for (Equipment equipment : equipments) {
            if (equipment.getCategory() == category)
                valorizedStockByCategory = valorizedStockByCategory + 
                        (equipment.getPrice() * equipment.getStock());
        }
        return valorizedStockByCategory;
    }

    
    @Override
    public int getStockByCategory(Category category) {
        int stockByCategory = 0;
        for (Equipment equipment : equipments) {
            if (equipment.getCategory() == category)
                stockByCategory = stockByCategory + equipment.getStock();
        }
        return stockByCategory;
    }
    
    @Override
    public void changeStatus(String name) {
        for(Equipment equipment:equipments) {
            if(equipment.getName().equals(name)){
                equipment.setStatus(NOT_AVAILABLE);
                break;
            }
        }         
    }
    
    @Override
    public void create(Equipment t) {
        if(find(t.getName()) == null)
            equipments.add(t);
    }

    @Override
    public Equipment find(String v) {
        for(Equipment equipment:equipments) {
            if(equipment.getName().equals(v))
                return equipment;
        }      
        return null;
    }

    @Override
    public List<Equipment> findAll() {
        return equipments;
    }

    @Override
    public void update(Equipment t) {
        for(int i=0; i<equipments.size(); i++) {
            if(equipments.get(i).getName().equals(t.getName())) {
                equipments.set(i,t);
                break;
            }
        }
    }

    @Override
    public void delete(String id) {
        equipments.remove(find(id));
    }
 
}
