package com.rohit.cmpe202.billing.models;

public class InventoryItems {

	private String itemName;
	private String itemCat;
	private int itemQuant;
	private double itemPrice;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCat() {
		return itemCat;
	}
	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}
	public int getItemQuant() {
		return itemQuant;
	}
	public void setItemQuant(int itemQuant) {
		this.itemQuant = itemQuant;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public InventoryItems(String itemName, String itemCat, int itemQuant, double itemPrice) {
		super();
		this.itemName = itemName;
		this.itemCat = itemCat;
		this.itemQuant = itemQuant;
		this.itemPrice = itemPrice;
	}
	public InventoryItems(InventoryItemsBuilder inventoryItemsBuilder) {
		// TODO Auto-generated constructor stub
		this.itemName = inventoryItemsBuilder.getItemName();
		this.itemCat = inventoryItemsBuilder.getCategory();
		this.itemQuant = inventoryItemsBuilder.getQuantity();
		this.itemPrice = inventoryItemsBuilder.getPrice();
	}
	
}
