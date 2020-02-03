
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Shopping Cart
// Files:           None.
// Course:          Comp Sci 300, LEC-005, Spring 2019
//
// Author:          Shihan Cheng
// Email:           scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Ruoxi Shen
// Partner Email:   rshen27@wisc.edu
// Partner Lecturer's Name: LEC-005
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

/**
 * This class is an application which stores user's selected item in the market,
 * provides the functions that add, remove, calculate prices etc.
 * 
 * @author Shihan Cheng, Ruoxi Shen
 *
 */
public class ShoppingCart {
	// Define final parameters
	private static final int CART_CAPACITY = 50; // shopping cart max capacity
	private static final double TAX_RATE = 0.05; // sales tax rate

	// a perfect-size two-dimensional array that stores the available items in the
	// market
	// MARKET_ITEMS[i][0] refers to a String that represents the description of the
	// item
	// identified by index i
	// MARKET_ITEMS[i][1] refers to a String that represents the unit price of the
	// item
	// identified by index i in dollars.
	public static final String[][] MARKET_ITEMS = new String[][] { { "Apple", "$1.59" }, { "Avocado", "$0.59" },
			{ "Banana", "$0.49" }, { "Beef", "$3.79" }, { "Blueberry", "$6.89" }, { "Broccoli", "$1.79" },
			{ "Butter", "$4.59" }, { "Carrot", "$1.19" }, { "Cereal", "$3.69" }, { "Cheese", "$3.49" },
			{ "Chicken", "$5.09" }, { "Chocolate", "$3.19" }, { "Cookie", "$9.5" }, { "Cucumber", "$0.79" },
			{ "Eggs", "$3.09" }, { "Grape", "$2.29" }, { "Ice Cream", "$5.39" }, { "Milk", "$2.09" },
			{ "Mushroom", "$1.79" }, { "Onion", "$0.79" }, { "Pepper", "$1.99" }, { "Pizza", "$11.5" },
			{ "Potato", "$0.69" }, { "Spinach", "$3.09" }, { "Tomato", "$1.79" } };

	/**
	 * Adds the item with the given identifier index at the end of the cart
	 * 
	 * @param index of the item within the marketItems array
	 * @param cart  shopping cart
	 * @param count number of items present within the cart before this add method
	 *              is called
	 * @return the number of items present in the cart after the item with
	 *         identifier index is added
	 */
	public static int add(int index, String[] cart, int count) {
		// Check that array has space
		if (count == cart.length) {
			System.out.println("WARNING: The cart is full. You cannot add any new item.");
			return count;
		}

		// If array has space, add the element to the array and increase the count
		cart[count] = MARKET_ITEMS[index][0];
		++count;

		// Return the count for updating the shopping cart's current size
		return count;
	}

	/**
	 * Returns how many occurrences of the item with index itemIndex are present in
	 * the shopping cart
	 * 
	 * @param itemIndex identifier of the item to count its occurrences in the cart
	 * @param cart      shopping cart
	 * @param count     number of items present within the cart
	 * @return the number of occurrences of item in the cart
	 */
	public static int occurrencesOf(int itemIndex, String[] cart, int count) {
		// Declare an integer for counting the occurrences of the item
		int time = 0; 
		
		// If the shopping cart is empty, return 0
		if (count == 0) {
			return time;
		}
		
		// This loop is checking the cart item by item, once the item shows, time
		// increases
		for (int i = 0; i < count; i++) {
			if (cart[i].equals(MARKET_ITEMS[itemIndex][0])) {
				++time;
			}
		}

		// Return the occurrence of the item
		return time;
	}

	/**
	 * Returns the index of an item within the shopping cart
	 * 
	 * @param item  description
	 * @param cart  Shopping cart
	 * @param count number of items present in the shopping cart
	 * @return index of the item within the shopping cart, and -1 if the item does
	 *         not exist in the cart
	 */
	private static int indexOf(String item, String[] cart, int count) {
		// Once the item in cart match the item which user wants to remove, return its
		// index of the item in cart
		for (int i = 0; i < count; i++) {
			if (item.equals(cart[i])) {
				return i;
			}
		}

		// If the item selected by user is not in the cart, return -1
		return -1;
	}

	/**
	 * Removes the first (only one) occurrence of itemToRemove if found and returns
	 * the number of items in the cart after remove operation is completed either
	 * successfully or not
	 * 
	 * @param itemToRemove description of the item typed in by user
	 * @param cart         Shopping cart
	 * @param count        number of items present in the shopping cart
	 * @return amount of the cart after removing the item
	 */
	public static int remove(String itemToRemove, String[] cart, int count) {
		// If the shopping cart is empty, return the size 0
		if (count == 0) {
			return count;
		}

		// Declare an integer and assign it by calling indexOf() to get the index of
		// item selected by user in cart
		int index = indexOf(itemToRemove, cart, count);

		// If the returned value by indexOf() is -1, means the item is not in cart
		// Return the current size count
		if (index == -1) {
			System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
			return count;
		}

		// If the returned value is the index
		// move the element at the end of the array to this index
		cart[index] = cart[count - 1];
		cart[count - 1] = null;

		// Update count
		count = count - 1;

		// Return the current size of shopping cart
		return count;
	}

