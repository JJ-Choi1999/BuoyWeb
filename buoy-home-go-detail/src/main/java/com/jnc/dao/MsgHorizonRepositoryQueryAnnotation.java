package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.MsgHorizon;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface MsgHorizonRepositoryQueryAnnotation extends Repository<MsgHorizon, Integer> {
	
	@Query(value="select top 1 * from tb_msghorizon order by newid()",nativeQuery=true)
	MsgHorizon queryRandHorizon();
	
}
