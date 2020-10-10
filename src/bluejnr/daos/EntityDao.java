/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluejnr.daos;

import java.util.List;

/**
 *
 * @author kcuadror
 * @param <T>
 * @param <V>
 */
public interface EntityDao<T,V> {
    
    public void create(T t);
    
    public T find(V v);
    public List<T> findAll();
    
    public void update(T t);
    public void delete(V v);
    
}
