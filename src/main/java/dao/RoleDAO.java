package dao;

import entity.Role;

public interface RoleDAO extends CrudDAO<Role, Integer> {
    Role findByName(String roleName);
}
