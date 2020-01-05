package com.jnc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jnc.pojo.NewsHorizon;

public interface NewsHorizonRepositoryPagingAndSortingRepository 
	extends PagingAndSortingRepository<NewsHorizon, Integer>{

}
