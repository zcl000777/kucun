package com.warehouse.service;

import java.util.List;

import org.springframework.data.domain.Page;
/**
 * 基础服务类
 * @author liuxinfeng
 *
 * @param <T>
 */
public interface BaseService<T> {
	/**
	 * 添加
	 * @param t 实体类
	 * @return 实体类
	 */
	public T add(T t);
	/**
	 * 更新
	 * @param t 实体类
	 * @return 实体类
	 */
	public T update(T t); 
	/**
	 * 删除单条
	 * @param id 主键
	 */
	public void deleteOne(Long id);
	/**
	 * 查询单条
	 * @param id 主键
	 * @return 实体类 
	 */
	public T queryOne(Long id);
	/**
	 * 查询多条  返回集合
	 * @param t 实体类
	 * @return 集合
	 */
	public List<T> queryForList(T t);
	/**
	 * 分页查询
	 * @param t 实体类
	 * @param page 页号
	 * @param rows 每页行数
	 * @return page对象
	 */
	public Page<T> queryForPage(T t,int page,int rows); 
	 
}
