package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.NewsHorizon;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface NewsHorizonRepositoryCrudRepository extends CrudRepository<NewsHorizon, Integer> {

}
