//Product.java
package com.nt.model.prod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Table(name = "MDS_PRODUCT")
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@NonNull
	@Column(length = 50)
	private String pname;
	
	@NonNull
	private Double qty;

	@NonNull
	private Double price;

}//class
