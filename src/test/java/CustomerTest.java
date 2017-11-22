import Bar.BarItem;
import Menu.Dish;
import Patronage.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CustomerTest {
    Customer customer;
    Dish dish;
    BarItem barItem;
    @Before
    public void before() {
        customer = new Customer();
        dish = new Dish("a dish", 10);
        dish = new Dish("another dish", 10);
        barItem = new BarItem(1,1);
    }
    @Test
    public void canGetAndSetFunds() {
        customer.setFunds(100);
        assertEquals(100, customer.getFunds(), 0.01);
    }
    @Test
    public void canOrderAndGetBill() {
        customer.addToFoodOrder(dish);
        customer.addToDrinkOrder(barItem);
        assertEquals(11, customer.getBill(),0.01);
    }
    @Test
    public void canPaybill() {
        customer.addToFoodOrder(dish);
        assertEquals(10, customer.getBill(),0.01);
        customer.setFunds(100);
        customer.payBill(customer.getBill());
        assertEquals(90, customer.getFunds(),0.01);
    }
    @Test
    public void canGetFoodOrder(){
        assertEquals(0,customer.getFoodOrderSize());
        assertEquals(0,customer.getDrinkOrderSize());
        customer.addToFoodOrder(dish);
        customer.addToDrinkOrder(barItem);

    }
    @Test
    public void canGetToDrinkOrder(){
        assertEquals(0,customer.getDrinkOrderSize());
        customer.addToDrinkOrder(barItem);
        assertNotNull(customer.getDrinksOrder());
    }
}
