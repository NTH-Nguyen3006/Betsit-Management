/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dao.AssetsDAO;
import entity.Assets;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

public class AssetsDAOImpl implements AssetsDAO{
    
private final String insertSql = "INSERT INTO Assets "
        + "(RoomId, AssetName, Quantity, Condition) "
        + "VALUES (?, ?, ?, ?)";
private final String updateSql = "UPDATE Assets SET "
        + "RoomId = ?, AssetName = ?, Quantity = ?, Condition = ? "
        + "WHERE Id = ?";
private final String deleteByIdSql = "DELETE FROM Assets "
        + "WHERE Id = ?";
private final String findAllSql = "SELECT * FROM Assets";
private final String findByIdSql = findAllSql + " WHERE Id = ?";
private final String findByRoomIDSql = findAllSql + " WHERE RoomId = ?";
private final String findAllConditionsSql = "SELECT DISTINCT Condition FROM Assets WHERE Condition IS NOT NULL AND Condition <> '' ORDER BY Condition";
    @Override
    public Assets create(Assets entity) {
 Object[] values = {
            entity.getRoomId(),
            entity.getAssetName(),
            entity.getQuantity(),
            entity.getCondition(),
            entity.getId()
        };
        XJdbc.executeUpdate(insertSql, values);
        return entity;    
    }

    @Override
    public void update(Assets entity) {
        Object[] values = {
            entity.getRoomId(),
            entity.getAssetName(),
            entity.getQuantity(),
            entity.getCondition(),
            entity.getId()
            
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql,  id);
    }

    @Override
    public List<Assets> findAll() {
        return XQuery.getBeanList(Assets.class, findAllSql);
    }

    @Override
    public Assets findById(String id) {
        return XQuery.getSingleBean(Assets.class, findByIdSql, id);    
    }
    

    @Override
    public List<String> findAllCondition() {
        return XQuery.getBeanList(String.class, findAllConditionsSql);    
    }

    @Override
    public List<Assets> findByRoomId(String RoomId) {
        return XQuery.getBeanList(Assets.class, findByRoomIDSql, RoomId); // Sử dụng getBeanList để lấy danh sách
    }
    
}
