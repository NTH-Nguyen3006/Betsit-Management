package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import entity.Contract;
import utils.XJdbc;
import dao.ContractDAO;
import java.sql.ResultSet;
import utils.XQuery;

public class ContractDAOImpl implements ContractDAO {

    private final String createSql = "INSERT INTO Contracts "
            + "( RoomId, Tenant, StartDate, EndDate, depositAmount,PaymentCycleMonths, File_scan_url, Notes) "
            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String updateSql = "UPDATE Contracts SET "
            + "RoomId = ?, Tenant = ?, StartDate = ?, EndDate = ?, depositAmount = ?, "
            + "PaymentCycleMonths = ?, File_scan_url = ?, Notes = ? "
            + "WHERE Id = ?";

    private final String deleteByIdSql = "DELETE FROM Contracts WHERE Id = ?";
    private final String findAllSql = "SELECT * FROM Contracts";
    private final String findByIdSql = findAllSql + " WHERE Id = ?";

    private final String insertContractTenantSql =
            "INSERT INTO Contract_Tenants (Contract_id, Citizen_id, Role) VALUES (?, ?, ?)";

    @Override
    public Contract create(Contract entity) {
        Object[] values = {
                
                entity.getRoomId(),
                entity.getTenant(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getDepositAmount(),
                entity.getPaymentCycleMonths(),
                entity.getFile_scan_url(),
                entity.getNotes()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Contract entity) {
        Object[] values = {
                entity.getRoomId(),
                entity.getTenant(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getDepositAmount(),
                entity.getPaymentCycleMonths(),
                entity.getFile_scan_url(),
                entity.getNotes(),
                entity.getId()
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

    // Thêm người thuê phụ vào hợp đồng
    public boolean addTenantToContract(int contractId, String citizenId, int role) {
        try (Connection conn = XJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertContractTenantSql)) {

            stmt.setInt(1, contractId);
            stmt.setString(2, citizenId);
            stmt.setInt(3, role);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
public boolean existsById(int id) {
    String sql = "SELECT 1 FROM Contracts WHERE Id = ?";
    try (
        Connection conn = XJdbc.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)
    ) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // nếu có dòng nào → true
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
}
