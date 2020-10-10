/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.pruebas;

import bluejnr.beans.Equipment;
import bluejnr.beans.Manufacturer;
import bluejnr.beans.Sale;
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
public class Test02 {

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
        System.out.println("\tListar todos los Equipos");
        System.out.println("-------------------------------------------------------------------------");
        
        for (Equipment equipment : dao.findAll()) {
            System.out.println(equipment);
        }
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tBoleta de venta de 4 Laptops");
        System.out.println("-------------------------------------------------------------------------");
        
        System.out.print("\tCantidad");
        System.out.print("\tEquipo");
        System.out.print("\tFabricante");
        System.out.print("\t\tCategoria");
        System.out.print("\tPrecio");
        System.out.print("\tTotal");
        System.out.println();
        Sale sale01 = dao.sellEquipmentByName("Laptop", 4);
        Sale sale02 = dao.sellEquipmentByName("Mouse", 5);
        System.out.println(sale01);
        System.out.println(sale02);
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\tVer el nuevo Stock de las Laptops");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(dao.find("Laptop"));
    }
    
}
