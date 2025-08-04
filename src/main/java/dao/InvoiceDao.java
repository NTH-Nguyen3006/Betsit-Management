package dao;

import entity.Invoice;
import java.util.List;

public interface InvoiceDao extends CrudDAO<Invoice, String> {
    List<Invoice> getAllInvoices();
}
