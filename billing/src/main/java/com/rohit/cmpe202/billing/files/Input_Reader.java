package com.rohit.cmpe202.billing.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rohit.cmpe202.billing.models.InputItems;
import com.rohit.cmpe202.billing.models.InputItemsBuilder;

public class Input_Reader {
	public List<InputItems> readInputItems(String path) throws FileNotFoundException, IOException {
		List<InputItems> input = new ArrayList<>();
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			line = br.readLine(); // to ignore the first line which is the header
			line = br.readLine();
			while (line != null) {

				String[] content = line.split(",");
				String it_name = content[0].toLowerCase();
				int it_quant = Integer.parseInt(content[1]);

				String cardNumber = null;
				// there's only one card number and it is given in the first line
				if (content.length >= 3) {
					cardNumber = content[2];
				}
				InputItemsBuilder builder = new InputItemsBuilder();
				InputItems it = builder.itemName(it_name).quantity(it_quant).cardNumber(cardNumber).build();
				input.add(it);
				line = br.readLine(); // go to the next line
			}
		}
		return input;
	}
}
