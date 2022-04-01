/**
 * Jared Roque
 * Project 1
 * CSC 20-01
 */

import java.util.Scanner;

public class ShoppingCartManager {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		/**
		 * Ask the user for the name and date and stores them into the Shopping cart
		 */
		System.out.print("Enter Customer's Name: ");
		String name = kb.nextLine();
		System.out.print("Enter Today's Date: ");
		String date = kb.nextLine();

		ShoppingCart customerCart = new ShoppingCart(name, date);

		/**
		 * Prints out the name and date the user enters and sends the user to the menu of the program
		 */
		System.out.println("\nCustomer Name: " + name);
		System.out.println("Today's Date: " + date);

		printMenu(kb, customerCart);
	}

	/**
	 * Prints out the menu of the program and gives the user options to do 
	 * with the shopping cart, until they exit
	 * 
	 * @param kb
	 * @param shop
	 */
	public static void printMenu(Scanner kb, ShoppingCart shop) {
		//repeats the printMenu options until the user enters Q to exit
		Boolean repeat = false;
		while (!repeat) {
			//Users option in the menu
			System.out.println("\nMENU");
			System.out.println("a - Add item to cart\n" + "d - Remove item from cart \n" + "c - Change item quantity\n"
					+ "i - Output items' descriptions \n" + "o - Output shopping cart\n" + "q - Quit\n" + "");
			System.out.print("Choose an option: ");
			char menu = kb.next().charAt(0);
			kb.nextLine();

			/*
			 * if the user inputs a, it will ask them to input all characteristic of the
			 * item and then save them into the array
			 */
			if (menu == 'a' || menu == 'A') {
				System.out.println("ADD ITEM TO CART");
				System.out.print("Enter the item Name: ");
				String name = kb.nextLine();
				System.out.print("Enter the item description: ");
				String description = kb.nextLine();
				System.out.print("Enter the Item Price: ");
				int price = kb.nextInt();
				System.out.print("Enter the item Quantity: ");
				int quantity = kb.nextInt();
				kb.nextLine();
				ItemToPurchase item = new ItemToPurchase(name, description, price, quantity);
				shop.addItem(item);

				/**
				 * if the user inputs d, it will prompt them to enter the name of item they want
				 * to remove from the cart, if an item is not found, the program prompts them
				 * nothing was removed
				 */
			} else if (menu == 'd' || menu == 'D') {
				System.out.print("REMOVE ITEM FROM CART " + "\nEnter name of item to remove: ");
				String remove = kb.nextLine();
				shop.removeItem(remove);

				/**
				 * if the user enter c, it will give them the option to choose an existing item
				 * and edit the quantity from an existing item
				 */
			} else if (menu == 'c' || menu == 'C') {
				System.out.println("CHANGE ITEM QUANTITY");
				System.out.println("Enter the item name: ");
				String name = kb.nextLine();
				System.out.println("Enter the new Quantity: ");
				int quantity = kb.nextInt();
				kb.nextLine();
				ItemToPurchase item = new ItemToPurchase();
				item.setName(name);
				item.setQuantity(quantity);
				shop.modifyItem(item);
				
				/**
				 * Prints out the description of all items, that the user entered
				 */
			} else if (menu == 'i' || menu == 'I') {
				System.out.println("OUTPUT ITEMS' DESCRIPTION");
				shop.printDescription();
				
				/**
				 * Prints out the entire "receipt of the shopping cart
				 */
			} else if (menu == 'o' || menu == 'O') {
				System.out.println("OUTPUT SHOPPING CART");
				shop.printTotal();
				
				/**
				 * breaks while loop and ends program
				 */
			} else if (menu == 'q' || menu == 'Q') {
				return;
			}
		}
	}
}
