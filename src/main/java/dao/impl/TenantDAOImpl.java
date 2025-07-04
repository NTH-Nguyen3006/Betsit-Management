/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.TenantDAO;
import entity.Tenant;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author nhukhue
 */
public class TenantDAOImpl implements TenantDAO{
    
    private final String createSql = "INSERT INTO Tenant"
                                   + "(Citizen_id, FullName, DateOfBirth, PhoneNumber, Email, VehiclePlate) "
                                   + "VALUES(?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Tenant SET "
                                   + "FullName=?, DateOfBirth=?, PhoneNumber=?, Email=?, VehiclePlate=? "
                                   + "WHERE Citizen_id=?";
    private final String deleteByIdSql = "DELETE FROM Tenant WHERE Citizen_id=?";

    private final String findAllSql = "SELECT * FROM Tenant";
    private final String findByIdSql = findAllSql + " WHERE Citizen_id=?";

    @Override
    public Tenant create(Tenant entity) {
        Object[] values = {
            entity.getCitizen_id(),
            entity.getFullName(),
            entity.getDateOfBirth(),
            entity.getPhoneNumber(),
            entity.getEmail(),
            entity.getVehiclePlate()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;    }

    @Override
    public void update(Tenant entity) {
        Object[] values = {
            entity.getCitizen_id(),
            entity.getFullName(),
            entity.getDateOfBirth(),
            entity.getPhoneNumber(),
            entity.getEmail(),
            entity.getVehiclePlate()
        };
        XJdbc.executeUpdate(updateSql, values);    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);    
    }

    @Override
    public List<Tenant> findAll() {
        return XQuery.getBeanList(Tenant.class, findAllSql);    
    }

    @Override
    public Tenant findById(String id) {
        return XQuery.getSingleBean(Tenant.class, findByIdSql, id);    
    }
    
}
