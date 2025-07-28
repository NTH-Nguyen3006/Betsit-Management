package impl;

import dao.PaymentDAO;
import entity.Payment;
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
}
