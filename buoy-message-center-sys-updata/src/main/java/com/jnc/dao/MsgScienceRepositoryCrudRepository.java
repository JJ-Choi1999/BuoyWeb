package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.MsgScience;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface MsgScienceRepositoryCrudRepository extends CrudRepository<MsgScience, Integer> {

}
