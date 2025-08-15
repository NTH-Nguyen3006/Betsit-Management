
package impl;

import dao.ContractDetailDAO;
import entity.ContractDetail;

/**
 *
 * @author GAMING
 */
public class ContractDetailDAOImpl implements ContractDetailDAO {

    @Override
    public void create(ContractDetail detail) {
        // Thực hiện lưu detail vào DB
    }

    @Override
    public void update(ContractDetail detail) {
        // Thực hiện update detail
    }

    @Override
    public void delete(ContractDetail detail) {
        // Thực hiện xóa detail khỏi DB
    }

    @Override
    public ContractDetail findById(String id) {
        ContractDetail detail = null;
        // Thực hiện truy vấn DB theo id, gán dữ liệu vào detail
        return detail;
    }
}
