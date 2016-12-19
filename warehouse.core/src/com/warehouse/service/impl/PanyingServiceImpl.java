package com.warehouse.service.impl;

import gaf2.core.util.DataBeanHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.warehouse.persistence.dao.PanyingDAO;
import com.warehouse.persistence.entity.Panying;
import com.warehouse.service.PanyingService;

public class PanyingServiceImpl implements PanyingService{

	@Autowired
	PanyingDAO dao;
	
	@Override
	public Panying add(Panying t) {
		
		return dao.saveAndFlush(t);
	}

	@Override
	public Panying update(Panying t) {
		
		Panying ap = null;
		if(t!=null){
			ap = dao.findOne(t.getId());
			DataBeanHelper.Bean2Bean(t, ap);
		}
		return dao.saveAndFlush(ap);
	}

	@Override
	public void deleteOne(Long id) {
		
		dao.delete(id);
	}

	@Override
	public Panying queryOne(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public List<Panying> queryForList(Panying t) {
		
		return dao.findByExample(t, new Sort(Direction.DESC, "id"));
	}

	@Override
	public Page<Panying> queryForPage(Panying t, int page, int rows) {
		
		return dao.findByExample(t, new PageRequest(page, rows, Direction.DESC, "id"));
	}

}
