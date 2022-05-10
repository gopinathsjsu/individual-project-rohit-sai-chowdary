package com.rohit.cmpe202.billing.inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.rohit.cmpe202.billing.models.InventoryItems;
import com.rohit.cmpe202.billing.models.InventoryItemsBuilder;


public class InventoryDatabase {

	public static InventoryDatabase dbInstance = null;
	public static Map<String,InventoryItems> itemsMap = new HashMap<String, InventoryItems>();
	public static Set<String> cards = null;
	
	
	private InventoryDatabase() {
		String filePath = "Dataset.csv";
		String line = "";
		System.out.println("Creating inventory");
		InputStream is=this.getClass().getClassLoader().getResourceAsStream((filePath));
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			br.readLine();
			while ((line = br.readLine())!= null) {
				String [] dataset = line.split(",");
				int quant = Integer.parseInt(dataset[2]);
				double price = Double.parseDouble(dataset[3]);
				InventoryItemsBuilder itembuilder= new InventoryItemsBuilder();
				InventoryItems newDataitem = itembuilder.itemName(dataset[0].toLowerCase()).category(dataset[1])
						.quantity(quant).price(price).build();
				itemsMap.put(dataset[0].toLowerCase(), newDataitem);
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		cards = new HashSet<>();
		cards.add("5410000000000000");
		cards.add("4120000000000");
		cards.add("341000000000000");
		cards.add("6010000000000000");
	}
	public Map<String, InventoryItems> getItems(){
		return itemsMap;
	}
	
	public static void setItems(Map<String, InventoryItems> itemsMap) {
		InventoryDatabase.itemsMap = itemsMap;
	}
	
	public Set<String> getCards(){
		return cards;
	}
	
	public static void setCards(Set<String> cards) {
		InventoryDatabase.cards = cards;
	}
	
	
	public static InventoryDatabase getInstance() {
		if(dbInstance==null)
			return dbInstance=new InventoryDatabase();
		else
			return dbInstance;
	}
}
