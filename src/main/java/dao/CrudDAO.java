
package dao;

import java.util.List;

public interface CrudDAO<T, ID> {
<<<<<<< HEAD
    T create(T entity);

    void update(T entity);

    void deleteById(ID id);

    List<T> findAll();

    T findById(ID id);
=======
    T create(T entity); 
    void update(T entity); 
    void deleteById(ID id); 
    List<T> findAll(); 
    T findById(ID id); 
    T findByUsername(String username);
>>>>>>> Trinh
}
