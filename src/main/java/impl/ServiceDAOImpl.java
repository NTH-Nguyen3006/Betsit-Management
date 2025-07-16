/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dao.ServiceDAO;
import entity.Service;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author ADMIN
 */
public class ServiceDAOImpl implements ServiceDAO {
    private final String INSERT_SQL = "INSERT INTO Services (ServiceName, Unit, Price, Description) VALUES (?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE Services SET ServiceName=?, Unit=?, Price=?, Description=? WHERE Id=?";
    private final String DELETE_SQL = "DELETE FROM Services WHERE Id=?";
    private final String SELECT_ALL_SQL = "SELECT * FROM Services";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM Services WHERE Id=?";
    
    @Override
    public Service create(Service entity) {
        XJdbc.executeUpdate(INSERT_SQL,
            entity.getServiceName(),
            entity.getUnit(),
            entity.getPrice(),
            entity.getDescription()
        );
        return entity;
    }

    @Override
    public void update(Service entity) {
        XJdbc.executeUpdate(UPDATE_SQL,
            entity.getServiceName(),
            entity.getUnit(),
            entity.getPrice(),
            entity.getDescription(),
            entity.getId() 
        );
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<Service> findAll() {
        return XQuery.getBeanList(Service.class, SELECT_ALL_SQL);
    }

    @Override
    public Service findById(Integer id) {
        return XQuery.getSingleBean(Service.class, SELECT_BY_ID_SQL, id);
    }

    @Override
    public Service findByUsername(String username) {
        return null;
    }
}
