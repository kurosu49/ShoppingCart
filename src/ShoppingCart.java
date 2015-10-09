/*
 * TCSS305 - Spring 2013
 * Assignment 2 - Shopping Cart - Crystal Miraflor
 * 
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * An object representation of a customer's
 * shopping cart. Contains store information about the 
 * customer's overall purchase.
 * 
 * @author Crystal Miraflor (mirafcry@uw.edu)
 * @version ver. 1.00
 *
 */
public class ShoppingCart {
  
  //fields
  
  /**
   * The price that the shopping cart total must be greater 
   * than for a membership discount.
   */
  private static final double MINIMUM_TOTAL = 20.00; 
  
  /**
   * The membership discount.
   */
  private static final double MEMBERSHIP_DISCOUNT = 0.9;
  
  /**
   * The list of items in the ShoppingCart.
   */
  private final Set<ItemOrder> my_shoppingcart;
  
  /**
   * Membership of the customer.
   */
  private boolean my_membership;
  
  /**
   * Creates an empty shopping cart.
   */
  public ShoppingCart() {
    my_shoppingcart = new HashSet<ItemOrder>();
    my_membership = false;
    
  }
  
  /**
   * Adds an order to the shopping cart, replacing
   * any previous order for an equivalent item with 
   * the new order.
   * 
   * @param the_order The customer order
   * 
   */
  public void add(final ItemOrder the_order) {
    final Iterator<ItemOrder> itr = my_shoppingcart.iterator();
    while (itr.hasNext()) {
      final ItemOrder shoppingcart_order = itr.next();
      if (shoppingcart_order.getItem().equals(the_order.getItem())) {
        itr.remove();
      }
    }
    my_shoppingcart.add(the_order);
    
  }
  
  /**
   * Sets whether or not the customer of this
   * shopping cart has a store membership.
   * 
   * @param the_value True if they have a membership,
   * or false if otherwise.
   * 
   */
  public void setMembership(final boolean the_value) {
    if (the_value) {
      my_membership = true;
    } else {
      my_membership = false;
    }
  }
  
  /**
   * Calculates the overall total of the entire cart.
   * 
   * @return The total price of the cart.
   */
  public double calculateTotal() {
    double total = 0.0;
    final Iterator<ItemOrder> itr = my_shoppingcart.iterator();
    while (itr.hasNext()) {
      total += itr.next().calculatePrice();
    }
    if (my_membership && total > MINIMUM_TOTAL) {
      total *= MEMBERSHIP_DISCOUNT;
    }
    return total;
  }

}
