/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.RoomDAO;
import entity.Room;
import java.util.List;
import utils.XJdbc;
import utils.XQuery;

/**
 *
 * @author nhukhue
 */
public class RoomDAOImpl implements RoomDAO{

    private final String createSql = "INSERT INTO Rooms"
                                   + "(Roomid, Area, RentPrice, Status, Roomtypes, Notes) "
                                   + "VALUES(?, ?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE Rooms SET "
                                   + "Roomid=?, Area=?, RentPrice=?, Status=?, Roomtypes=?, Notes=?"
                                   + "WHERE Roomid=?";
    private final String deleteByIdSql = "DELETE FROM Rooms WHERE Roomid=?";

    private final String findAllSql = "SELECT * FROM Rooms";
    private final String findByIdSql = findAllSql + " WHERE Roomid=?";
    
    @Override
    public Room create(Room entity) {
        Object[] values = {
            entity.getRoomId(),
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
            entity.getNotes()
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
    
}
