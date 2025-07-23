package ui.manager;

import entity.Room;


public interface RoomController extends CrudController<Room>{
    void fillCategories();
    void chooseFile();
}
