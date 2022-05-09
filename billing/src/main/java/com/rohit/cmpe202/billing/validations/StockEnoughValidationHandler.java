package com.rohit.cmpe202.billing.validations;

import java.io.FileNotFoundException;
import java.util.List;

import com.rohit.cmpe202.billing.files.Output;
import com.rohit.cmpe202.billing.inventory.InventoryDatabase;
import com.rohit.cmpe202.billing.models.InputItems;

public class StockEnoughValidationHandler extends AbstractHandler{
	
	private StringBuilder sb = new StringBuilder();
	private boolean is_Input_Valid = true;
	
	@Override
	public void nextHandler(AbstractHandler next) {
		super.next = next;
	}
	
	@Override
	public void handle(List<InputItems> inputItems) {
		System.out.println("3. Inside Stock Validation - Checking if there's enough stock present");
		InventoryDatabase db=InventoryDatabase.getInstance();
		
		sb.append("Please Check the Quantities of the following\n");
		for(InputItems inp:inputItems) {
			//when inventory quantity is less
			if(db.getItems().get(inp.getItemName()).getItemQuant()<inp.getQuantity()) {
				is_Input_Valid=false;
				sb.append(inp.getItemName()+":("+inp.getQuantity()+")\n");
			}
		}
		if(is_Input_Valid) {
			System.out.println("Stock Validation successful.");
			next.handle(inputItems);
		}else {
			System.out.println("Error in StockEnoughValidationHandler. Check error.txt.");
			Output o1 = new Output();
			try {
				o1.writeError(sb.toString());
			}catch(FileNotFoundException e) {
				System.out.println("Exception while writing to output file"+e.getMessage());
			}
		}
	}

}
