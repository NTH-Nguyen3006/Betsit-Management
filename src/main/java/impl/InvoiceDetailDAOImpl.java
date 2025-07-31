    package impl;

    import entity.InvoiceDetail;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;
    import utils.XJdbc;
    import utils.XQuery;
    import dao.InvoiceDetailDao;

    public class InvoiceDetailDAOImpl implements InvoiceDetailDao {

        private final String createSql = "INSERT INTO Invoice_Details"
                + "(InvoiceId, ServiceId, Quantity, UnitPrice, Subtotal) "
                + "VALUES(?, ?, ?, ?, ?)";

        private final String updateSql = "UPDATE Invoice_Details SET "
                + "ServiceId=?, Quantity=?, UnitPrice=?, Subtotal=? "
                + "WHERE InvoiceId=?";

        private final String deleteByIdSql = "DELETE FROM Invoice_Details WHERE InvoiceId=?";
        private final String findAllSql = "SELECT * FROM Invoice_Details";
        private final String findByIdSql = findAllSql + " WHERE InvoiceId=?";

        public List<InvoiceDetail> selectByInvoiceId(int invoiceId) {
        List<InvoiceDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM Invoice_Details WHERE InvoiceId = ?";
        try (
            Connection conn = XJdbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, invoiceId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                InvoiceDetail detail = new InvoiceDetail();
                detail.setId(rs.getInt("Id"));
                detail.setInvoiceId(rs.getInt("InvoiceId"));
                detail.setServiceId(rs.getInt("ServiceId"));
                detail.setQuantity(rs.getInt("Quantity"));
                detail.setUnitPrice(rs.getBigDecimal("UnitPrice"));
                detail.setSubtotal(rs.getBigDecimal("Subtotal"));
                list.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
        public List<InvoiceDetail> selectAll() {
        List<InvoiceDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM Invoice_Details";
        try (
            Connection conn = XJdbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                InvoiceDetail d = new InvoiceDetail();
                d.setId(rs.getInt("Id"));
                d.setInvoiceId(rs.getInt("InvoiceId"));
                d.setServiceId(rs.getInt("ServiceId"));
                d.setQuantity(rs.getInt("Quantity"));
                d.setUnitPrice(rs.getBigDecimal("UnitPrice"));
                d.setSubtotal(rs.getBigDecimal("Subtotal"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
        @Override
        public InvoiceDetail create(InvoiceDetail entity) {
            Object[] values = {
                    entity.getInvoiceId(),
                    entity.getServiceId(),
                    entity.getQuantity(),
                    entity.getUnitPrice(),
                    entity.getSubtotal()
            };
            XJdbc.executeUpdate(createSql, values);
            return entity;
        }

        @Override
        public void update(InvoiceDetail entity) {
            Object[] values = {
                    entity.getServiceId(),
                    entity.getQuantity(),
                    entity.getUnitPrice(),
                    entity.getSubtotal(),
                    entity.getInvoiceId() 
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

        @Override
        public List<InvoiceDetail> selectByInvoiceId(String invoiceId) {
            String sql = "SELECT * FROM Invoice_Details WHERE InvoiceId = ?";
            return XQuery.getBeanList(InvoiceDetail.class, sql, invoiceId);
        }
    }