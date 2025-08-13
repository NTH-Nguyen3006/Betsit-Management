/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dao.UserDAO;
import entity.User;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author ADMIN
 */
public class UserDAOImpl implements UserDAO {
    String createSql = "INSERT INTO Users (Username, Password, Fullname, Email, PhoneNumber, RoleId, Status, Created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Users SET Password = ?, Fullname = ?, Email = ?, PhoneNumber = ?, RoleId = ?, Status = ?, Created_at = ?  WHERE Username = ?";
    String deleteSql = "DELETE FROM Users WHERE Username = ?";
    String findAllSql = "SELECT * FROM Users";
    String findByIdSql = "SELECT * FROM Users WHERE Username = ?";
    String findByRoleIdSql = "SELECT * FROM Users WHERE RoleId=?";
    String findByUsername = "SELECT * FROM Users WHERE Username = ?";

    @Override
    public User create(User entity) {
        Object[] values = {
                entity.getUsername(),
                entity.getPassword(),
                entity.getFullname(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getRoleId(),
                entity.isStatus(),
                entity.getCreated_at()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(User entity) {
        Object[] values = {
                entity.getPassword(),
                entity.getFullname(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getRoleId(),
                entity.isStatus(),
                entity.getCreated_at(),
                entity.getUsername()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteSql, id);
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
    public List<User> findByRoleId(Integer roleId) {
        return XQuery.getBeanList(User.class, findByRoleIdSql, roleId);
    }

    @Override
    public User findByUsername(String username) {
        return XQuery.getSingleBean(User.class, findByUsername, username);
    }
}
