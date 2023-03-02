//MarriageSeeker.java
package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "LOB_MARRIAGE_SEEKER")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MarriageSeeker implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer msId;
	@Column(length=20)
	@NonNull
	private String msName;
	@Column(length=20)
	@NonNull
	private String msAddrs;
	@NonNull
	private LocalDateTime dob;
	@Lob
	@NonNull
	private byte[] msPhoto;
	@Lob
	@NonNull
	private char[] msBiodata;
	@NonNull
	private boolean isIndian;

}//class
