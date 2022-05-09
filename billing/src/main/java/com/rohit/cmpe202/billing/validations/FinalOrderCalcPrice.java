package com.rohit.cmpe202.billing.validations;

import java.io.FileNotFoundException;
import java.util.List;

import com.rohit.cmpe202.billing.files.Output;
import com.rohit.cmpe202.billing.inventory.InventoryDatabase;
import com.rohit.cmpe202.billing.models.InputItems;

public class FinalOrderCalcPrice extends AbstractHandler{
	@Override
	public void nextHandler(AbstractHandler next) {
		// TODO Auto-generated method stub
		super.next = next;
	}
	public void handle(List<InputItems> inputItems) {
	System.out.println("Processing the final order...");
	InventoryDatabase inv=InventoryDatabase.getInstance();
	StringBuilder sb=new StringBuilder();
	StringBuilder cards = new StringBuilder();
	double final_amount = 0;
	
	sb.append("Item,Quantity,Price\n");
	
	cards.append("Cards in Inventory before the current transaction: \n");
	cards.append(inv.getCards());
	
	for(InputItems item:inputItems) {

		String it_name = item.getItemName();
		int it_quantity = item.getQuantity();
		final_amount+=inv.getItems().get(it_name).getItemPrice()*it_quantity;
		
		// updating the inventory after the transaction
		int intialInventory=inv.getItems().get(it_name).getItemQuant();
		inv.getItems().get(it_name).setItemQuant(intialInventory-it_quantity);;
		
		// adding the new card number to the database
		if(((InputItems)item).getCardNumber()!=null)
			inv.getCards().add(((InputItems)item).getCardNumber());
		
		sb.append(it_name+","+it_quantity+','+ inv.getItems().get(it_name).getItemPrice()*it_quantity+'\n');

	}
	sb.append("Total Amount \n");
	sb.append(String.valueOf(final_amount));
		
	cards.append("\nCards in Inventory after the current transaction: \n");
	cards.append(inv.getCards());

	
	Output o1 = new Output();
 	try {
		o1.writeFile(sb.toString());
		o1.writeCards(cards.toString());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
