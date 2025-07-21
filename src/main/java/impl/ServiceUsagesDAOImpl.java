/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dao.ServiceUsagesDAO;
import entity.ServiceUsages;
import java.sql.Timestamp;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author ADMIN
 */
public class ServiceUsagesDAOImpl implements ServiceUsagesDAO {
    private final String INSERT_SQL = "INSERT INTO ServiceUsages (ServiceId, ContractId, StartDate, EndDate) VALUES (?, ?, ?, ?)";
    private final String UPDATE_SQL = "UPDATE ServiceUsages SET StartDate=?, EndDate=? WHERE ServiceId=? AND ContractId=?";
    private final String DELETE_SQL = "DELETE FROM ServiceUsages WHERE ServiceId=? AND ContractId=?";
    private final String SELECT_ALL_SQL = "SELECT * FROM ServiceUsages";
    private final String SELECT_BY_ID_SQL = "SELECT * FROM ServiceUsages WHERE ServiceId = ? AND ContractId = ? ";

    @Override
    public ServiceUsages create(ServiceUsages entity) {
        Object[] values = {
                entity.getServiceId(),
                entity.getContractId(),
                entity.getStartDate(),
                entity.getEndDate()
        };
        XJdbc.executeUpdate(INSERT_SQL, values);
        return entity;
    }

    @Override
    public void update(ServiceUsages entity) {
        Object[] values = {
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getServiceId(),
                entity.getContractId()
        };
        XJdbc.executeUpdate(UPDATE_SQL, values);
    }

    @Override
    public void deleteById(int serviceId, int contractId) {
        XJdbc.executeUpdate(DELETE_SQL, serviceId, contractId);
    }

    @Override
    public List<ServiceUsages> findAll() {
        return XQuery.getBeanList(ServiceUsages.class, SELECT_ALL_SQL);
    }

    @Override
    public ServiceUsages findById(int serviceId, int contractId) {
        return XQuery.getSingleBean(ServiceUsages.class, SELECT_BY_ID_SQL, serviceId, contractId);
    }
}
