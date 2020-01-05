package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.Focus;

/**
 * JPA持久层增删查改
 * @author JNC 2019/7/9 15:10
 *
 */
public interface FocusRepositoryCrudRepository 
	extends CrudRepository<Focus, Integer>{

}
