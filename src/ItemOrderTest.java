/*
 * TCSS305 - Spring 2013
 * Assignment 2 - ShoppingCart - Crystal Miraflor
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Crystal Miraflor (mirafcry@uw.edu)
 * @version ver. 1.00
 *
 */
public class ItemOrderTest {

  //fields
  /**
   * Tolerance level for doubles.
   */
  private static final double TOLERANCE = .00001;
  
  /**
   * Array of ItemOrder objects to test.
   */
  private ItemOrder[] my_itemorders;
  
  /**
  * Array of Items.
  */
  private Item[] my_items;
  
  /**
   * Initial setup to test the ItemOrder
   * class.
   * 
   */
  @Before
  public void setUp() {
    my_items = new Item[] {
      new Item("BioShock 2", 60.00),
      new Item("Cool Pens", 1.25, 5, 3.75),
      new Item("Candy", 1.00, 3, 2.50)
    };
    
    my_itemorders = new ItemOrder[] {
      new ItemOrder(my_items[0], 2),
      new ItemOrder(my_items[1], 7),
      new ItemOrder(my_items[2], 3),
      new ItemOrder(my_items[2], 2)
    };
    
  }

  /**
   * Tests if the calculation for an
   * ItemOrder is correct.
   */
  @Test
  public void testCalculatePrice() {
    // 7 Cool Pens = 6.25
    assertEquals(6.25, my_itemorders[1].calculatePrice(), TOLERANCE);
    //2 Bioshock games = 120.00
    assertEquals(120.00, my_itemorders[0].calculatePrice(), TOLERANCE);
    //3 Candies = 2.50
    assertEquals(2.50, my_itemorders[2].calculatePrice(), TOLERANCE);
  }

  /**
   * Tests if the reference returned 
   * for an ItemOrder is correct.
   * Should all be the same.
   */
  @Test
  public void testGetItemSame() {
    assertSame("Test 1: Same", my_items[0], my_itemorders[0].getItem());
    assertSame("Test 2: Same", my_items[1], my_itemorders[1].getItem());
    assertSame("Test 3: Same", my_items[2], my_itemorders[2].getItem());
  }
  
  /**
   * Tests if the reference returned
   * for an ItemOrder is correct.
   * None are the same.
   */
  @Test
  public void testGetItemNotSame() {
    assertNotSame("Test 4: Not the same", my_items[0], my_itemorders[2].getItem());
    assertNotSame("Test 4: Not the same", my_items[2], my_itemorders[0].getItem());
    assertNotSame("Test 4: Not the same", my_items[1], my_itemorders[3].getItem());
  }
}
