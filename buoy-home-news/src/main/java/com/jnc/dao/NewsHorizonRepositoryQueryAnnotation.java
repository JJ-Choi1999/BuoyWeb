package com.jnc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jnc.pojo.NewsHorizon;
import com.jnc.pojo.ViewPager;
/**
 * Repository中@Query的使用
 * @author 590
 *
 */
public interface NewsHorizonRepositoryQueryAnnotation extends Repository<NewsHorizon, Integer> {
	
	/**自动绑定参数项(标准SQL语句执行)
	 * @Query(value="select * from t_users where name=?",nativeQuery=true)
	 * value：SQL语句
	 * nativeQuery：是否为标准SQL语句执行
	 * @param name
	 * @return
	 */
	@Query(value="select top 5 * from tb_newshorizon order by id desc",nativeQuery=true)
	List<NewsHorizon> queryByNewsHorizonUseSQL();
	
	@Query(value="select * from tb_newshorizon where title=?",nativeQuery=true)
	NewsHorizon queryByHorizonTitleUseSQL(String title);
	
}
