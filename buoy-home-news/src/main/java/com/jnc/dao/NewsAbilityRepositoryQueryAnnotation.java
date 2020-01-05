package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.NewsAbility;
import com.jnc.pojo.NewsHorizon;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface NewsAbilityRepositoryQueryAnnotation extends Repository<NewsAbility, Integer> {
	
	/**自动绑定参数项(标准SQL语句执行)
	 * @Query(value="select * from t_users where name=?",nativeQuery=true)
	 * value：SQL语句
	 * nativeQuery：是否为标准SQL语句执行
	 * @param name
	 * @return
	 */
	@Query(value="select top 5 * from tb_newsability order by id desc",nativeQuery=true)
	List<NewsAbility> queryByNewsAbilityUseSQL();
	
	@Query(value="select * from tb_newsability where title=?",nativeQuery=true)
	NewsAbility queryByAbilityTitleUseSQL(String title);
}
