package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.Administrators;

/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface AdminRepositoryCrudRepository extends CrudRepository<Administrators, Integer> {

}
