package com.warehouse.persistence.dao;

import gaf2.core.jpa.DynamicQueryRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.warehouse.persistence.entity.Pancun;

public interface PancunDAO extends JpaRepository<Pancun, Serializable>,DynamicQueryRepository<Pancun>{
	@Query(value="select * from pancun p where p.itemcode = :itemcode",nativeQuery=true)
	Pancun findByCode(@Param("itemcode")String itemcode);
}

