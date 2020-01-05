package com.jnc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jnc.pojo.ViewPager;
/**
 * PagingAndSortingRepository:执行分页和排序操作，继承CurdRepository接口
 * @author 590
 *
 */
public interface ViewPagerRepositoryPagingAndSortingRepository 
	extends PagingAndSortingRepository<ViewPager, Integer> {
	
}
