package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.MsgSocial;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface MsgSocialRepositoryCrudRepository extends CrudRepository<MsgSocial, Integer> {

}
