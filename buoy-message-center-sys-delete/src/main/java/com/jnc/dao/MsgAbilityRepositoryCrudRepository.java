package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.MsgAbility;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface MsgAbilityRepositoryCrudRepository extends CrudRepository<MsgAbility, Integer> {

}
