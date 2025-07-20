package impl;

import java.util.List;
import entity.ContractTenant;
import utils.XJdbc;
import utils.XQuery;
import dao.ContractTenantDAO;

public class ContractTenantDAOImpl implements ContractTenantDAO {

    private final String createSql = """
        INSERT INTO Contract_Tenants
            (ContractId, CitizenId, Role) 
        VALUES (?, ?, ?)
    """;

    private final String updateSql = """
        UPDATE Contract_Tenants SET 
            CitizenId = ?, Role = ?
        WHERE ContractId = ?
    """;

    private final String deleteByIdSql = """
        DELETE FROM Contract_Tenants 
        WHERE ContractId = ?
    """;

    private final String findAllSql = """
        SELECT * FROM Contract_Tenants
    """;

    private final String findByIdSql = findAllSql + " WHERE ContractId = ?";

    @Override
    public ContractTenant create(ContractTenant entity) {
        Object[] values = {
            entity.getContractId(),
            entity.getCitizenId(),
            entity.getRole()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(ContractTenant entity) {
        Object[] values = {
            entity.getCitizenId(),
            entity.getRole(),
            entity.getContractId()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<ContractTenant> findAll() {
        return XQuery.getBeanList(ContractTenant.class, findAllSql);
    }

    @Override
    public ContractTenant findById(String id) {
        return XQuery.getSingleBean(ContractTenant.class, findByIdSql, id);
    }
}
