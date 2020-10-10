/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.pruebas;

import bluejnr.beans.Equipment;
import bluejnr.beans.Manufacturer;
import bluejnr.daos.EquipmentDao;
import bluejnr.daos.impl.DaoFactory;
import static bluejnr.util.Category.A;
import static bluejnr.util.Category.B;
import static bluejnr.util.Category.C;
import static bluejnr.util.Status.AVAILABLE;
import static bluejnr.util.Util.opc;

/**
 *
 * @author kcuadror
 */
public class Test01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        EquipmentDao dao = factory.getEquipmentDao(opc);
        
        Manufacturer manufacturer01 = 
                new Manufacturer("ASUS PERU S.A.C", 
                        "Av. Dionisio Derteano Nro. 184 Dpto. 203", 
                        "20554382933");
        Manufacturer manufacturer02 = 
                new Manufacturer("HP INC PERU S.R.L.", 
                        "Cal. las Begonias Nro. 415 Int. P14 (Torre Begonias Lima 27 Piso 14)", 
                        "20600216512");
        Manufacturer manufacturer03 = 
                new Manufacturer("HP INC PERU S.R.L.", 
                        "Av. Salaverry 3310, Magdalena del Mar, Lima, Perú", 
                        "20378890161");
        
        Equipment equipment01 = new Equipment("Laptop", 11, A, AVAILABLE, manufacturer01);
        Equipment equipment02 = new Equipment("Mouse", 7, B, AVAILABLE, manufacturer02);
        Equipment equipment03 = new Equipment("Headphones", 9, C, AVAILABLE, manufacturer02);
        Equipment equipment04 = new Equipment("Keyboard", 4, B, AVAILABLE, manufacturer01);
        Equipment equipment05 = new Equipment("Cooler", 14, C, AVAILABLE, manufacturer03);
        
        dao.create(equipment01);
        dao.create(equipment02);
        dao.create(equipment03);
        dao.create(equipment04);
        dao.create(equipment05);
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tListar Equipos por Categoria 'A'");
        System.out.println("-------------------------------------------------------------------------");
        
        for (Equipment equipment : dao.findEquipmentByCategory(A)) {
            System.out.println(equipment);
        }
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Número de elementos: " + dao.getStockByCategory(A));
        System.out.print("\t\tStock valorizado: " + dao.getValorizedStockByCategory(A) + "\n");
        System.out.println("-------------------------------------------------------------------------");
        
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tListar Equipos por Categoria 'B'");
        System.out.println("-------------------------------------------------------------------------");
        
        for (Equipment equipment : dao.findEquipmentByCategory(B)) {
            System.out.println(equipment);
        }
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Número de elementos: " + dao.getStockByCategory(B));
        System.out.print("\t\tStock valorizado: " + dao.getValorizedStockByCategory(B) + "\n");
        System.out.println("-------------------------------------------------------------------------");
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tListar Equipos por Categoria 'C'");
        System.out.println("-------------------------------------------------------------------------");
        
        for (Equipment equipment : dao.findEquipmentByCategory(C)) {
            System.out.println(equipment);
        }
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("Número de elementos: " + dao.getStockByCategory(C));
        System.out.print("\t\tStock valorizado: " + dao.getValorizedStockByCategory(C) + "\n");
        System.out.println("-------------------------------------------------------------------------");
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tDar de baja al Cooler");
        System.out.println("-------------------------------------------------------------------------");
        
        dao.changeStatus("Cooler");
        System.out.println(dao.find("Cooler"));
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tListar todos los Equipos");
        System.out.println("-------------------------------------------------------------------------");
        
        for (Equipment equipment : dao.findAll()) {
            System.out.println(equipment);
        }
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tListar solo Equipos Disponibles (No estan de baja)");
        System.out.println("-------------------------------------------------------------------------");
        
        for (Equipment equipment : dao.findEquipmentByStatus(AVAILABLE)) {
            System.out.println(equipment);
        }
    }
    
}
