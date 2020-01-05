package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.Focus;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface FocusRepositoryCrudRepository extends CrudRepository<Focus, Integer> {

}
