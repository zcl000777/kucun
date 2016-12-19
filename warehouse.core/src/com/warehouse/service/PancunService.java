package com.warehouse.service;

import com.warehouse.persistence.entity.Pancun;

public interface PancunService extends BaseService<Pancun> {
	Pancun finByCode(String itemcode);
}
