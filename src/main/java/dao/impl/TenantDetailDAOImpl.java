/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.TenantDetailDAO;
import entity.TenantDetail;
import java.util.List;

/**
 *
 * @author nhukhue
 */
public class TenantDetailDAOImpl implements TenantDetailDAO{

    private final String createSql = "INSERT INTO Tenant_Details"
                                   + "(Citizen_id, PerCard_FrontImage, PerCard_BackImage, ResidencyStatus, Occupation, Hometown) "
                                   + "VALUES(?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Tenant_Details SET "
                                   + "PerCard_FrontImage=?, PerCard_BackImage=?, ResidencyStatus=?, Occupation=?, Hometown=?"
                                   + "WHERE Citizen_id=?";
    private final String deleteByIdSql = "DELETE FROM Contracts WHERE Citizen_id=?";

    private final String findAllSql = "SELECT * FROM Tenant_Details";
    private final String findByIdSql = findAllSql + " Citizen_id=?";
    
    @Override
    public TenantDetail create(TenantDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TenantDetail entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TenantDetail> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TenantDetail findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
