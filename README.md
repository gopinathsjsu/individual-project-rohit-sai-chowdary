# individual-project-rohit-sai-chowdary

CMPE202 - Rohit Sai Chowdary Potluri - SJSU ID: 015278640 - Individual Project

# Problem Statement:
The application should maintain an internal, static database (inventory of stock)  (this may be developed using HashMaps and/or other  built-in Java Data structures). This means once we re-run the program, the changes to the data would not persist. We will provide the data that has to be maintained. The data will contain the following tables and fields:
(Sample input file and sample data set for the inventory would be provided separately)
Table 1: Items
- Category (Essentials, Luxury, Miscellaneous)
- Item for each category (Essentials - Clothes, soap, milk; Luxury - perfume, chocolates; Misc - Bedsheets, footwear)
- The available Quantity of each item
- Price of each item
Table 2: Cards
- Card Numbers
2. Input CSV file will contain an order including Items, Quantity needed, and the payment card number.
3. Input file should be processed as follows:
- Validate if the requested quantity for each item is permissible. For example, if the request is to order 3 soaps, check the database if we have at least 3 soaps in our inventory.
- There will be a cap on the quantity of each category that can be ordered in one single order. For example, restrict Essentials to a maximum of 3, Luxury to 4, and Misc to 6. (This will be configured beforehand)
- In case it is an incorrect request, generate and output TXT file with message "Please correct quantities." and include the items with incorrect quantities
- After this validation, if the cart is valid, calculate prices for the cart.
- Take the card number of the user and if it is not present in DB add it.
- Output the CSV list with the total amount paid.

# Design Patterns Used:
- Singleton
- Chain of Responsibility
- Builder

## Singleton Design Pattern:
- Used this design pattern for the database part of the application. 
- The getInstance() method is called whenever an instance of the inventory is needed. It only creates one instance of the object which can be reused.

## Chain of Responsibility Design Pattern:
- Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. 
- Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
- Used this pattern to validate order input files and to calculate the final price if the input is valid.
	- abstract class AbstractHandler
	- class PresentItemValidationHandler - to check if the item is present or not.
	- class CapCheckValidationHandler - to check if any category is crossing its max limit allowed.
	- class StockEnoughValidationHandler - to check if there are enough items present in the inventory.
	- class FinalOrderCalcPrice - if the input is valid, then calculate the final price of the input order.

## Builder Design Pattern:
- Builder is a creational design pattern that lets you construct complex objects step by step. 
- The pattern allows you to produce different types and representations of an object using the same construction code.
- Used this pattern to create builder classes for InputItems class and InventoryItems class.
	- class InputItemsBuilder
	- class InventoryItemsBuilder


# Instructions to run the JAR file:
- Go to the location of the JAR file and open the command prompt.
- Run the following command: java -jar <"location_jar"> <"location_inputfile">
- For example: java -jar Jars/Billing-0.0.1-SNAPSHOT.jar Input1.csv

## Test Case 1:
![Input1_SS](https://user-images.githubusercontent.com/89537171/167507814-3dd6f1ff-4e63-4e66-8f6c-fcc313e50be9.png)

## Output 1:
![Output1_SS](https://user-images.githubusercontent.com/89537171/167507863-5c8b30a2-ffa6-4ce8-9c90-0b2814d07d18.png)

## Test Case 2:
![Input2_SS](https://user-images.githubusercontent.com/89537171/167507897-3ac6f1f3-e3dd-4164-9ae6-dbef0c37a469.png)

## Output 2:
![Output2_SS](https://user-images.githubusercontent.com/89537171/167507919-d7697268-1e1e-4a79-993c-211e995f7cd0.png)



