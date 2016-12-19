package com.warehouse.service.impl;

import gaf2.core.util.DataBeanHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.warehouse.persistence.dao.PancunDAO;
import com.warehouse.persistence.entity.Pancun;
import com.warehouse.service.PancunService;

public class PancunServiceImpl implements PancunService{

	@Autowired
	PancunDAO dao;
	
	@Override
	public Pancun add(Pancun t) {
		
		return dao.saveAndFlush(t);
	}

	@Override
	public Pancun update(Pancun t) {
		
		Pancun ap = null;
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
	public Pancun queryOne(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public List<Pancun> queryForList(Pancun t) {
		
		return dao.findByExample(t, new Sort(Direction.DESC, "id"));
	}

	@Override
	public Page<Pancun> queryForPage(Pancun t, int page, int rows) {
		
		return dao.findByExample(t, new PageRequest(page, rows, Direction.DESC, "id"));
	}

	@Override
	public Pancun finByCode(String itemcode) {
		return dao.findByCode(itemcode);
	}

}
