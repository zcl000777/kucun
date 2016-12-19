package com.warehouse.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import gaf2.core.util.DataBeanHelper;
import gaf2.core.web.easyui.PagedData;
import gaf2.core.web.model.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.persistence.entity.Panying;
import com.warehouse.service.PanyingService;

@Controller
@RequestMapping(value = "/panying")
public class PanyingController {
	
	@Autowired
	PanyingService PanyingService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Panying> add(Panying Panying, HttpServletRequest request) {
		Panying ap = PanyingService.add(Panying);
		JsonResult<Panying> js = new JsonResult<Panying>(ap);
		js.setStatus(ap!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Panying> update(Panying Panying, HttpServletRequest request) {
		Panying aps = PanyingService.queryOne(Panying.getId());
		DataBeanHelper.Bean2Bean(Panying, aps);
		aps = PanyingService.update(aps);
		JsonResult<Panying> js = new JsonResult<Panying>(aps);
		js.setStatus(aps!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PagedData<Panying> listforpage(Panying cardShop,
			int page, int rows, HttpServletRequest request) {
		Page<Panying> rs = PanyingService.queryForPage(cardShop, page-1,
				rows);
		return new PagedData<Panying>(rs);
	}
	

	@RequestMapping(value = "/queryone", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Panying> getone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		Panying account = PanyingService.queryOne(id);
		JsonResult<Panying> js = new JsonResult<Panying>(account);
		js.setStatus(account!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody public String deleteone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		PanyingService.deleteOne(id);
		return "success";
	}
	
}
