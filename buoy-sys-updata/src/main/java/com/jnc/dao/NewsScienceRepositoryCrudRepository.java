package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.NewsScience;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface NewsScienceRepositoryCrudRepository extends CrudRepository<NewsScience, Integer> {

}
