/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dao.TenantDetailDAO;
import entity.TenantDetail;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author ADMIN
 */
public class TenantDetailDAOImpl implements TenantDetailDAO {
    private final String INSERT_SQL = "INSERT INTO Tenant_Details (Citizen_id, PerCard_FrontImage, PerCard_BackImage, ResidencyStatus, Occupation, Hometown) VALUES (?, ?, ?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Tenant_Details SET PerCard_FrontImage=?, PerCard_BackImage=?, ResidencyStatus=?, Occupation=?, Hometown=? WHERE Citizen_id=?";
    private final String DELETE_SQL = "DELETE FROM Tenant_Details WHERE Citizen_id=?";
    private final String SELECT_ALL_SQL = """
                                            SELECT 
                                                Citizen_id AS citizenId,
                                                PerCard_FrontImage AS perCardFrontImage,
                                                PerCard_BackImage AS perCardBackImage,
                                                ResidencyStatus AS residencyStatus,
                                                Occupation AS occupation,
                                                Hometown AS hometown
                                            FROM Tenant_Details
                                            """;
    private final String SELECT_BY_ID_SQL = """
                                            SELECT 
                                                Citizen_id AS citizenId,
                                                PerCard_FrontImage AS perCardFrontImage,
                                                PerCard_BackImage AS perCardBackImage,
                                                ResidencyStatus AS residencyStatus,
                                                Occupation AS occupation,
                                                Hometown AS hometown
                                            FROM Tenant_Details WHERE Citizen_id = ?
                                            """;

    @Override
    public TenantDetail create(TenantDetail entity) {
        Object[] args = {
            entity.getCitizenId(),
            entity.getPerCardFrontImage(),
            entity.getPerCardBackImage(),
            entity.isResidencyStatus(),
            entity.getOccupation(),
            entity.getHometown()
        };
        XJdbc.executeUpdate(INSERT_SQL, args);
        return entity;
    }

    @Override
    public void update(TenantDetail entity) {
        Object[] args = {
            entity.getPerCardFrontImage(),
            entity.getPerCardBackImage(),
            entity.isResidencyStatus(),
            entity.getOccupation(),
            entity.getHometown(),
            entity.getCitizenId()
        };
        XJdbc.executeUpdate(UPDATE_SQL, args);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<TenantDetail> findAll() {
        return XQuery.getBeanList(TenantDetail.class, SELECT_ALL_SQL);
    }

    @Override
    public TenantDetail findById(String id) {
        return XQuery.getSingleBean(TenantDetail.class, SELECT_BY_ID_SQL, id);
    }

    @Override
    public TenantDetail findByUsername(String username) {
        return null; 
    }
}
