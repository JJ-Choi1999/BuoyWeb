package com.jnc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jnc.pojo.NewsSocial;

public interface NewsSocialRepositoryPagingAndSortingRepository 
	extends PagingAndSortingRepository<NewsSocial, Integer>{

}
