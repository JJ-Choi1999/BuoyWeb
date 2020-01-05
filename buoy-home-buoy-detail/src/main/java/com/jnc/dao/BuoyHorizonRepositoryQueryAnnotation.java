package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.BuoyAbility;
import com.jnc.pojo.BuoyHorizon;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface BuoyHorizonRepositoryQueryAnnotation extends Repository<BuoyHorizon, Integer> {
	
	@Query(value="select * from tb_buoyhorizon where opt=? and date>=?",nativeQuery=true)
	List<BuoyHorizon> queryHorizonOptCount(String opt,String date);
	
}
