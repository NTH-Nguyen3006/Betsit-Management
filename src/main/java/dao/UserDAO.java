/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.User;
import java.util.List;

/**
 *
 * @author nhukhue
 */
public interface UserDAO extends CrudDAO<User, String>{
    List<User> findByRoleId(Integer roleId);
}
