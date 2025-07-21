<<<<<<< HEAD
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
>>>>>>> Trinh
package impl;

import dao.TenantDetailDAO;
import entity.TenantDetail;
import java.util.List;
<<<<<<< HEAD

public class TenantDetailDAOImpl implements TenantDetailDAO {

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author ADMIN
 */
public class TenantDetailDAOImpl implements TenantDetailDAO {
    private final String INSERT_SQL = "INSERT INTO Tenant_Details (CitizenId, PerCardFrontImage, PerCardBackImage, ResidencyStatus, Occupation, Hometown) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Tenant_Details SET PerCardFrontImage=?, PerCardBackImage=?, ResidencyStatus=?, Occupation=?, Hometown=? WHERE CitizenId=?";
    private final String DELETE_SQL = "DELETE FROM Tenant_Details WHERE CitizenId=?";
    private final String SELECT_ALL_SQL = "SELECT * FROM Tenant_Details";
    private final String SELECT_BY_ID_SQL = SELECT_ALL_SQL + " WHERE CitizenId = ?";

    @Override
    public TenantDetail create(TenantDetail entity) {
        Object[] args = {
            entity.getCitizenId(),
            entity.getPerCardFrontImage(),
            entity.getPerCardBackImage(),
            entity.getResidencyStatus(),
            entity.getOccupation(),
            entity.getHometown()
        };
        XJdbc.executeUpdate(INSERT_SQL, args);
        return entity;
>>>>>>> Trinh
    }

    @Override
    public void update(TenantDetail entity) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        Object[] args = {
            entity.getPerCardFrontImage(),
            entity.getPerCardBackImage(),
            entity.getResidencyStatus(),
            entity.getOccupation(),
            entity.getHometown(),
            entity.getCitizenId()
        };
        XJdbc.executeUpdate(UPDATE_SQL, args);
>>>>>>> Trinh
    }

    @Override
    public void deleteById(String id) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        XJdbc.executeUpdate(DELETE_SQL, id);
>>>>>>> Trinh
    }

    @Override
    public List<TenantDetail> findAll() {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
        return XQuery.getBeanList(TenantDetail.class, SELECT_ALL_SQL);
>>>>>>> Trinh
    }

    @Override
    public TenantDetail findById(String id) {
<<<<<<< HEAD
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

=======
        return XQuery.getSingleBean(TenantDetail.class, SELECT_BY_ID_SQL, id);
    }

    @Override
    public TenantDetail findByUsername(String username) {
        return null; 
    }
>>>>>>> Trinh
}
