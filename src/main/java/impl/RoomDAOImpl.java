/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dao.RoomDAO;
import entity.Room;
import java.util.ArrayList;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author nhukhue
 */
public class RoomDAOImpl implements RoomDAO {

    private final String createSql = "INSERT INTO Rooms"
            + "(Area, RentPrice, Status, Roomtype, Notes) "
            + "VALUES(?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Rooms SET "
            + "Area=?, RentPrice=?, Status=?, Roomtype=?, Notes=?"
            + "WHERE Roomid=?";
    private final String deleteByIdSql = "DELETE FROM Rooms WHERE Roomid=?";

    private final String findAllSql = "SELECT * FROM Rooms";
    private final String findByIdSql = findAllSql + " WHERE Roomid=?";
    private final String findAllRoomTypesSql = "SELECT DISTINCT RoomType FROM Rooms WHERE RoomType IS NOT NULL AND RoomType <> '' ORDER BY RoomType"; // (dựa trên cột RoomType)
    
    @Override
    public Room create(Room entity) {
        Object[] values = {
                
                entity.getArea(),
                entity.getRentPrice(),
                entity.getStatus(),
                entity.getRoomType(),
                entity.getNotes()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Room entity) {
        Object[] values = {
                entity.getRoomId(),
                entity.getArea(),
                entity.getRentPrice(),
                entity.getStatus(),
                entity.getRoomType(),
                entity.getNotes(),
                entity.getRoomId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<Room> findAll() {
        return XQuery.getBeanList(Room.class, findAllSql);
    }

    @Override
    public Room findById(String id) {
        return XQuery.getSingleBean(Room.class, findByIdSql, id);
    }

    @Override
    public List<String> findAllRoomType() {
        return XQuery.getBeanList(String.class, findAllRoomTypesSql); // Sử dụng phương thức getList mới của XQuery
      
    }

    
}
