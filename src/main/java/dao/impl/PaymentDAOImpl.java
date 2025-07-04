/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.PaymentDAO;
import entity.Payment;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

public class PaymentDAOImpl implements PaymentDAO{

    private final String createSql = "INSERT INTO Payments"
                                   + "(Id, Invoice_id, Tenant, Amount, Payment_date, Payment_method, Transaction_code, Note) "
                                   + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Payments SET "
                                   + "Invoice_id=?, Tenant=?, Amount=?, Payment_date=?, Payment_method=?, Transaction_code=?, Note=?"
                                   + "WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM Payments WHERE Id=?";

    private final String findAllSql = "SELECT * FROM Payments";
    private final String findByIdSql = findAllSql + " WHERE Id=?";
    
    @Override
    public Payment create(Payment entity) {
        Object[] values = {
            entity.getId(),
            entity.getInvoice_id(),
            entity.getTenant(),
            entity.getAmount(),
            entity.getPayment_date(),
            entity.getPayment_method(),
            entity.getTransaction_code(),
            entity.getNote()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Payment entity) {
        Object[] values = {
            entity.getId(),
            entity.getInvoice_id(),
            entity.getTenant(),
            entity.getAmount(),
            entity.getPayment_date(),
            entity.getPayment_method(),
            entity.getTransaction_code(),
            entity.getNote()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);     
    }

    @Override
    public List<Payment> findAll() {
        return XQuery.getBeanList(Payment.class, findAllSql);   
    }

    @Override
    public Payment findById(String id) {
        return XQuery.getSingleBean(Payment.class, findByIdSql, id);
    }
    
}
