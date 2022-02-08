package com.mouritech.storespringbootexample.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "store_info")
@EntityListeners(AuditingEntityListener.class)
public class Store {

	
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "store_id", length = 64)
	private String storeId;

	@Column(name = "store_address")
	private String storeAddress;

	@Column(name = "store_city")
	private String storeCity;

	@Column(name = "store_country")
	private String storeCountry;

	@Column(name = "store_email")
	private String StoreEmail;

	@Column(name = "store_mobno")
	private String storeMobileNo;

	@Column(name = "store_started_date")
	@LastModifiedDate
	private Date storeStartedDate;

	public Store() {
		// TODO Auto-generated constructor stub
	}

	public Store(String storeAddress, String storeCity, String storeCountry, String storeEmail, String storeMobileNo,
			Date storeStartedDate) {
		super();
		this.storeAddress = storeAddress;
		this.storeCity = storeCity;
		this.storeCountry = storeCountry;
		StoreEmail = storeEmail;
		this.storeMobileNo = storeMobileNo;
		this.storeStartedDate = storeStartedDate;
	}

	public Store(String storeId, String storeAddress, String storeCity, String storeCountry, String storeEmail,
			String storeMobileNo, Date storeStartedDate) {
		super();
		this.storeId = storeId;
		this.storeAddress = storeAddress;
		this.storeCity = storeCity;
		this.storeCountry = storeCountry;
		StoreEmail = storeEmail;
		this.storeMobileNo = storeMobileNo;
		this.storeStartedDate = storeStartedDate;
	}

	public Store(String storeId) {
		super();
		this.storeId = storeId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}

	public String getStoreCountry() {
		return storeCountry;
	}

	public void setStoreCountry(String storeCountry) {
		this.storeCountry = storeCountry;
	}

	public String getStoreEmail() {
		return StoreEmail;
	}

	public void setStoreEmail(String storeEmail) {
		StoreEmail = storeEmail;
	}

	public String getStoreMobileNo() {
		return storeMobileNo;
	}

	public void setStoreMobileNo(String storeMobileNo) {
		this.storeMobileNo = storeMobileNo;
	}

	public Date getStoreStartedDate() {
		return storeStartedDate;
	}

	public void setStoreStartedDate(Date storeStartedDate) {
		this.storeStartedDate = storeStartedDate;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeAddress=" + storeAddress + ", storeCity=" + storeCity
				+ ", storeCountry=" + storeCountry + ", StoreEmail=" + StoreEmail + ", storeMobileNo=" + storeMobileNo
				+ ", storeStartedDate=" + storeStartedDate + "]";
	}

}