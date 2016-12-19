package com.warehouse.web.controller;

import gaf2.core.util.DataBeanHelper;
import gaf2.core.util.DateUtil;
import gaf2.core.web.easyui.PagedData;
import gaf2.core.web.model.JsonResult;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.persistence.entity.Kucun;
import com.warehouse.persistence.entity.Pancun;
import com.warehouse.persistence.entity.Ruku;
import com.warehouse.service.KucunService;
import com.warehouse.service.PancunService;
import com.warehouse.service.RukuService;

@Controller
@RequestMapping(value = "/ruku")
public class RukuController {
	
	@Autowired
	RukuService rukuService;
	
	@Autowired
	KucunService cucunService;
	
	@Autowired
	PancunService pancunService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Ruku> add(Ruku ruku, HttpServletRequest request) {
		ruku.setTime(DateUtil.toLongDate14().toString());
		//添加库存表
		Kucun kc = new Kucun();
		kc.setItemcode(ruku.getItemcode());
		kc.setTradename(ruku.getProductname());
		kc.setBattery(ruku.getBattery());
		kc.setConnect(ruku.getConnect());
		kc.setNumber(Long.parseLong(ruku.getRealquantity()));
		
		Ruku rk = rukuService.add(ruku);
		
		kc = cucunService.add(kc);
		
		//更新盘存表
		if(rk!=null&&rk.getId()!=null){
			Pancun pc = new Pancun();
			pc.setItemcode(rk.getItemcode());
			pc.setTradename(rk.getProductname());
			pc.setDelivery("否");
			pc.setPid(Long.parseLong(rk.getRealquantity()));//数据库库存数量
			
			pc = pancunService.add(pc);
		}
		
		JsonResult<Ruku> js = new JsonResult<Ruku>(rk);
		js.setStatus(rk!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Ruku> update(Ruku Ruku, HttpServletRequest request) {
		Ruku aps = rukuService.queryOne(Ruku.getId());
		DataBeanHelper.Bean2Bean(Ruku, aps);
		aps = rukuService.update(aps);
		JsonResult<Ruku> js = new JsonResult<Ruku>(aps);
		js.setStatus(aps!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PagedData<Ruku> listforpage(Ruku cardShop,
			int page, int rows, HttpServletRequest request) {
		Page<Ruku> rs = rukuService.queryForPage(cardShop, page-1,
				rows);
		return new PagedData<Ruku>(rs);
	}
	

	@RequestMapping(value = "/queryone", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Ruku> getone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		Ruku account = rukuService.queryOne(id);
		JsonResult<Ruku> js = new JsonResult<Ruku>(account);
		js.setStatus(account!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody public String deleteone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		rukuService.deleteOne(id);
		return "success";
	}
	
	@RequestMapping(value = "/impruku", method = RequestMethod.POST)
	public String imp(@RequestParam("exlfile") MultipartFile excelFile,
			HttpServletRequest request) throws IOException, BiffException {
		InputStream fis = null;
		String amazonas = "";
		String article = "";
		String asin = "";
		String battery = "";
		String buying = "";
		String connect = "";
		String itemcode = "";
		String logistics = "";
		String logisticsprocess = "";
		String picture = "";
		String position = "";
		String productname = "";
		String purchaser = "";
		String quantity = "";
		String realquantity = "";
		String remark = "";
		String remarks = "";
		String testarticle = "";
		
		
		fis = excelFile.getInputStream();
		// 判断扩展名
		String filename = excelFile.getOriginalFilename();
//    	String ids = request.getSession().getAttribute("Rukuids").toString();
//		long userid = Long.parseLong(request.getSession().getAttribute("userid").toString());
//		ids = ids.substring(1, ids.length() - 1);
//		String[] Rukuids = ids.split("\\|");
		if (filename.trim().endsWith(".xls")) {// excel2003,jxl.jar
			Workbook book = Workbook.getWorkbook(fis);
			Sheet sheet = book.getSheet(0);
			int rows = sheet.getRows();
			List<String> list1=new ArrayList<String>();	
			for (int i = 1; i < rows; i++) {
				amazonas = sheet.getCell(0, i).getContents();
				article = sheet.getCell(1, i).getContents();
				asin = sheet.getCell(2, i).getContents();
				battery = sheet.getCell(3, i).getContents();
				buying = sheet.getCell(4, i).getContents();
				connect = sheet.getCell(5, i).getContents();
				itemcode = sheet.getCell(6, i).getContents();
				logistics = sheet.getCell(7, i).getContents();
				logisticsprocess = sheet.getCell(8, i).getContents();
				picture = sheet.getCell(9, i).getContents();
				position = sheet.getCell(10, i).getContents();
				productname = sheet.getCell(11, i).getContents();
				purchaser = sheet.getCell(12, i).getContents();
				quantity = sheet.getCell(13, i).getContents();
				realquantity = sheet.getCell(14, i).getContents();
				remark = sheet.getCell(15, i).getContents();
				remarks = sheet.getCell(16, i).getContents();
				testarticle = sheet.getCell(17, i).getContents();
				System.out.println("start=================================================");
				System.out.println(amazonas);
				System.out.println(article);
				System.out.println(asin);
				System.out.println(battery);
				System.out.println(buying);
				System.out.println(connect);
				System.out.println(itemcode);
				System.out.println(logistics);
				System.out.println(logisticsprocess);
				System.out.println(picture);
				System.out.println(productname);
				System.out.println(purchaser);
				System.out.println(quantity);
				System.out.println(realquantity);
				System.out.println(remark);
				System.out.println(remarks);
				System.out.println(testarticle);
				System.out.println("end================================================");
				Ruku rk = new Ruku();
				rk.setArticle(article);
				rk.setAmazonas(amazonas);
				rk.setTestarticle(testarticle);
				rk.setAsin(asin);
				rk.setBattery(battery);
				rk.setBuying(buying);
				rk.setConnect(connect);
				rk.setItemcode(itemcode);
				rk.setLogistics(logisticsprocess);
				rk.setLogisticsprocess(logisticsprocess);
				rk.setPicture(picture);
				rk.setPosition(position);
				rk.setProductname(productname);
				rk.setPurchaser(purchaser);
				rk.setQuantity(realquantity);
				rk.setRealquantity(realquantity);
				rk.setRemark(remarks);
				rk.setRemarks(remarks);
				rk.setTestarticle(testarticle);
				rk.setTime(DateUtil.toLongDate14().toString());
				rk = rukuService.add(rk);
			}
			book.close();
		}
		
		return "/ruku/list";
	}

}
