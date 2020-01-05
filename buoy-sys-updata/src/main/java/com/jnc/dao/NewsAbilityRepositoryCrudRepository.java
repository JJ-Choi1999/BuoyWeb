package com.jnc.dao;

import org.springframework.data.repository.CrudRepository;

import com.jnc.pojo.NewsAbility;
/**
 * CrudRepository继承于Repository
 * @author 590
 *
 */
public interface NewsAbilityRepositoryCrudRepository extends CrudRepository<NewsAbility, Integer> {

}
