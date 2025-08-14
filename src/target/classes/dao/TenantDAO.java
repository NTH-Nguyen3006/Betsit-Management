package dao;

import entity.Tenant;

public interface TenantDAO extends CrudDAO<Tenant, String> {
Tenant findById(String citizenId);
}
