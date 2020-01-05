package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.NewsAbility;
import com.jnc.pojo.NewsSocial;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface NewsSocialRepositoryQueryAnnotation extends Repository<NewsSocial, Integer> {
	
	/**自动绑定参数项(标准SQL语句执行)
	 * @Query(value="select * from t_users where name=?",nativeQuery=true)
	 * value：SQL语句
	 * nativeQuery：是否为标准SQL语句执行
	 * @param name
	 * @return
	 */
	@Query(value="select top 5 * from tb_newssocial order by id desc",nativeQuery=true)
	List<NewsSocial> queryByNewsSocialUseSQL();
	
	@Query(value="select * from tb_newssocial where title=?",nativeQuery=true)
	NewsSocial queryBySocialTitleUseSQL(String title);
	
}
