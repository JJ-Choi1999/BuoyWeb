package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.BuoyAbility;
import com.jnc.pojo.BuoyBusiness;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface BuoyBusinessRepositoryQueryAnnotation extends Repository<BuoyBusiness, Integer> {
	
	@Query(value="select * from tb_buoybusiness where opt=? and date>=?",nativeQuery=true)
	List<BuoyBusiness> queryBusinessOptCount(String opt,String date);
	
}
