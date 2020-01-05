package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.MsgHorizon;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface MsgHorizonRepositoryCrudRepository extends CrudRepository<MsgHorizon, Integer> {

}
