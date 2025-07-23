package impl;

import dao.UserDAO;
import entity.User;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

public class UserDAOImpl implements UserDAO {

    private final String createSql = "INSERT INTO Users"
            + "(Username, Password, Fullname, Email, PhoneNumber, RoleId, Status, Created_at) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Users SET "
            + "Password=?, Fullname=?, Email=?, PhoneNumber=?, RoleId=?, Status=?, Created_at=?"
            + "WHERE Username=?";
    private final String deleteByIdSql = "DELETE FROM Users WHERE Username=?";

    private final String findAllSql = "SELECT * FROM Users";
    private final String findByIdSql = findAllSql + " WHERE Username=?";
    private final String findByUsername = "SELECT * FROM Users WHERE Username = ?";

    @Override
    public User create(User entity) {
        Object[] values = {
                // entity.(),
                entity.getUsername(),
                entity.getFullname(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getRoleId(),
                entity.getCreated_at()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] values = {
                // entity.getId(),
                entity.getUsername(),
                entity.getFullname(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getRoleId(),
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

    @Override
    public User findByUsername(String username) {
        return XQuery.getSingleBean(User.class, findByUsername, username);
    }

}
