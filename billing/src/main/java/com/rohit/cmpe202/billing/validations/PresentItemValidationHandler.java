package com.rohit.cmpe202.billing.validations;

import java.io.FileNotFoundException;
import java.util.List;

import com.rohit.cmpe202.billing.files.Output;
import com.rohit.cmpe202.billing.inventory.InventoryDatabase;
import com.rohit.cmpe202.billing.models.InputItems;
//import com.rohit.cmpe202.billing.models.InventoryItems;

public class PresentItemValidationHandler extends AbstractHandler {
	private StringBuilder message = new StringBuilder();
	private boolean is_Input_Valid = true;

	@Override
	public void nextHandler(AbstractHandler next) {
		// TODO Auto-generated method stub
		super.next = next;
	}

	@Override
	public void handle(List<InputItems> inputItems) {
		// TODO Auto-generated method stub
		System.out.println("1. Checking if all the items are present or not.");
		InventoryDatabase inventory = InventoryDatabase.getInstance();
		for(int i = 0; i< inputItems.size(); i++) {
			String itemName = inputItems.get(i).getItemName();
			if (!inventory.getItems().containsKey(itemName)) {
				message.append(itemName + " not available in inventory\n");
				is_Input_Valid = false;
			}
		}
		if (is_Input_Valid) {
			System.out.println("All the items are present.");
			super.next.handle(inputItems);
		} else {
			// write to error file
			System.out.println("Error in PresentItemValidationHandler. Check error.txt.");
			Output o1 = new Output();
			try {
				o1.writeError(message.toString());
			} catch (FileNotFoundException e) {
				System.out.println("Exception while writing to output file"+e.getMessage());
			}

		}

	}
}
