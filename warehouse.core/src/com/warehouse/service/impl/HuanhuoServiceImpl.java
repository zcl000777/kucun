package com.warehouse.service.impl;

import gaf2.core.util.DataBeanHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.warehouse.persistence.dao.HuanhuoDAO;
import com.warehouse.persistence.entity.Huanhuo;
import com.warehouse.service.HuanhuoService;

public class HuanhuoServiceImpl implements HuanhuoService{

	@Autowired
	HuanhuoDAO dao;
	
	@Override
	public Huanhuo add(Huanhuo t) {
		
		return dao.saveAndFlush(t);
	}

	@Override
	public Huanhuo update(Huanhuo t) {
		
		Huanhuo ap = null;
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
	public Huanhuo queryOne(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public List<Huanhuo> queryForList(Huanhuo t) {
		
		return dao.findByExample(t, new Sort(Direction.DESC, "id"));
	}

	@Override
	public Page<Huanhuo> queryForPage(Huanhuo t, int page, int rows) {
		
		return dao.findByExample(t, new PageRequest(page, rows, Direction.DESC, "id"));
	}

}
