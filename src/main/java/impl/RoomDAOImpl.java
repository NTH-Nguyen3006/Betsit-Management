
package impl;

import java.util.List;

import dao.RoomDAO;
import entity.Room;
import utils.XJdbc;
import utils.XQuery;

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
    private final String findAllRoomTypesSql = "SELECT DISTINCT RoomType FROM Rooms WHERE RoomType IS NOT NULL AND RoomType <> '' ORDER BY RoomType"; // (dựa
                                                                                                                                                      // trên
                                                                                                                                                      // cột
                                                                                                                                                      // RoomType)
    private final String findAllRoomIdSql = "SELECT * FROM Rooms";

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

                entity.getArea(),
                entity.getRentPrice(),
                entity.getStatus(),
                entity.getRoomType(),
                entity.getNotes(),
                entity.getRoomId(),
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
        return XQuery.getList(String.class, findAllRoomTypesSql); // Sử dụng phương thức getList mới của XQuery
    }

    public List<Room> findAllRoomIds() {
        return XQuery.getBeanList(Room.class, findAllRoomIdSql);
    }
}
