//StockMgmtServiceImpl.java
package com.nt.service;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
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

	@Override
	public String registerStockDetailsByBatch(List<StokeDetails> details) {
		int size = ((List<StokeDetails>)template.insertAll(details)).size();
		return size+" no. of documents are saved";
	}//method

	@Override
	public List<StokeDetails> fetchStockDetailsByPriceRange(double startPrice, double endPrice) {
		//create Query object and add criteria object
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).lte(endPrice));
		List<StokeDetails> list = template.find(query, StokeDetails.class);
		return list;
	}//method

	@Override
	public List<StokeDetails> fetchStockDetailsByExchange(String exchange) {
		// create Query object and add Criteria obj to it 
		Query query = new Query();
		query.addCriteria(Criteria.where("exchange").is(exchange));
		List<StokeDetails> list = template.find(query, StokeDetails.class);
		return list;
	}//method

	@Override
	public StokeDetails fetchStockDetailsByStockId(int id) {
		return template.findById(id, StokeDetails.class);
	}//method

	@Override
	public String fetchAndUpdateStockDetailsByStockId(int stockId, double newPrice, String newExchange) {
		Query query = new Query();
		query.addCriteria(Criteria.where("stockId").is(stockId));
		Update update = new Update();
		update.set("price", newPrice);
		update.set("exchange", newExchange);
		//invoke the method
		StokeDetails details = template.findAndModify(query, update, StokeDetails.class);
		return details==null?"Stock details not found":"Stock found and updated";
	}//method

	@Override
	public String modifyExchangeByStockPriceRange(double startPrice, double endPrice, String newExchange) {
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).lte(endPrice));
		Update update = new Update();
		update.set("exchange", newExchange);
		//invoke the method
		UpdateResult result = template.updateMulti(query, update, StokeDetails.class);
		return result.getModifiedCount()+" no. of documents got updated";
	}//method

	@Override
	public String registerOrUpdateStockByStockName(String stockName, double price, String exchange) {
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		Update update = new Update();
		update.set("exchange", exchange);	//for updating if doc is present
		update.set("price", price);	//for updating if doc is present
		update.setOnInsert("stockName", stockName); // for inserting if doc is not present
		update.setOnInsert("stockId", new Random().nextInt(100000)); // for inserting if doc in not present
		//invoke the method
		UpdateResult result = template.upsert(query, update, StokeDetails.class);
		if(result.getModifiedCount()==0)
		return "new document is inserted with document id :: "+result.getUpsertedId();
		else
			return "document found and modified";
	}//method

	@Override
	public String removeStocksByPriceRange(double startPrice, double endPrice) {
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).lte(endPrice));
		//invoke the method
		int size = template.findAllAndRemove(query, StokeDetails.class).size();
		return size+" no. of documents are found and removed";
	}//method



}//class
