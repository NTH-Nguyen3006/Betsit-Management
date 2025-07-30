package ui.controller;

import entity.Room;

public interface RoomController extends CrudController<Room>{
    void fillCategories();
    void chooseFile();
}
