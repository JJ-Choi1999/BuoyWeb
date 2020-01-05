package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.MsgBusiness;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface MsgBusinessRepositoryQueryAnnotation extends Repository<MsgBusiness, Integer> {
	
	@Query(value="select top 1 * from tb_msgbusiness order by newid()",nativeQuery=true)
	MsgBusiness queryRandBusiness();
	
}
