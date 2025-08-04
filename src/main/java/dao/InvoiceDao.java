package dao;

import entity.Invoice;
import java.util.List;

    public interface InvoiceDAO extends CrudDAO<Invoice, String> {
    List<Invoice> getAllInvoices();
}
