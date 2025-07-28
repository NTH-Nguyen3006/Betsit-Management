
package dao;

import entity.InvoiceDetail;
import java.util.List;

public interface InvoiceDetailDao extends CrudDAO<InvoiceDetail, String> {
List<InvoiceDetail> selectByInvoiceId(String invoiceId);

}
