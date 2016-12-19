package com.warehouse.web.controller;

import gaf2.core.util.DataBeanHelper;
import gaf2.core.util.DateUtil;
import gaf2.core.web.easyui.PagedData;
import gaf2.core.web.model.JsonResult;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.read.biff.BiffException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.persistence.entity.Chuhuo;
import com.warehouse.persistence.entity.Pancun;
import com.warehouse.service.ChuhuoService;
import com.warehouse.service.PancunService;

@Controller
@RequestMapping(value = "/peihuo")
public class ChuhuoController {
	
	@Autowired
	ChuhuoService ChuhuoService;
	
	@Autowired
	PancunService pancunService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Chuhuo> add(Chuhuo Chuhuo, HttpServletRequest request) {
		Chuhuo ap = ChuhuoService.add(Chuhuo);
		JsonResult<Chuhuo> js = new JsonResult<Chuhuo>(ap);
		js.setStatus(ap!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Chuhuo> update(Chuhuo Chuhuo, HttpServletRequest request) {
		System.out.println("update=====================");
		Chuhuo ch = ChuhuoService.queryOne(Chuhuo.getId());
		DataBeanHelper.Bean2Bean(Chuhuo, ch);
		ch = ChuhuoService.update(ch);
		
		if(ch!=null&&ch.getCommoditycode()!=null){
			Pancun pc = pancunService.finByCode(ch.getCommoditycode());
			
			pc.setReality(ch.getSend());

			pc = pancunService.update(pc);
		}
		JsonResult<Chuhuo> js = new JsonResult<Chuhuo>(ch);
		js.setStatus(ch!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public PagedData<Chuhuo> listforpage(Chuhuo cardShop,
			int page, int rows, HttpServletRequest request) {
		Page<Chuhuo> rs = ChuhuoService.queryForPage(cardShop, page-1,
				rows);
		return new PagedData<Chuhuo>(rs);
	}
	

	@RequestMapping(value = "/queryone", method = RequestMethod.POST)
	@ResponseBody public JsonResult<Chuhuo> getone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		Chuhuo account = ChuhuoService.queryOne(id);
		JsonResult<Chuhuo> js = new JsonResult<Chuhuo>(account);
		js.setStatus(account!=null?0:1);
		return js;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody public String deleteone(@RequestParam(value = "id") Long id,
			HttpServletRequest request) {
		ChuhuoService.deleteOne(id);
		return "success";
	}
	//String[] title = {"序号","客户编号","客户名称","订单号码","商品编号","商品名称","电池货","发送个数","SKU码","FBA标签","发送情况","发送日期","发货地址","亚马逊订单"}; 
	
//	// 导出2007格式的EXCEL
//		@RequestMapping(value = "/expmobilecard", method = RequestMethod.GET)
//		@ResponseBody
//		public Map<String, Object> exp(HttpServletRequest request,HttpServletResponse response) throws IOException, BiffException {
//			Map<String, Object> map = new HashMap<String, Object>();
//			request.setCharacterEncoding("UTF-8");
//			String fname = "中国电信长春政企网络号码统计" + DateUtil.toStringDate14() + ".xlsx";// Excel文件名字
//			long userid = Long.parseLong(request.getSession().getAttribute("userid").toString());
//			Chuhuo user = new Chuhuo();
//			user.setUserid(userid);
//			List<Chuhuo> list=mobileService.queryForList(user);
//			try {
//				OutputStream os = response.getOutputStream();
//				response.reset();
//				response.setHeader("Content-disposition", "attachment;filename="
//						+ new String(fname.getBytes("GBK"), "ISO8859-1"));
//				response.setContentType("application/msexcel;charset=UTF-8");
//
//				// 创建表头
//				String[] title = { "序号", "手机号码", "企业名称", "号码状态" ,"微信售价","备注","最低消费","特殊号码售价"};
//				// 创建Excel工作薄
//				XSSFWorkbook workBook = new XSSFWorkbook();
//				XSSFSheet sheet = workBook.createSheet();
//				workBook.setSheetName(0, "中国电信长春政企营销号码使用状态");// 工作簿名称
//				XSSFRow titleRow = sheet.createRow(0);// 第一行标题
//				for (int i = 0; i < title.length; i++) {
//					XSSFCell cell = titleRow.createCell(i, 0);
//					cell.setCellValue(title[i]);
//				}
//				Cell cell;
//				for (int i = 0; i < list.size(); i++) {
//					XSSFRow row = sheet.createRow(i + 1);
//					// 填充序号
//					cell = row.createCell(0);
//					cell.setCellValue(Integer.toString(i + 1));
//					// 手机号码
//					cell = row.createCell(1);
//					cell.setCellValue(list.get(i).getPhoneno());
//					// 企业名称
//					cell = row.createCell(2);
//					cell.setCellValue(list.get(i).getCompany().getCname());
//					// 填充卡状态
//					cell = row.createCell(3);
//					cell.setCellValue(list.get(i).getStatus());
//					//微信价格
//					cell = row.createCell(4);
//					if(list.get(i).getWeixinprice()!=null){
//					   cell.setCellValue(list.get(i).getWeixinprice().doubleValue());
//					}
//					//备注
//					cell = row.createCell(5);
//					cell.setCellValue(list.get(i).getBackup1());
//					//最低消费
//					cell = row.createCell(6);
//					if(list.get(i).getMixcharge()!=null){
//						cell.setCellValue(list.get(i).getMixcharge().doubleValue());
//						}
//					
//					//购买价格
//					cell = row.createCell(7);
//					if(list.get(i).getPrice()!=null){
//						cell.setCellValue(list.get(i).getPrice().doubleValue());
//						}
//					
//				}
//
//				// 写入数据
//				workBook.write(os);
//				// 关闭文件
//				os.flush();
//				// 关闭输出流
//				os.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (Exception o) {
//				o.printStackTrace();
//			}
//
//			System.out.println("ok");
//			map.put("status", "已成功导出excel文件");
//			return map;
//		}
}
