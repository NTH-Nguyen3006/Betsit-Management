/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
