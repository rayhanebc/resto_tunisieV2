/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.DAO;

import java.util.List;

/**
 *
 * @author acer
 */
public interface InterfaceDAO {

    public void create(Object o);

    public void update(Object o);

    public void delete(Object o);

    public Object find(int id);

    public List<Object> displayAll();
}
