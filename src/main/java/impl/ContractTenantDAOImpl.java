package impl;

import java.util.Date;
import java.util.List;
import entity.ContractTenant;
import utils.XJdbc;
import utils.XAuth;
import utils.XQuery;
import dao.ContractTenantDAO;

public class ContractTenantDAOImpl implements ContractTenantDAO {

    private final String createSql = "INSERT INTO Contract_Tenants"
            + "(Contract_Id, Personal_id, Role) "
            + "VALUES(?, ?, ?)";
    private final String updateSql = "UPDATE Contract_Tenantss SET "
            + "Personal_id=?, Role=? "
            + "WHERE Contract_Id=?";
    private final String deleteByIdSql = "DELETE FROM Contract_Tenants WHERE Contract_Id=?";

    private final String findAllSql = "SELECT * FROM Contract_Tenants";
    private final String findByIdSql = findAllSql + " WHERE Contract_Id=?";

    @Override
    public ContractTenant create(ContractTenant entity) {
        Object[] values = {
                entity.getContract_id(),
                entity.getPersonal_id(),
                entity.getRole(),

        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(ContractTenant entity) {
        Object[] values = {
                entity.getContract_id(),
                entity.getPersonal_id(),
                entity.getRole()
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
