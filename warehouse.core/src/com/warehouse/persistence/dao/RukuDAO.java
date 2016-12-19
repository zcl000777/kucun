package com.warehouse.persistence.dao;

import gaf2.core.jpa.DynamicQueryRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.warehouse.persistence.entity.Ruku;

public interface RukuDAO extends JpaRepository<Ruku, Serializable>,DynamicQueryRepository<Ruku>{
	@Query(value="select * from ruku r where r.itemcode = :itemcode",nativeQuery=true)
	Ruku findByCode(@Param("itemcode")String itemcode);
}
