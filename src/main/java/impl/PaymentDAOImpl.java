package impl;

import dao.PaymentDAO;
import entity.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

public class PaymentDAOImpl implements PaymentDAO {

    private final String createSql = "INSERT INTO Payments"
            + "(InvoiceId, Tenant, Amount, PaymentDate, PaymentMethod, TransactionCode, Note) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    private final String updateSql = "UPDATE Payments SET "
            + "InvoiceId=?, Tenant=?, Amount=?, PaymentDate=?, PaymentMethod=?, TransactionCode=?, Note=? "
            + "WHERE Id=?";

    private final String deleteByIdSql = "DELETE FROM Payments WHERE Id=?";
    private final String findAllSql = "SELECT * FROM Payments";
    private final String findByIdSql = findAllSql + " WHERE Id=?";

    @Override
    public Payment create(Payment entity) {
        Object[] values = {
            entity.getInvoiceId(),
            entity.getTenant(),
            entity.getAmount(),
            entity.getPaymentDate(),
            entity.getPaymentMethod(),
            entity.getTransactionCode(),
            entity.getNote()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Payment entity) {
        Object[] values = {
            entity.getInvoiceId(),
            entity.getTenant(),
            entity.getAmount(),
            entity.getPaymentDate(),
            entity.getPaymentMethod(),
            entity.getTransactionCode(),
            entity.getNote(),
            entity.getId() // nằm cuối vì WHERE Id=?
        };
        XJdbc.executeUpdate(updateSql, values);
    }

   

    @Override
    public List<Payment> findAll() {
        return XQuery.getBeanList(Payment.class, findAllSql);
    }

  

    @Override
    public void deleteById(String id) {
         XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public Payment findById(String id) {
        return XQuery.getSingleBean(Payment.class, findByIdSql, id);
    }
    @Override
public boolean existsTransactionCode(String transactionCode) {
    String sql = "SELECT COUNT(*) FROM Payments WHERE TransactionCode = ?";
    try (
        Connection con = XJdbc.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setString(1, transactionCode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

@Override
public boolean existsTransactionCodeForOtherId(String paymentId, String transactionCode) {
    String sql = "SELECT COUNT(*) FROM Payments WHERE TransactionCode = ? AND PaymentId <> ?";
    try (
        Connection con = XJdbc.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setString(1, transactionCode);
        ps.setString(2, paymentId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
}
