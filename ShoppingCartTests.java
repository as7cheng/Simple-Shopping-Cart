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

/**
 * This class includes some tests for the application ShoppingCart
 * Every test should test the function of methods in ShoppingCart.java
 * 
 * @author Shihan Cheng, Ruoxi Shen
 *
 */
public class ShoppingCartTests {

	/**
	 * Checks whether the total number of items within the cart is incremented after
	 * adding one item
	 * 
	 * @return true if the test passes without problems, false otherwise
	 */
	public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
		boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
									// false otherwise
		String[] cart = new String[20]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// Add an item to the cart
		count = ShoppingCart.add(3, cart, count); // add an item of index 3 to the cart
		// Check that count was incremented
		if (count != 1) {
			System.out.println("Problem detected: After adding only one item to the cart, "
					+ "the cart count should be incremented. But, it was not the case.");
			testPassed = false;
		}
		return testPassed;
	}

	/**
	 * Checks whether the total number of items within the cart is incremented after
	 * adding multiple items
	 * 
	 * @return true if the test passes without problems, false otherwise
	 */
	public static boolean testCountIncrementedAfterAddingmultipleItems() {
		boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
									// false otherwise
		String[] cart = new String[20]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// Add four items to the cart
		count = ShoppingCart.add(3, cart, count); // add an item of index 3 to the cart
		count = ShoppingCart.add(5, cart, count); // add an item of index 3 to the cart
		count = ShoppingCart.add(11, cart, count); // add an item of index 3 to the cart
		count = ShoppingCart.add(7, cart, count); // add an item of index 3 to the cart

		// Check that count was incremented
		if (count != 4) {
			System.out.println("Problem detected: After adding multiple items to the cart, "
					+ "the cart count should be incremented by 4. But, it was not the case.");
			testPassed = false;
		}
		return testPassed;
	}

	/**
	 * Checks whether add and OccurrencesOf return the correct output when only one
	 * item is added to the cart
	 * 
	 * @return true if test passed without problems, false otherwise
	 */
	public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// check that OccurrencesOf returns 0 when called with an empty cart
		if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
			System.out.println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
					+ "empty. The result should be 0. But, it was not.");
			testPassed = false;
		}

		// add one item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

		// check that OccurrencesOf("Apples", cart, count) returns 1 after adding the
		// item with key 0
		if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
			System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
					+ "OccurrencesOf to count how many of that item the cart contains should return 1. "
					+ "But, it was not the case.");
			testPassed = false;
		}

		return testPassed;
	}

	/**
	 * Checks that when only one attempt to remove an item present in the cart is
	 * made, only one occurrence of that item is removed from the cart
	 * 
	 * @return true if test passed without problems, false otherwise
	 */
	public static boolean testRemoveOnlyOneOccurrenceOfItem() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// add one item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

		String item = ShoppingCart.MARKET_ITEMS[0][0];

		count = ShoppingCart.remove(item, cart, count);

		// check that OccurrencesOf("Apples", cart, count) returns 1 after adding the
		// item with key 0
		if (ShoppingCart.occurrencesOf(0, cart, count) != 0) {
			System.out.println("Problem detected: After removing only one item with key 0 from the cart, "
					+ "OccurrencesOf to count how many of that item the cart contains should return 0. "
					+ "But, it was not the case.");
			testPassed = false;
		}

		return testPassed;
	}

	/**
	 * Checks that when only one attempt to remove an item present in the cart is
	 * made, multiple occurrence of that item is removed from the cart
	 * 
	 * @return true if test passed without problems, false otherwise
	 */
	public static boolean testRemoveMultipleOccurrenceOfItem() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// add two item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

		String item = ShoppingCart.MARKET_ITEMS[0][0];

		count = ShoppingCart.remove(item, cart, count);

		// check that OccurrencesOf("Apples", cart, count) returns 1 after adding the
		// item with key 0
		if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
			System.out.println("Problem detected: After removing only one item with key 0 from the cart, "
					+ "OccurrencesOf to count how many of that item the cart contains should return 1. "
					+ "But, it was not the case.");
			testPassed = false;
		}

		return testPassed;
	}

	/**
	 * Checks that when only one attempt to remove an item from an empty cart
	 * if the count returns 0
	 * 
	 * @return true if test passed without problems, false otherwise
	 */
	public static boolean testRemoveItemFromEmptyCart() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		String item = ShoppingCart.MARKET_ITEMS[0][0];

		count = ShoppingCart.remove(item, cart, count);

		// check that OccurrencesOf("Apples", cart, count) returns 1 after adding the
		// item with key 0
		if (count != 0) {
			System.out.println("Problem detected: After removing one item with key 0 from the empty cart, "
					+ "the count should return 0. But, it was not the case.");
			testPassed = false;
		}

		return testPassed;
	}
	
	/**
	 * Checks that remove does not make any change to count (number of items in the
	 * cart) when the user tries to remove an item not present within the cart
	 * 
	 * @return true if test passed without problems, false otherwise
	 */
	public static boolean testRemoveItemNotFoundInCart() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// add two item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

		// Try to remove an item which is not in shopping cart
		String item = ShoppingCart.MARKET_ITEMS[10][0];
		count = ShoppingCart.remove(item, cart, count);

		// Check if count changes, it should be still 2
		if (count != 2) {
			System.out.println("Problem detected: After removing only one item not in the cart, "
					+ "it should not make any change to count (number of items in the cart) "
					+ "But, it was not the case.");
			testPassed = false;
		}

		return testPassed;
	}

	public static boolean testGetSubTotalPrice() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// add two item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

		// Try to remove an item which is not in shopping cart
		String itemPrice = ShoppingCart.MARKET_ITEMS[0][1];
		double price = Double.valueOf(itemPrice.substring(1, itemPrice.length()));
		double expectPrice = price * 2;
		double subPrice = ShoppingCart.getSubTotalPrice(cart, count);

		// Check if count changes, it should be still 2
		if (subPrice != expectPrice) {
			System.out.println("Problem detected: The expect subtotal price should be: " + expectPrice
					+ ", but after testing your getSubTotalPrice(), the returned subtotal price is: " + subPrice + ".");
			testPassed = false;
		}

		return testPassed;
	}

	/**
	 * main method used to call the unit tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
				"testCountIncrementedAfterAddingOnlyOneItem(): " + testCountIncrementedAfterAddingOnlyOneItem());
		
		System.out.println("testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
		
		System.out.println("testRemoveOnlyOneOccurrenceOfItem(): " + testRemoveOnlyOneOccurrenceOfItem());
		
		System.out.println("testRemoveItemNotFoundInCart(): " + testRemoveItemNotFoundInCart());
		
		System.out.println("testRemoveMultipleOccurrenceOfItem(): " + testRemoveMultipleOccurrenceOfItem());
		
		System.out.println("testGetSubTotalPrice(): " + testGetSubTotalPrice());
		
		System.out.println(
				"testCountIncrementedAfterAddingmultipleItems(): " + testCountIncrementedAfterAddingmultipleItems());
		
		System.out.println("testRemoveItemFromEmptyCart(): " + testRemoveItemFromEmptyCart());
	}
}