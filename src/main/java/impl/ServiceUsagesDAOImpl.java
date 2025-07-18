package impl;

import java.util.List;
import dao.ServiceUsagesDAO;

//ai đó đọc được thì làm cái lol này giùm khánh nha
public class ServiceUsagesDAOImpl implements ServiceUsagesDAO {

    private final String createSql = "INSERT INTO ServiceUsages"
            + "(ServiceId, ContractId, StartDate, EndDate) "
            + "VALUES(?, ?, ?, ?)";
    private final String updateSql = "UPDATE ServiceUsages SET "
            + "ContractId=?, StartDate=?, EndDate=? "
            + "WHERE ServiceId=?";
    private final String deleteByIdSql = "DELETE FROM ServiceUsages WHERE ServiceId=?";

    private final String findAllSql = "SELECT * FROM ServiceUsages";
    private final String findByIdSql = findAllSql + " WHERE ServiceId=?";

    @Override
    public ServiceUsagesDAO create(ServiceUsagesDAO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ServiceUsagesDAO entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ServiceUsagesDAO> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ServiceUsagesDAO findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
