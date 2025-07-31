package ui.controller;

import entity.Room;
import ui.controller.CrudController;


public interface RoomController extends CrudController<Room>{
    void fillCategories();
    void chooseFile();
}
