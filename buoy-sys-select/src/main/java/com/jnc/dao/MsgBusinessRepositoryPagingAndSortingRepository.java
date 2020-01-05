package com.jnc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jnc.pojo.MsgBusiness;

public interface MsgBusinessRepositoryPagingAndSortingRepository 
	extends PagingAndSortingRepository<MsgBusiness, Integer>{

}
