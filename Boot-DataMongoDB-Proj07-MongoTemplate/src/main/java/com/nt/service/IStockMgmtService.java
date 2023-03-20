//IStockMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.document.StokeDetails;

public interface IStockMgmtService {
	//document saving or inserting methods
	public String registerStockDetails(StokeDetails details);
	public String registerStockDetailsByBatch(List<StokeDetails> details); 
	
	//document finding or retrieving methods
	public List<StokeDetails> fetchStockDetailsByPriceRange(double startPrice, double endPrice);
	public List<StokeDetails> fetchStockDetailsByExchange(String exchange);
	public StokeDetails fetchStockDetailsByStockId(int id);

	//updating multiple document based on certain criteria
	public String fetchAndUpdateStockDetailsByStockId(int stockId, double newPrice, String newExchange);
	public String modifyExchangeByStockPriceRange(double startPrice, double endPrice, String newExchange);
	public String registerOrUpdateStockByStockName(String stockName, double price, String exchange);
	
	//removing single and multiple documents based on certain criteria
	public String removeStocksByPriceRange(double startPrice, double endPrice);

}//interface
