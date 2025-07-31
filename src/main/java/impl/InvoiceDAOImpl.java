package impl;

import entity.Invoice;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;
import dao.InvoiceDAO;

public class InvoiceDAOImpl implements InvoiceDAO {

    private final String createSql = "INSERT INTO Invoice "
    + "(ContractId, billing_period_month, billing_period_year, previous_debt, discount, totalamount, status, due_date, created_at) "
    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Invoice SET "
            + "Contract_id = ?, billing_period_month = ?, billing_period_year = ?, previous_debt = ?, "
            + "discount = ?, total_amount = ?, status = ?, due_date = ?, created_at = ? "
            + "WHERE Id = ?";

    private final String deleteByIdSql = "DELETE FROM Invoice WHERE Id = ?";
    private final String findAllSql = "SELECT * FROM Invoice";
    private final String findByIdSql = "SELECT * FROM Invoice WHERE Id = ?";

    @Override
    public Invoice create(Invoice entity) {
        Object[] values = {
            entity.getContractid(),
            entity.getBilling_period_month(),
            entity.getBilling_period_year(),
            entity.getPrevious_debt(),
            entity.getDiscount(),
            entity.getTotalamount(),
            entity.getStatus(),
            entity.getDue_date(),
            entity.getCreated_at()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Invoice entity) {
        Object[] values = {
            entity.getContractid(),
            entity.getBilling_period_month(),
            entity.getBilling_period_year(),
            entity.getPrevious_debt(),
            entity.getDiscount(),
            entity.getTotalamount(),
            entity.getStatus(),
            entity.getDue_date(),
            entity.getCreated_at(),
            entity.getId()  // WHERE Id = ?
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Invoice> findAll() {
        return XQuery.getBeanList(Invoice.class, findAllSql);
    }

    @Override
    public Invoice findById(String id) {
        return XQuery.getSingleBean(Invoice.class, findByIdSql, id);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return findAll();
    }
}
