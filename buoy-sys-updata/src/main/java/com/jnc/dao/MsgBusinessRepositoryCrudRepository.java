package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.MsgBusiness;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface MsgBusinessRepositoryCrudRepository extends CrudRepository<MsgBusiness, Integer> {

}
