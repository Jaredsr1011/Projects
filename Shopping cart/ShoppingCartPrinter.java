import java.util.Scanner;

public class ShoppingCartPrinter {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		ItemToPurchase item1 =  new ItemToPurchase();
		ItemToPurchase item2 = new ItemToPurchase();
	
		//Item 1 information(Name, price, and quantity)
		System.out.println("Item 1 \nEnter the Item Name:");
		String name1 = kb.nextLine();
		item1.setName(name1);
		System.out.println("Enter the Item Price:");
		int price1 = kb.nextInt();
		item1.setPrice(price1);
		System.out.println("Enter the item Quantity:");
		int quantity1 = kb.nextInt();
		kb.nextLine();
		item1.setQuantity(quantity1);
		
		//Item 2 information(Name, price, and quantity)
		System.out.println("\nItem 2 \nEnter the Item Name:");
		String name2 = kb.nextLine();
		item2.setName(name2);
		System.out.println("Enter the Item Price:");
		int price2 = kb.nextInt();
		item2.setPrice(price2);
		System.out.println("Enter the item Quantity:");
		int quantity2 = kb.nextInt();
		kb.nextLine();
		item2.setQuantity(quantity2);
		
		//Creating the receipt of the items
		System.out.println("\nTOTAL COST");
		int total1 = item1.getPrice() * item1.getQuantity();
		System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $" 
				+ item1.getPrice() + "  = $" + total1);
		
		int total2 = item2.getPrice() * item2.getQuantity();
		System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $" 
				+ item2.getPrice() + "  = $" + total2);
		
		System.out.println("Total: $" + (total1 + total2));
	}
}
