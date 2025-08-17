package dao;

import entity.Room;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room, String> {
    List<Room> findAllRoomIds();
}
