<<<<<<< HEAD
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
>>>>>>> Trinh
package impl;

import dao.ServiceDAO;
import entity.Service;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

<<<<<<< HEAD
public class ServiceDAOImpl implements ServiceDAO {

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
=======
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
>>>>>>> Trinh
        return entity;
    }

    @Override
    public void update(Service entity) {
<<<<<<< HEAD
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
=======
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
>>>>>>> Trinh
    }

    @Override
    public List<Service> findAll() {
<<<<<<< HEAD
        return XQuery.getBeanList(Service.class, findAllSql);
    }

    @Override
    public Service findById(String id) {
        return XQuery.getSingleBean(Service.class, findByIdSql, id);
    }

=======
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
>>>>>>> Trinh
}
