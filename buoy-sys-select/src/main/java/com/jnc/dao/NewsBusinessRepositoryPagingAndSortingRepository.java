package com.jnc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jnc.pojo.NewsBusiness;

public interface NewsBusinessRepositoryPagingAndSortingRepository 
	extends PagingAndSortingRepository<NewsBusiness, Integer>{

}
