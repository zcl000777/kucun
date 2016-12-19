package com.warehouse.service.impl;

import gaf2.core.util.DataBeanHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.warehouse.persistence.dao.RukuDAO;
import com.warehouse.persistence.entity.Ruku;
import com.warehouse.service.RukuService;

public class RukuServiceImpl implements RukuService{

	@Autowired
	RukuDAO dao;
	
	@Override
	public Ruku add(Ruku t) {
		
		return dao.saveAndFlush(t);
	}

	@Override
	public Ruku update(Ruku t) {
		
		Ruku ap = null;
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
	public Ruku queryOne(Long id) {
		
		return dao.findOne(id);
	}


	@Override
	public List<Ruku> queryForList(Ruku t) {
		
		return dao.findByExample(t, new Sort(Direction.DESC, "id"));
	}

	@Override
	public Page<Ruku> queryForPage(Ruku t, int page, int rows) {
		
		return dao.findByExample(t, new PageRequest(page, rows, Direction.DESC, "id"));
	}

	@Override
	public Ruku finByCode(String itemcode) {
		return dao.findByCode(itemcode);
	}

}
