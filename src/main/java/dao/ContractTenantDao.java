
package dao;

import entity.ContractTenant;

/**
 *
 * @author nhukhue
 */
public interface ContractTenantDao extends CrudDAO<ContractTenant, String> {
    ContractTenant findByCitizenId(String citizenId);
}
