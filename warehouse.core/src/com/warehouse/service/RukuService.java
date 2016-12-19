package com.warehouse.service;

import com.warehouse.persistence.entity.Ruku;

public interface RukuService extends BaseService<Ruku> {

	Ruku finByCode(String itemcode);

}
