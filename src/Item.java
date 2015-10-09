/*
 * TCSS305 - Spring 2013
 * Assignment 2 - Shopping Cart - Crystal Miraflor
 * 
 */

import java.text.NumberFormat;
import java.util.Objects;

/**
 * An object representation of items. 
 * Stores information about individual items.
 * 
 * @author Crystal Miraflor (mirafcry@uw.edu)
 * @version ver. 1.00
 *
 */
public final class Item {

  //fields
  
  /**
   * The default bulk quantity of the item.
   */
  private static final int DEFAULT_BULK = 0;
  
  /**
   * The default bulk quantity price of the item.
   */
  
  private static final double DEFAULT_BULK_PRICE = 0.0;
  
  /**
   * The number formatter for item prices.
   */
  private NumberFormat my_nf;
  
  /**
   * The item name.
   */
  private String my_name;
  
  /**
   * The item price.
   */
  private double my_price;
  
  /**
   * The bulk quantity of the item.
   */
  private int my_bulk_quantity;
  
  /**
   * The bulk quantity price of the item.
   */
  private double my_bulk_price;
  
  /**
   * Constructs an item with a single-item
   * price, a bulk quantity, and a bulk price.
   * 
   * @param the_name  Name of item assigned.
   * @param the_price Single price of the item assigned.
   * @param the_bulk_quantity Bulk quantity of item assigned.
   * @param the_bulk_price  Bulk price of the item assigned.
   * 
   */
  public Item(final String the_name, final double the_price, final int the_bulk_quantity, 
              final double the_bulk_price) {
    my_name = the_name;
    my_price = the_price;
    my_bulk_quantity = the_bulk_quantity;
    my_bulk_price = the_bulk_price;
    my_nf = NumberFormat.getCurrencyInstance();
    
  }
  
  /**
   * Constructs an item with only a single-item price.
   * 
   * @param the_name  Name of the item.
   * @param the_price Single price of the item.
   * 
   */
  public Item(final String the_name, final double the_price) {
    this(the_name, the_price, DEFAULT_BULK, DEFAULT_BULK_PRICE);
    
  }
  
  /**
   * Calculates the total price of an item based on the
   * quantity passed in the parameter.
   * 
   * @param the_quantity  The amount of the item wanted.
   * @return The calculated price for an item depending on the
   * quantity desired.
   * 
   */
  public double calculatePriceFor(final int the_quantity) {
    double calculated_price = 0.0;
    if (the_quantity >= my_bulk_quantity && my_bulk_price != DEFAULT_BULK_PRICE
        && my_bulk_quantity != DEFAULT_BULK) {
      final int bulk = the_quantity / my_bulk_quantity;
      final int remainder = the_quantity % my_bulk_quantity;
      calculated_price =  (bulk * my_bulk_price) + (remainder * my_price);
    } else {
      calculated_price = the_quantity * my_price;
    }
    
    return calculated_price;
    
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(my_name);
    sb.append(", ");
    sb.append(my_nf.format(my_price));
    if (my_bulk_quantity != DEFAULT_BULK && my_bulk_price != DEFAULT_BULK_PRICE) {
      sb.append(" (");
      sb.append(my_bulk_quantity);
      sb.append(" for ");
      sb.append(my_nf.format(my_bulk_price));
      sb.append(")");
    }
    return sb.toString();
    
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object the_other) {
    //CHECK AND FIX
    boolean result = false;
    if (this == the_other) {
      result = true;
    } else if ((the_other != null) && (the_other.getClass() == getClass())) {
    // cast the_other to the correct type
      final Item other = (Item) the_other;
      if (my_name.equals(other.my_name) && my_price == other.my_price && my_bulk_quantity 
          == other.my_bulk_quantity && my_bulk_price == other.my_bulk_price) {
        result = true;
      } else {
        result = false;
      }
    }
    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    
    return Objects.hash(my_name, my_price, my_bulk_quantity, my_bulk_price);
    
  }
}
