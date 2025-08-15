/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Assets;
import java.util.List;

public interface AssetsDAO extends CrudDAO<Assets, String> {
     List<String> findAllCondition();

     List<Assets> findByRoomId(String RoomId);
}
