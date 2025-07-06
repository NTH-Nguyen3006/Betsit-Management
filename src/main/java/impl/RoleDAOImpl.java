package impl;

import dao.RoleDAO;
import entity.Role;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

public class RoleDAOImpl implements RoleDAO {

    private final String createSql = "INSERT INTO Roles"
            + "(Id, Role_name, Description) "
            + "VALUES(?, ?, ?)";
    private final String updateSql = "UPDATE Roles SET "
            + "Id=?, Role_name=?, Description=?"
            + "WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM Invoice_Detail WHERE Invoice_id=?";

    private final String findAllSql = "SELECT * FROM Roles";
    private final String findByIdSql = findAllSql + " WHERE Id=?";

    @Override
    public Role create(Role entity) {
        Object[] values = {
                entity.getId(),
                entity.getRole_name(),
                entity.getDescription()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Role entity) {
        Object[] values = {
                entity.getId(),
                entity.getRole_name(),
                entity.getDescription()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Role> findAll() {
        return XQuery.getBeanList(Role.class, findAllSql);
    }

    @Override
    public Role findById(String id) {
        return XQuery.getSingleBean(Role.class, findByIdSql, id);
    }

}
