
package dao;

import entity.ContractTenant;

/**
 *
 * @author nhukhue
 */
public interface ContractTenantDAO extends CrudDAO<ContractTenant, String> {
ContractTenant findByCitizenId(String citizenId);
}
    