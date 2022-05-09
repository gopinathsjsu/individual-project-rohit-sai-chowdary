package com.rohit.cmpe202.billing.validations;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rohit.cmpe202.billing.files.Output;
import com.rohit.cmpe202.billing.inventory.InventoryDatabase;
import com.rohit.cmpe202.billing.models.InputItems;
import com.rohit.cmpe202.billing.inventory.Constants;

public class CapCheckValidationHandler extends AbstractHandler {
	private boolean is_Input_Valid=true;
	private StringBuilder sb = new StringBuilder();
	
	@Override
	public void nextHandler(AbstractHandler next) {
		super.next = next;
	}
	
	@Override
	public void handle(List<InputItems> inputItems) {
		System.out.println("2. Checking if any of the categories exceeds its allowed number.");
		Map<String, Integer> map = new HashMap<>();
		InventoryDatabase inv = InventoryDatabase.getInstance();
		
		for (InputItems inp : inputItems) {
			String it_name = inp.getItemName();
			int it_quant = inp.getQuantity();
			
			map.put(inv.getItems().get(it_name).getItemCat(),
					map.getOrDefault(inv.getItems().get(it_name).getItemCat(), 0) + it_quant);
		}
		
		sb.append("Please adjust the quantities of the following\n");
		if (map.getOrDefault("Luxury", 0) > Constants.luxMax) {
			is_Input_Valid=false;
			setMessageInfo(inputItems,"Luxury", inv);
		}  if (map.getOrDefault("Essentials", 0) > Constants.essMax) {
			is_Input_Valid=false;
			setMessageInfo(inputItems,"Essentials", inv);	
		}  if (map.getOrDefault("Misc", 0) > Constants.MiscMax) {
			is_Input_Valid=false;
			setMessageInfo(inputItems,"Misc", inv);
		}
		if(is_Input_Valid) {
			System.out.print("Cap Check Validation successful.\n");
			next.handle(inputItems);
		}else {
			System.out.println("Error in CapCheckValidationHandler. Check error.txt.");
			Output o1=new Output();
			try {
				o1.writeError(sb.toString());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void setMessageInfo(List<InputItems> inputItems, String category,InventoryDatabase inv) {
		inputItems.stream()
		.filter(i -> inv.getItems().get(i.getItemName()).getItemCat().equalsIgnoreCase(category))
		.map(i->i.getItemName()+" : "+i.getQuantity())
		.forEach(i->{
			sb.append(i);
			sb.append("\n");
		});
	}
}
