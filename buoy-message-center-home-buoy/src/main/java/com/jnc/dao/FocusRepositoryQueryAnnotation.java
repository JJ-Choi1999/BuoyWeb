package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.Focus;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface FocusRepositoryQueryAnnotation extends Repository<Focus, Integer> {
	
	/**自动绑定参数项(标准SQL语句执行)
	 * @Query(value="select * from t_users where name=?",nativeQuery=true)
	 * value：SQL语句
	 * nativeQuery：是否为标准SQL语句执行
	 * @param name
	 * @return
	 */
	@Query(value="select * from tb_focus where users_name=?",nativeQuery=true)
	List<Focus> queryByNameUseSQL(String usersName);
	
	
}
