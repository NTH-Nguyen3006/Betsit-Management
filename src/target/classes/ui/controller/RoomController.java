package ui.controller;

import entity.Room;


public interface RoomController extends CrudController<Room>{
    void fillRoomType();
    void chooseFile();
}
