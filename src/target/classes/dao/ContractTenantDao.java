
package dao;

import entity.ContractTenant;

public interface ContractTenantDao extends CrudDAO<ContractTenant, String> {
    ContractTenant findByCitizenId(String citizenId);
}
