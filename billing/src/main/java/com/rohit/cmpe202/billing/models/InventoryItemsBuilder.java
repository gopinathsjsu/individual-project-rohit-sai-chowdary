package com.rohit.cmpe202.billing.models;

public class InventoryItemsBuilder  {
	private String category;
    private String itemName;
    private double price;
    private int quantity;
    
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public InventoryItemsBuilder category(String category) {
        this.category = category;
        return this;
    }
	
    public InventoryItemsBuilder itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }
	
    public InventoryItemsBuilder price(double price) {
        this.price = price;
        return this;
    }
	
    public InventoryItemsBuilder quantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
    public InventoryItems build(){
        validateItem();
        return new InventoryItems(this);
    }
    private void validateItem(){
        if(this.itemName == null){
            throw new RuntimeException("Values can not be null");
        }
    }
}

