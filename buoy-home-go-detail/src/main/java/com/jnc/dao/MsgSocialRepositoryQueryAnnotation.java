package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.MsgSocial;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface MsgSocialRepositoryQueryAnnotation extends Repository<MsgSocial, Integer> {
	
	@Query(value="select top 1 * from tb_msgsocial order by newid()",nativeQuery=true)
	MsgSocial queryRandSocial();
	
}
