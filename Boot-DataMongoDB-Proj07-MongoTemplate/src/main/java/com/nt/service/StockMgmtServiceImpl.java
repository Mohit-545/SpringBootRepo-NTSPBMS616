//StockMgmtServiceImpl.java
package com.nt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


import com.nt.document.StokeDetails;

@Service("stockService")
public class StockMgmtServiceImpl implements IStockMgmtService {
	@Autowired
	private MongoTemplate template;

	@Override
	public String registerStockDetails(StokeDetails details) {
		int idVal = template.save(details).getStockId();
		return "Stock is registered with id :: "+idVal;
	}//method



}//class
