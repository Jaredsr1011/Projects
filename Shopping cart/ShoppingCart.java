/**
 * 
 * @author Jared Roque
 * Project 1
 * CSC 20-01
 */
import java.util.ArrayList;

public class ShoppingCart {

	//private variables
	private String customerName;
	private String currentDate;
	
	//creates an array to store the information of the users shopping cart
	private ArrayList<ItemToPurchase> cartItems= new ArrayList<ItemToPurchase>();
	
	//default constructor, initializing private variables to default
	public ShoppingCart(){
		customerName  = "none";
		currentDate = "January 1, 2020";
	}
	
	//Parameterized constructor using the private variables as parameters
	public ShoppingCart(String cust_NAME, String curr_DATE) {
		customerName = cust_NAME;
		currentDate = curr_DATE;
	}
	
	//accessor for customerName
	public String getCustomerName() {
		return customerName;
	}
	
	//accessor for currentDate
	public String getCurrentDate() {
		return currentDate;
	}
	
	//adds items to ArrayList by using ItemToPurcahse 
	public void addItem(ItemToPurchase itemCopy) {
		cartItems.add(itemCopy);
	}
	
	/**
	 * will check if the item is found in the cart
	 * will remove item if found or will return comment if item is not found
	 */
	public void removeItem(String itemName) {
		boolean remove = false;
		for(int i = 0; i < cartItems.size(); i++) {
			ItemToPurchase item = cartItems.get(i);
			if(itemName.equals(item.getName())) {
				cartItems.remove(i);
				remove = true;
			}
		}
		if(!remove) {
			System.out.println("Item not found in cart. Nothing removed.");
		}
	}
	
	/**
	 * creates a boolean to modify items.
	 * checks all items to see if the varaible are still default, if 
	 * they are default, it modifies the item with the new information.
	 * If item is was already modified, it doesn't do anything. If the item was not found,
	 * it will give an comment that the item wasn not found in the cart
	 * 
	 * @param itemCopy ItemToPurchase(name, description, quantity, price)
	 */
	public void modifyItem(ItemToPurchase itemCopy) {
		boolean modify = false;
		for(int i = 0; i < cartItems.size(); i++) {
			ItemToPurchase currentCart = cartItems.get(i);
			if(currentCart.getName().equals(itemCopy.getName())) {
				modify = true;
				if(itemCopy.getQuantity() != 0) {
					currentCart.setQuantity(itemCopy.getQuantity());
				} else if(itemCopy.getPrice() != 0) {
					currentCart.setPrice(itemCopy.getPrice());
				} else if(!itemCopy.getDescription().equals("none")) {
					currentCart.setDescription(itemCopy.getDescription());
				} else if(!itemCopy.getName().equals("none")) {
					currentCart.setName(itemCopy.getName());
				}
			}
		}
		
		if(!modify) {
			System.out.println("Item not found in cart. Not Modified.");
		}
	}
	
	/**
	 * Gets the number of all items in the cart by using the array
	 * then adding number of items in the cart using a running total
	 * @return all the items in the cart
	 */
	public int getNumItemsInCart() {
		int numItems = 0;
		for(int i = 0; i < cartItems.size(); i++) {
			ItemToPurchase item = cartItems.get(i);
			int quantity = item.getQuantity();
			numItems += quantity;
		}
		return numItems;
	}
	
	/**
	 * Gets the cost total of the car by multiplying each item price and
	 * quantity and adding it to a running total.
	 * @return the cost of the entire cart
	 */
	public int getCostOfCart() {
		 int cartTotal = 0;
		 for(int i = 0; i < cartItems.size(); i++) {
			 ItemToPurchase item = cartItems.get(i);
			 cartTotal +=(item.getPrice() * item.getQuantity());
		 }
		 return cartTotal;
	}
	
	/**
	 * Prints out the end result of the users order. Includes each item, but if nothing is found in
	 * cart, prints out that nothing was in shopping cart
	 */
	public void printTotal() {
		int totalItems = getNumItemsInCart();
		System.out.println(getCustomerName() + "'s Shopping Cart -\n" + getCurrentDate());
		System.out.println("\nNumber of items: " + totalItems + "\n\n");
		
		// Will print the total of the entire shopping cart or return a prompt if no price
		if(totalItems > 0) {
			for(int i = 0; i < cartItems.size(); i++) {
				ItemToPurchase item = cartItems.get(i);
				item.printItemCost();
			}
			
		} else {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		System.out.println("\nTotal: " + getCostOfCart());
	}
	
	/**
	 * Prints the Description of the menu, from the array that stored the user
	 * description of an item
	 */
	public void printDescription() {
		System.out.println(getCustomerName()  + "'s Shopping Cart - " + getCurrentDate() + "\n\n");
		System.out.println("Item Description");
		
		for(int i = 0; i < cartItems.size(); i++) {
			ItemToPurchase item = cartItems.get(i);
			item.printItemDescription();
		}
	}
	
	
}
