package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.MsgScience;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface MsgScienceRepositoryQueryAnnotation extends Repository<MsgScience, Integer> {
	
	@Query(value="select top 1 * from tb_msgscience order by newid()",nativeQuery=true)
	MsgScience queryRandScience();
	
}
