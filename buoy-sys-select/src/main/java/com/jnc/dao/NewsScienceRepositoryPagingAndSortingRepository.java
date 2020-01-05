package com.jnc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jnc.pojo.NewsScience;

public interface NewsScienceRepositoryPagingAndSortingRepository 
	extends PagingAndSortingRepository<NewsScience, Integer>{

}
