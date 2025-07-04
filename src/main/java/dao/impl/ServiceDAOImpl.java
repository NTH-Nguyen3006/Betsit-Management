/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.ServiceDAO;
import entity.Service;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author nhukhue
 */
public class ServiceDAOImpl implements ServiceDAO{

    private final String createSql = "INSERT INTO Services"
                                   + "(Id, ServiceName, Unit, Price, Description) "
                                   + "VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Services SET "
                                   + "ServiceName=?, Unit=?, Price=?, Description=?"
                                   + "WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM Services WHERE Id=?";

    private final String findAllSql = "SELECT * FROM Services";
    private final String findByIdSql = findAllSql + " WHERE Id=?";
    
    @Override
    public Service create(Service entity) {
        Object[] values = {
            entity.getId(),
            entity.getServiceName(),
            entity.getUnit(),
            entity.getPrice(),
            entity.getDescription()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;        
    }

    @Override
    public void update(Service entity) {
        Object[] values = {
            entity.getId(),
            entity.getServiceName(),
            entity.getUnit(),
            entity.getPrice(),
            entity.getDescription()
        };
        XJdbc.executeUpdate(updateSql, values);    
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);     
    }

    @Override
    public List<Service> findAll() {
        return XQuery.getBeanList(Service.class, findAllSql);       
    }

    @Override
    public Service findById(String id) {
        return XQuery.getSingleBean(Service.class, findByIdSql, id);
    }
    
}
