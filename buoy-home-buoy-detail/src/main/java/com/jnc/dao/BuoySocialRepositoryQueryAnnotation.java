package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.BuoyScience;
import com.jnc.pojo.BuoySocial;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface BuoySocialRepositoryQueryAnnotation extends Repository<BuoySocial, Integer> {
	
	@Query(value="select * from tb_buoysocial where opt=? and date>=?",nativeQuery=true)
	List<BuoySocial> querySocialOptCount(String opt,String date);
	
}
