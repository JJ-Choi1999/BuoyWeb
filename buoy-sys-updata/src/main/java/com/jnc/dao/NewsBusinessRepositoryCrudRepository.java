package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.NewsBusiness;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface NewsBusinessRepositoryCrudRepository extends CrudRepository<NewsBusiness, Integer> {

}
