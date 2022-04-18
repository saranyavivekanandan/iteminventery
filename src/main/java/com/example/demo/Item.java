package com.example.demo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
//@Getter
public class Item { 
	
	@Id
	private int itemId;
	private String itemName;
	private String itemEnteredByUser;
	private LocalDate itemEnteredDate;
	private double itembuyingPrice;
	private double itemSellingPrice;
	private LocalDate itemLastModifiedDate;
	private String itemLastModifiedByUser;
	@Enumerated(EnumType.STRING)
	private ItemStatus itemStatus;
	
	
	public int getItemId() {
		return itemId;
	}
	public Item(int itemId, String itemName, String itemEnteredByUser, LocalDate itemEnteredDate,
			double itembuyingPrice, double itemSellingPrice, LocalDate itemLastModifiedDate,
			String itemLastModifiedByUser, ItemStatus itemStatus) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemEnteredByUser = itemEnteredByUser;
		this.itemEnteredDate = itemEnteredDate;
		this.itembuyingPrice = itembuyingPrice;
		this.itemSellingPrice = itemSellingPrice;
		this.itemLastModifiedDate = itemLastModifiedDate;
		this.itemLastModifiedByUser = itemLastModifiedByUser;
		this.itemStatus = itemStatus;
	}
	public Item() {
		super();
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemEnteredByUser() {
		return itemEnteredByUser;
	}
	public void setItemEnteredByUser(String itemEnteredByUser) {
		this.itemEnteredByUser = itemEnteredByUser;
	}
	public LocalDate getItemEnteredDate() {
		return itemEnteredDate;
	}
	public void setItemEnteredDate(LocalDate itemEnteredDate) {
		this.itemEnteredDate = itemEnteredDate;
	}
	public double getItembuyingPrice() {
		return itembuyingPrice;
	}
	public void setItembuyingPrice(double itembuyingPrice) {
		this.itembuyingPrice = itembuyingPrice;
	}
	public double getItemSellingPrice() {
		return itemSellingPrice;
	}
	public void setItemSellingPrice(double itemSellingPrice) {
		this.itemSellingPrice = itemSellingPrice;
	}
	public LocalDate getItemLastModifiedDate() {
		return itemLastModifiedDate;
	}
	public void setItemLastModifiedDate(LocalDate itemLastModifiedDate) {
		this.itemLastModifiedDate = itemLastModifiedDate;
	}
	public String getItemLastModifiedByUser() {
		return itemLastModifiedByUser;
	}
	public void setItemLastModifiedByUser(String itemLastModifiedByUser) {
		this.itemLastModifiedByUser = itemLastModifiedByUser;
	}
	public Enum<ItemStatus> getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	} 
	
	
}
