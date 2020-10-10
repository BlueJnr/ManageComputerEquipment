/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.daos.impl;

import bluejnr.daos.EquipmentDao;
import static bluejnr.util.Util.MEMORY;

/**
 *
 * @author kcuadror
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public EquipmentDao getEquipmentDao(int tipo){
        EquipmentDao dao ;
        switch(tipo){
            case MEMORY: dao = new EquipmentDaoImplMemory(); break;
            default : dao=null;
        }
        return dao;
    }
    
}
