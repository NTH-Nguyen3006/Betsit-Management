package dao;

import entity.Tenant;
import java.util.List;

public interface TenantDAO extends CrudDAO<Tenant, String> {
    Tenant findById(String citizenId);
    Tenant findByVehiclePlate(String vehiclePlate);
}