	/**
	 * returns the total value (cost) of the cart without tax in $ (double)
	 * 
	 * @param cart  Shopping cart
	 * @param count number of items present in the shopping cart
	 * @return the total value (cost) of the cart without tax in $ (double)
	 */
	public static double getSubTotalPrice(String[] cart, int count) {
		// Declare a string used for storing the price content in MARKET_ITEMS
		String singlePrice = null;
		double itemPrice = 0; // Used for store the item's price
		double subPrice = 0; // Used for store the total price without tax
		
		// This loop is looking for the matching item between shopping cart and
		// MARKET_ITEMS. Once found the matching item, add the price into subPrice
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < MARKET_ITEMS.length; j++) {
				if (cart[i].equals(MARKET_ITEMS[j][0])) {
					singlePrice = MARKET_ITEMS[j][1].toString();
					itemPrice = Double.valueOf(singlePrice.substring(1, singlePrice.length()));
					subPrice += itemPrice;
				}
			}
		}

		// Return the total value (cost) of the cart without tax in $ (double)
		return subPrice;
	}

	/**
	 * prints the Market Catalog (item identifiers, description, and unit prices)
	 * 
	 * no turn value
	 */
	public static void printMarketCatalog() {
		// Print the header of the market catalog
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Item id 	Description 	 Price");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

		// This loop is print the catalog item's index, item description and price line
		// by line
		for (int i = 0; i < MARKET_ITEMS.length; i++) {
			System.out.println(i + "\t\t" + MARKET_ITEMS[i][0] + "    \t " + MARKET_ITEMS[i][1]);

		}
	}

	/**
	 * Displays the cart content (items separated by commas)
	 * 
	 * @param cart  Shopping cart
	 * @param count number of items present in the shopping cart No return value
	 */
	public static void displayCartContent(String[] cart, int count) {
		// Print out the cart content header
		System.out.print("Cart Content: ");
		
		// Print out the content one by one followed by ","
		for (int i = 0; i < count; ++i) {
			System.out.print(cart[i] + ", ");
		}
		
		// At the end, print a new line
		System.out.println();
	}

	/**
	 * Represents the shopping cart application
	 * 
	 * @param args (input arguments if any)
	 */
	public static void main(String arg[]) {
		// The following code is the welcome board.
		System.out.println("=============   Welcome to the Shopping Cart App   =============\n");

		// Create an oversize array to store the user's item chose with constant size
		String[] shoppingCart = new String[CART_CAPACITY];

		int count = 0; // Use as the shopping cart size

		// Create a scanner to scan the user's input as the commands
		Scanner sc = new Scanner(System.in);
		boolean quit = false;

		while (!quit) {

			// Display the command menu
			System.out.println("\nCOMMAND MENU:\n" + " [P] print the market catalog\n"
					+ " [A <index>] add one occurrence of an item to the cart given its identifier\n"
					+ " [C] checkout\n" + " [D] display the cart content\n"
					+ " [O <index>] number of occurrences of an item in the cart given its identifier\n"
					+ " [R <index>] remove one occurrence of an item from the cart given its identifier\n"
					+ " [Q]uit the application\n");
			// Prompt user to type in
			System.out.print("ENTER COMMAND: ");
			
			// Get the user's input as the command
			String input = sc.next();
			// Declare an integer to store integers in user's input as command in following code
			int index = 0;

			// When user's input is P or p
			if (input.equals("P") || input.equals("p")) {
				// Call printMarketCatalog() to show market items
				printMarketCatalog();

			}

			// When user's input is A or a
			else if (input.equals("A") || input.equals("a")) {
				// Read next integer used as the index
				index = sc.nextInt();
				// Call add() to add item picked into the cart
				// Get the amount of items already in the cart
				count = add(index, shoppingCart, count);

			}

			// When user's input is C or c
			else if (input.equals("C") || input.equals("c")) {
				double subTotalPrice = 0; // Used for storing the returned value
				// Call getSubTotalPrice(), get the sub-total amount
				subTotalPrice = getSubTotalPrice(shoppingCart, count);

				double tax = 0; // Used for calculating tax
				tax = subTotalPrice * TAX_RATE; // Get the tax by TAX_RATE

				double totalPrice = 0; // Used for calculating the total price
				totalPrice = subTotalPrice + tax; // Get the total price

				// Display the amount of items, sub-total price, tax and total price to users
				System.out.println("#items: " + count + " Subtotal: $" + String.format("%.2f", subTotalPrice)
						+ " Tax: $" + String.format("%.2f", tax) + " TOTAL: $" + String.format("%.2f", totalPrice));

			}

			// When user's input is D or d
			else if (input.equals("D") || input.equals("d")) {
				// Call displayCartContent()
				displayCartContent(shoppingCart, count);

			}

			// When user's input is O or o
			else if (input.equals("O") || input.equals("o")) {
				// Read next integer used as the index
				index = sc.nextInt();
				int time = 0; // Used for storing the returned value
				time = occurrencesOf(index, shoppingCart, count);
				System.out.println(
						"The number of occurrences of " + MARKET_ITEMS[index][0] + " (id #" + index + ") is: " + time);

			}

			// When user's input is R or r
			else if (input.equals("R") || input.equals("r")) {
				// Read next integer used as the index
				index = sc.nextInt();
				// Show the item typed in by users, displayed in the market catalog
				String itemToRemove = MARKET_ITEMS[index][0];
				// Get current size after calling remove()
				count = remove(itemToRemove, shoppingCart, count);

			}

			// When user's input is Q or q
			else if (input.equals("Q") || input.equals("q")) {
				// Quit the application and print out the farewell words.
				System.out.print("=============  Thank you for using this App!!!!!  =============\n");
				// quit = true, then quit the loop, end the application
				quit = true;
			}

		}

	}
}
