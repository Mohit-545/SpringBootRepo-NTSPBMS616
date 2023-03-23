//Offers.java
package com.nt.model.promos;

import java.time.LocalDateTime;

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

@Entity
@Data
@Table(name = "MDS_OFFERS")
@NoArgsConstructor
@RequiredArgsConstructor
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;
	
	@NonNull
	@Column(length = 50)
	private String offerName;
	
	@NonNull
	@Column(length = 50)
	private String offerCode;
	
	@NonNull
	private Double discountPercentage;
	
	@NonNull
	private LocalDateTime expiryDate;

}//class
