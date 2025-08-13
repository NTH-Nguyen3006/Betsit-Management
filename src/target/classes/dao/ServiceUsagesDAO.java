
package dao;

import entity.ServiceUsages;
import java.util.Date;
import java.util.List;

public interface ServiceUsagesDAO {
    ServiceUsages create(ServiceUsages su);
    void update(ServiceUsages su);
    void deleteById(int serviceId, int contractId);
    List<ServiceUsages> findAll();
    ServiceUsages findById(int serviceId, int contractId);
    List<ServiceUsages> findByTimeRange(Date begin, Date end);
}
