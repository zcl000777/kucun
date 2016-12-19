package com.warehouse.web.controller;

import gaf2.core.util.DataBeanHelper;
import gaf2.core.util.DateUtil;
import gaf2.core.web.easyui.PagedData;
import gaf2.core.web.model.JsonResult;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.persistence.entity.Chuhuo;
import com.warehouse.persistence.entity.Huanhuo;
import com.warehouse.persistence.entity.Kucun;
import com.warehouse.persistence.entity.Pancun;
import com.warehouse.persistence.entity.Ruku;
import com.warehouse.service.ChuhuoService;
import com.warehouse.service.HuanhuoService;
import com.warehouse.service.KucunService;
import com.warehouse.service.PancunService;
import com.warehouse.service.RukuService;

@Controller
@RequestMapping(value = "/kucun")
public class KucunController {
	
	@Autowired
	KucunService kucunService;
	
	@Autowired
	RukuService rukuService;
	
	@Autowired
	ChuhuoService chuhuoService;
	
	@Autowired
	HuanhuoService huanhuoService;
	
	@Autowired
	PancunService pancunService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Kucun> add(Kucun Kucun, HttpServletRequest request) {
		Kucun ap = kucunService.add(Kucun);
		JsonResult<Kucun> js = new JsonResult<Kucun>(ap);
		js.setStatus(ap!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Kucun> update(Kucun Kucun, HttpServletRequest request) {
		Kucun aps = kucunService.queryOne(Kucun.getId());
		DataBeanHelper.Bean2Bean(Kucun, aps);
		aps = kucunService.update(aps);
		JsonResult<Kucun> js = new JsonResult<Kucun>(aps);
		js.setStatus(aps!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PagedData<Kucun> listforpage(Kucun cardShop,
			int page, int rows, HttpServletRequest request) {
		Page<Kucun> rs = kucunService.queryForPage(cardShop, page-1,
				rows);
		return new PagedData<Kucun>(rs);
	}
	

	@RequestMapping(value = "/queryone", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Kucun> getone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		Kucun account = kucunService.queryOne(id);
		JsonResult<Kucun> js = new JsonResult<Kucun>(account);
		js.setStatus(account!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody public String deleteone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		kucunService.deleteOne(id);
		return "success";
	}
	@RequestMapping(value = "/ck", method = RequestMethod.POST)
	@ResponseBody public String chuku(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		//KucunService.deleteOne(id);
		Kucun kc = kucunService.queryOne(id);
		Ruku rk;
		Chuhuo ch = new Chuhuo();
		if(kc!=null&&kc.getItemcode()!=null){
			System.out.println(kc.getItemcode());
			System.out.println("=======================");
			rk = rukuService.finByCode(kc.getItemcode());
			ch.setAm(rk.getAmazonas());
			ch.setBattery(rk.getBattery());
			ch.setCommoditycode(rk.getItemcode());
			ch.setDate(DateUtil.toLongDate14().toString());
			ch.setTradename(rk.getProductname());
			ch = chuhuoService.add(ch);
			//更新盘存表
			if(ch!=null&&ch.getCommoditycode()!=null){
				Pancun pc = pancunService.finByCode(ch.getCommoditycode());
				
				pc.setDelivery("是");
				//pc.setReality(reality);
				pc = pancunService.update(pc);
			}
			return "success";
		}else{
			return "error";
		}
		
		
	}
	
	@RequestMapping(value = "/hhrk", method = RequestMethod.POST)
	@ResponseBody public String huanhuoruku(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		//KucunService.deleteOne(id);
		Kucun kc = kucunService.queryOne(id);
		Ruku rk;
		Huanhuo hh = new Huanhuo();
		if(kc!=null&&kc.getItemcode()!=null){
			System.out.println(kc.getItemcode());
			System.out.println("=======================");
			rk = rukuService.finByCode(kc.getItemcode());
			hh.setItemcode(rk.getItemcode());
			hh.setTime(DateUtil.toLongDate14().toString());
			
			hh = huanhuoService.add(hh);
			return "success";
		}else{
			return "error";
		}
	}
}
