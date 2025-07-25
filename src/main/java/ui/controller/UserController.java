/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ui.controller;

import entity.User;

/**
 *
 * @author ADMIN
 */
public interface UserController extends CrudController<User> {
    void fillRoles();   
}
