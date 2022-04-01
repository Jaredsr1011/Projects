/**
 * 
 * @author Jared Roque
 * Project 1
 * CSC 20-01
 *
 */
public class ItemToPurchase {
	
	//Private variables
	private String itemName;
	private String itemDescription;
	private int itemPrice;
	private int itemQuantity;
	
	//Sets the variables to default, none or 0
	public ItemToPurchase() {
		itemName = "none";
		itemDescription = "none";
		itemPrice = 0;
		itemQuantity = 0;
	}
	
	//Accessor for itemName
	public String getName() {
		return itemName;
	}
	
	//Mutator for itemName
	public void setName(String itemName) {
		this.itemName = itemName;
	}
	
	//Accessor for itemPrice
	public int getPrice() {
		return itemPrice;
	}
	
	//Mutator for itemPrice
	public void setPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	//Accessor for itemQuantity
	public int getQuantity() {
		return itemQuantity;
	}
	
	//Mutator for itemQuantity
	public void setQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	//Accessor for itemDescription
	public String getDescription() {
		return itemDescription;
	}
	
	//Mutator for itemDescription
	public void setDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	/** Assigning variables to the private field variable 
	 * to the constructor of each variable
	 * 
	 * @param name set to itemName
	 * @param description set to itemDescription
	 * @param price
	 * @param quantity
	 */
	public ItemToPurchase(String name, String description, int price, int quantity) {
		itemName = name;
		itemDescription = description;
		itemPrice = price;
		itemQuantity = quantity;
	}
	
	//prints out the cost of an item
	public void printItemCost() {
		System.out.println(getName() + " " + getQuantity() + " @ $" + getPrice() + " = $" +(getQuantity()* getPrice()));
	}
	
	//prints out a description of an item
	public void printItemDescription() {
		System.out.println(getName() + ": " + getDescription());
	}
}
