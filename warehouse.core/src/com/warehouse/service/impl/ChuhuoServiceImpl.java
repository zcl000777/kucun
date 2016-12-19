package com.warehouse.service.impl;

import gaf2.core.util.DataBeanHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.warehouse.persistence.dao.ChuhuoDAO;
import com.warehouse.persistence.entity.Chuhuo;
import com.warehouse.service.ChuhuoService;

public class ChuhuoServiceImpl implements ChuhuoService{

	@Autowired
	ChuhuoDAO dao;
	
	@Override
	public Chuhuo add(Chuhuo t) {
		
		return dao.saveAndFlush(t);
	}

	@Override
	public Chuhuo update(Chuhuo t) {
		
		Chuhuo ap = null;
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
	public Chuhuo queryOne(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public List<Chuhuo> queryForList(Chuhuo t) {
		
		return dao.findByExample(t, new Sort(Direction.DESC, "id"));
	}

	@Override
	public Page<Chuhuo> queryForPage(Chuhuo t, int page, int rows) {
		
		return dao.findByExample(t, new PageRequest(page, rows, Direction.DESC, "id"));
	}

}
