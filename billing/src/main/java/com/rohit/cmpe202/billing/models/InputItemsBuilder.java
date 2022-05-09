package com.rohit.cmpe202.billing.models;

public class InputItemsBuilder  {
	private String itemName;
	private String cardNumber;
    private int quantity;
    
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public InputItems build() {	
		return new InputItems(itemName, quantity, cardNumber);
	}
	
	public InputItemsBuilder category(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public InputItemsBuilder itemName(String itemName) {
		this.itemName = itemName;
        return this;
	}
	
	public InputItemsBuilder price(double price) {
		  return null;
	}
	
	public InputItemsBuilder cardNumber(String cardNumber) {
		this.cardNumber=cardNumber;;
		return this;
	}
	
	public InputItemsBuilder quantity(int quantity) {
		 this.quantity = quantity;
	        return this;
	    }

}
