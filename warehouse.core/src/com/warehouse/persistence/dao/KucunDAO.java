package com.warehouse.persistence.dao;

import gaf2.core.jpa.DynamicQueryRepository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.persistence.entity.Kucun;

public interface KucunDAO extends JpaRepository<Kucun, Serializable>,DynamicQueryRepository<Kucun>{

}
