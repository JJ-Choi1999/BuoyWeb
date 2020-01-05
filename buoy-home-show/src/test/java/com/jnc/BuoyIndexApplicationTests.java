package com.jnc;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jnc.dao.ViewPagerRepositoryPagingAndSortingRepository;
import com.jnc.pojo.ViewPager;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={BuoyIndexApplication.class})
public class BuoyIndexApplicationTests {
	
	@Autowired
	private ViewPagerRepositoryPagingAndSortingRepository viewPagerRepositoryPagingAndSortingRepository;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testPagingAndSortingRepositorySort() {
		/**
		 * Order:封装排序规则。
		 * new Order(direction, property);
		 * direction ：排序规则
		 * property ： 排序字段
		 */
	
		Order order=new Order(Direction.DESC, "id");
		List<ViewPager> list=
				(List<ViewPager>) this.viewPagerRepositoryPagingAndSortingRepository.findAll(new Sort(order));
		System.out.println("总条数="+list.size());
		if(list.size()<=5) {
			for(ViewPager viewPager:list) {
				System.out.println(viewPager);
			}
		}else if(list.size()>5) {
			for(int i=0;i<5;i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
}
