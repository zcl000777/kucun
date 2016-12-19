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

import com.warehouse.persistence.entity.Pancun;
import com.warehouse.service.PancunService;

@Controller
@RequestMapping(value = "/pancun")
public class PancunController {
	
	@Autowired
	PancunService PancunService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Pancun> add(Pancun Pancun, HttpServletRequest request) {
		Pancun ap = PancunService.add(Pancun);
		JsonResult<Pancun> js = new JsonResult<Pancun>(ap);
		js.setStatus(ap!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Pancun> update(Pancun Pancun, HttpServletRequest request) {
		Pancun aps = PancunService.queryOne(Pancun.getId());
		DataBeanHelper.Bean2Bean(Pancun, aps);
		aps = PancunService.update(aps);
		JsonResult<Pancun> js = new JsonResult<Pancun>(aps);
		js.setStatus(aps!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PagedData<Pancun> listforpage(Pancun cardShop,
			int page, int rows, HttpServletRequest request) {
		Page<Pancun> rs = PancunService.queryForPage(cardShop, page-1,
				rows);
		return new PagedData<Pancun>(rs);
	}
	

	@RequestMapping(value = "/queryone", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Pancun> getone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		Pancun account = PancunService.queryOne(id);
		JsonResult<Pancun> js = new JsonResult<Pancun>(account);
		js.setStatus(account!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody public String deleteone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		PancunService.deleteOne(id);
		return "success";
	}
}
