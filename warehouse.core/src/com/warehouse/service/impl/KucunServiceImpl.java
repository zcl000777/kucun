package com.warehouse.service.impl;

import gaf2.core.util.DataBeanHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.warehouse.persistence.dao.KucunDAO;
import com.warehouse.persistence.entity.Kucun;
import com.warehouse.service.KucunService;

public class KucunServiceImpl implements KucunService{

	@Autowired
	KucunDAO dao;
	
	@Override
	public Kucun add(Kucun t) {
		
		return dao.saveAndFlush(t);
	}

	@Override
	public Kucun update(Kucun t) {
		
		Kucun ap = null;
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
	public Kucun queryOne(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public List<Kucun> queryForList(Kucun t) {
		
		return dao.findByExample(t, new Sort(Direction.DESC, "id"));
	}

	@Override
	public Page<Kucun> queryForPage(Kucun t, int page, int rows) {
		
		return dao.findByExample(t, new PageRequest(page, rows, Direction.DESC, "id"));
	}

}
