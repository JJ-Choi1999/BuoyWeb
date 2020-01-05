package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.NewsBusiness;

/**
 * JPA持久层增删查改
 * @author JNC 2019/7/9 15:10
 *
 */
public interface NewsBusinessRepositoryCrudRepository 
	extends CrudRepository<NewsBusiness, Integer>{
	
	

}
