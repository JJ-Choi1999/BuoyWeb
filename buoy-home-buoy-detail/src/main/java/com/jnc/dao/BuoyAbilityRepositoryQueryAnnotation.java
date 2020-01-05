package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.BuoyAbility;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface BuoyAbilityRepositoryQueryAnnotation extends Repository<BuoyAbility, Integer> {
	
	@Query(value="select * from tb_buoyability where opt=? and date>=?",nativeQuery=true)
	List<BuoyAbility> queryAbilityOptCount(String opt,String date);
	
}
