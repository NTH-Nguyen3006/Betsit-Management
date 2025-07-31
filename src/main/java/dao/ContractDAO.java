
package dao;

import entity.Contract;

public interface ContractDAO extends CrudDAO<Contract, String> {
boolean existsById(int id);
}
