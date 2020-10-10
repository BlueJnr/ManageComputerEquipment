/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.daos;

import bluejnr.beans.Equipment;
import bluejnr.beans.Sale;
import bluejnr.util.Category;
import bluejnr.util.Status;
import java.util.List;

/**
 *
 * @author kcuadror
 */
public interface EquipmentDao extends EntityDao<Equipment, String>{
    
    public List<Equipment> findEquipmentByCategory(Category category);
    public List<Equipment> findEquipmentByStatus(Status status);
    public Sale sellEquipmentByName(String name, int quantity);
    public double getValorizedStockByCategory(Category category);
    public int getStockByCategory(Category category);
    public void changeStatus(String name);
    
}
