package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.BuoyHorizon;
import com.jnc.pojo.BuoyScience;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface BuoyScienceRepositoryQueryAnnotation extends Repository<BuoyScience, Integer> {
	
	@Query(value="select * from tb_buoyscience where opt=? and date>=?",nativeQuery=true)
	List<BuoyScience> queryScienceOptCount(String opt,String date);
	
}
