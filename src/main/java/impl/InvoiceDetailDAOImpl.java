package impl;

import dao.InvoiceDetailDao;
import entity.InvoiceDetail;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

public class InvoiceDetailDAOImpl implements InvoiceDetailDao {

    private final String createSql = "INSERT INTO Invoice_Detail"
            + "(Invoice_id, Service_id, Quantity, Unit_price, Subtotal) "
            + "VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Invoice_Detail SET "
            + "Service_id=?, Quantity=?, Unit_price=?, Subtotal=?"
            + "WHERE Invoice_id=?";
    private final String deleteByIdSql = "DELETE FROM Invoice_Detail WHERE Invoice_id=?";

    private final String findAllSql = "SELECT * FROM Invoice_Detail";
    private final String findByIdSql = findAllSql + " WHERE Invoice_id=?";

    @Override
    public InvoiceDetail create(InvoiceDetail entity) {
        Object[] values = {
                entity.getInvoice_id(),
                entity.getService_id(),
                entity.getQuantity(),
                entity.getUnit_price(),
                entity.getSubtotal()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(InvoiceDetail entity) {
        Object[] values = {
                entity.getInvoice_id(),
                entity.getService_id(),
                entity.getQuantity(),
                entity.getUnit_price(),
                entity.getSubtotal()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<InvoiceDetail> findAll() {
        return XQuery.getBeanList(InvoiceDetail.class, findAllSql);
    }

    @Override
    public InvoiceDetail findById(String id) {
        return XQuery.getSingleBean(InvoiceDetail.class, findByIdSql, id);
    }

}
