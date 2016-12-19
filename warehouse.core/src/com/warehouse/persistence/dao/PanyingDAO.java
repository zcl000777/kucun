package com.warehouse.persistence.dao;

import gaf2.core.jpa.DynamicQueryRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.persistence.entity.Panying;

public interface PanyingDAO extends JpaRepository<Panying, Serializable>,DynamicQueryRepository<Panying>{

}
