package impl;

import dao.UserDAO;
import entity.User;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

public class UserDAOImpl implements UserDAO {

    private final String createSql = "INSERT INTO Contracts"
            + "(Id, RoomId, Tenant, StartDate, EndDate, depositAmount, payment_cycle_months, file_scan_url, Notes) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Contracts SET "
            + "RoomId=?, Tenant=?, StartDate=?, EndDate=?, depositAmount=?, payment_cycle_months=?, file_scan_url=?, Notes=? "
            + "WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM Contracts WHERE Id=?";

    private final String findAllSql = "SELECT * FROM Contracts";
    private final String findByIdSql = findAllSql + " WHERE Id=?";

    @Override
    public User create(User entity) {
        Object[] values = {
                entity.getId(),
                entity.getUsername(),
                entity.getFullname(),
                entity.getEmail(),
                entity.getPhone_number(),
                entity.getRole_id(),
                entity.getCreated_at()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] values = {
                entity.getId(),
                entity.getUsername(),
                entity.getFullname(),
                entity.getEmail(),
                entity.getPhone_number(),
                entity.getRole_id(),
                entity.getCreated_at()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<User> findAll() {
        return XQuery.getBeanList(User.class, findAllSql);
    }

    @Override
    public User findById(String id) {
        return XQuery.getSingleBean(User.class, findByIdSql, id);
    }

}
