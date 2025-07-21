<<<<<<< HEAD
package dao;

public interface ServiceUsagesDAO extends CrudDAO<ServiceUsagesDAO, String> {

=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.ServiceUsages;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ServiceUsagesDAO{
    ServiceUsages create(ServiceUsages su);
    void update(ServiceUsages su);
    void deleteById(int serviceId, int contractId); 
    List<ServiceUsages> findAll();
    ServiceUsages findById(int serviceId, int contractId);
>>>>>>> Trinh
}
