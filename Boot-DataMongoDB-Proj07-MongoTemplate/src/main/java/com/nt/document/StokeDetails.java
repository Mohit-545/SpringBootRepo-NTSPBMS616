//StokeDetails.java
package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "STOCK_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StokeDetails {
	@Id
	private Integer stockId;
	private String stockName;
	private double price;
	private String exchange;
}//class
