package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.Users;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface UsersRepositoryQueryAnnotation extends Repository<Users, Integer> {
	
	/**自动绑定参数项(标准SQL语句执行)
	 * @Query(value="select * from t_users where name=?",nativeQuery=true)
	 * value：SQL语句
	 * nativeQuery：是否为标准SQL语句执行
	 * @param name
	 * @return
	 */
	@Query(value="select * from tb_users where usersname=?",nativeQuery=true)
	List<Users> queryByNameUseSQL(String usersName);
	
	@Query(value="select top 1 * from tb_newsbusiness order by newid()",nativeQuery=true)
	Users queryRandUsers();
	
}
