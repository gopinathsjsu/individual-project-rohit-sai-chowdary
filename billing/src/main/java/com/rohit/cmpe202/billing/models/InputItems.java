package com.rohit.cmpe202.billing.models;

public class InputItems {
	
	private String itemName;
	private int quantity;
	private String cardNumber;
	
	public InputItems(String itemName, int quantity, String cardNumber) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.cardNumber = cardNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemnName) {
		this.itemName = itemnName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@Override
	public String toString() {
		return "InputItems [itemName=" + itemName + ", quantity=" + quantity + ", cardNumber=" + cardNumber + "]";
	}
	
}
