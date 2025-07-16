/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dao.TenantDAO;
import entity.Tenant;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author ADMIN
 */
public class TenantDAOImpl implements TenantDAO{
    private final String INSERT_SQL = "INSERT INTO Tenants (CitizenId, FullName, DateOfBirth, PhoneNumber, Email, VehiclePlate) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Tenants SET FullName=?, DateOfBirth=?, PhoneNumber=?, Email=?, VehiclePlate=? WHERE CitizenId=?";
    private final String DELETE_SQL = "DELETE FROM Tenants WHERE CitizenId=?";
    private final String SELECT_ALL_SQL = "SELECT * FROM Tenants";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM Tenants WHERE CitizenId=?";
    
    @Override
    public Tenant create(Tenant entity) {
        XJdbc.executeUpdate(INSERT_SQL,
            entity.getCitizenId(),
            entity.getFullName(),
            entity.getDateOfBirth(),
            entity.getPhoneNumber(),
            entity.getEmail(),
            entity.getVehiclePlate()
        );
        return entity;
    }

    @Override
    public void update(Tenant entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
            entity.getFullName(),
            entity.getDateOfBirth(),
            entity.getPhoneNumber(),
            entity.getEmail(),
            entity.getVehiclePlate(),
            entity.getCitizenId()
        );
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<Tenant> findAll() {
        return XQuery.getBeanList(Tenant.class, SELECT_ALL_SQL);
    }

    @Override
    public Tenant findById(String id) {
        return XQuery.getSingleBean(Tenant.class, SELECT_BY_ID_SQL, id);
    }

    @Override
    public Tenant findByUsername(String username) {
        return null; 
    }
}
