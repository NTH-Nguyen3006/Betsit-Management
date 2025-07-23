
package impl;

import java.util.List;

import dao.RoleDAO;
import entity.Role;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author ADMIN
 */
public class RoleDAOImpl implements RoleDAO{
    private final String INSERT_SQL = "INSERT INTO Roles (RoleName, Description) VALUES (?, ?)";
    private final String UPDATE_SQL = "UPDATE Roles SET RoleName=?, Description=? WHERE Id=?";
    private final String DELETE_SQL = "DELETE FROM Roles WHERE Id=?";
    private final String SELECT_ALL_SQL = "SELECT * FROM Roles";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM Roles WHERE Id=?";
    
    @Override
    public Role create(Role entity) {
        Object[] args = {
            entity.getRoleName(),
            entity.getDescription()
        };
        XJdbc.executeUpdate(INSERT_SQL, args);
        return entity;
    }

    @Override
    public void update(Role entity) {
        Object[] args = {
            entity.getRoleName(),
            entity.getDescription(),
            entity.getId() 
        };
        XJdbc.executeUpdate(UPDATE_SQL, args);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<Role> findAll() {
        return XQuery.getBeanList(Role.class, SELECT_ALL_SQL);
    }

    @Override
    public Role findById(Integer id) {
        return XQuery.getSingleBean(Role.class, SELECT_BY_ID_SQL, (int) id);
    }
}
//     @Override
//     public Role findByUsername(String username) {
//         return null;
//     }
// }
