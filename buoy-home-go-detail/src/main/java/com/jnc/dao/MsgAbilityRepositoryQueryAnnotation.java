package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.MsgAbility;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface MsgAbilityRepositoryQueryAnnotation extends Repository<MsgAbility, Integer> {
	
	@Query(value="select top 1 * from tb_msgability order by newid()",nativeQuery=true)
	MsgAbility queryRandAbility();
	
}
