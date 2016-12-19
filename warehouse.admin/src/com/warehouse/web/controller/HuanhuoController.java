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

import com.warehouse.persistence.entity.Huanhuo;
import com.warehouse.service.HuanhuoService;

@Controller
@RequestMapping(value = "/huanhuo")
public class HuanhuoController {
	
	@Autowired
	HuanhuoService HuanhuoService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Huanhuo> add(Huanhuo Huanhuo, HttpServletRequest request) {
		Huanhuo ap = HuanhuoService.add(Huanhuo);
		JsonResult<Huanhuo> js = new JsonResult<Huanhuo>(ap);
		js.setStatus(ap!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Huanhuo> update(Huanhuo Huanhuo, HttpServletRequest request) {
		Huanhuo aps = HuanhuoService.queryOne(Huanhuo.getId());
		DataBeanHelper.Bean2Bean(Huanhuo, aps);
		aps = HuanhuoService.update(aps);
		JsonResult<Huanhuo> js = new JsonResult<Huanhuo>(aps);
		js.setStatus(aps!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PagedData<Huanhuo> listforpage(Huanhuo cardShop,
			int page, int rows, HttpServletRequest request) {
		Page<Huanhuo> rs = HuanhuoService.queryForPage(cardShop, page-1,
				rows);
		return new PagedData<Huanhuo>(rs);
	}
	

	@RequestMapping(value = "/queryone", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Huanhuo> getone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		Huanhuo account = HuanhuoService.queryOne(id);
		JsonResult<Huanhuo> js = new JsonResult<Huanhuo>(account);
		js.setStatus(account!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody public String deleteone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		HuanhuoService.deleteOne(id);
		return "success";
	}
	
}
