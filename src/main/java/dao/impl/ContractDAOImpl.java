/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import java.util.Date;
import java.util.List;
import entity.Contract;
import utils.XJdbc;
import dao.ContractDAO;
import utils.XAuth;
import utils.XQuery;
public class ContractDAOImpl implements ContractDAO{
    
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
    public Contract create(Contract entity) {
        Object[] values = {
            entity.getId(),
            entity.getRoomId(),
            entity.getTenant(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.getDepositAmount(),
            entity.getPayment_cycle_months(),
            entity.getFile_scan_url(),
            entity.getNotes()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Contract entity) {
        Object[] values = {
            entity.getId(),
            entity.getRoomId(),
            entity.getTenant(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.getDepositAmount(),
            entity.getPayment_cycle_months(),
            entity.getFile_scan_url(),
            entity.getNotes()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);    
    }

    @Override
    public List<Contract> findAll() {
        return XQuery.getBeanList(Contract.class, findAllSql);    
    }

    @Override
    public Contract findById(String id) {
        return XQuery.getSingleBean(Contract.class, findByIdSql, id);    
    }

   
}
