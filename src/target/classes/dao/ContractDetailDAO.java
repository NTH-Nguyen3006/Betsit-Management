/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.ContractDetail;

/**
 *
 * @author GAMING
 */
public interface ContractDetailDAO {
    void create(ContractDetail detail);
    void update(ContractDetail detail);
    void delete(ContractDetail detail);
    ContractDetail findById(String id);
}

