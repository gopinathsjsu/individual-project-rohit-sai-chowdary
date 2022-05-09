package com.rohit.cmpe202.billing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.rohit.cmpe202.billing.files.Input_Reader;
import com.rohit.cmpe202.billing.inventory.InventoryDatabase;
import com.rohit.cmpe202.billing.models.InputItems;
import com.rohit.cmpe202.billing.validations.AbstractHandler;
import com.rohit.cmpe202.billing.validations.CapCheckValidationHandler;
import com.rohit.cmpe202.billing.validations.FinalOrderCalcPrice;
import com.rohit.cmpe202.billing.validations.PresentItemValidationHandler;
import com.rohit.cmpe202.billing.validations.StockEnoughValidationHandler;

public class Billing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 1) {
			System.out.print("Please provide the input file path as argument");
			System.exit(-1);
		}
		try {
		//1. Intialize db
		InventoryDatabase invDb=InventoryDatabase.getInstance();

		//2. read file from inventory
		Input_Reader reader = new Input_Reader();
		List<InputItems> inputItems = reader.readInputItems(args[0]);
		
		//3. Create objects of validation
		AbstractHandler itemPresentObj = new PresentItemValidationHandler();
		AbstractHandler maxcapObj = new CapCheckValidationHandler();
		AbstractHandler quantityDbValidObj = new StockEnoughValidationHandler();
		AbstractHandler processObj = new FinalOrderCalcPrice();
		
		//4. create chain
		itemPresentObj.nextHandler(maxcapObj);
		maxcapObj.nextHandler(quantityDbValidObj);
		quantityDbValidObj.nextHandler(processObj);
		
		//5. call handle method
		itemPresentObj.handle(inputItems);
	}catch (FileNotFoundException e) {
		System.out.println("Input File Not Found");
		e.printStackTrace();
	} catch (IOException e1) {
		System.out.println("Error processing or reading input file");
		e1.printStackTrace();
	}
	}

}
