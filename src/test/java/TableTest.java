import Restaurant.Table;
import org.junit.Before;
import org.junit.Test;

import Menu.Dish;
import Patronage.Customer;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 19/11/2017.
 */
import static org.junit.Assert.assertEquals;

public class TableTest {

        Table table;
        Customer customer;
        Customer customer2;
        Dish dish;
        Dish dish2;
        @Before
        public void before() {
            table = new Table();
            customer = new Customer();
            customer2 = new Customer();
            dish = new Dish("a dish", 10);
            dish2 = new Dish("a dish", 9);
        }
        @Test
        public void canAddPatron() {
            assertEquals(true, table.checkTableIsVacant());
            table.addToTable(customer);
            table.addToTable(customer);
            assertEquals(2, table.howBigIsTheParty());
        }
        @Test
        public void canRemovePatron() {
            assertEquals(true, table.checkTableIsVacant());
            table.addToTable(customer);
            table.partyLeaves();
            assertEquals(true, table.checkTableIsVacant());
        }
        @Test
        public void canGetBill() {
            assertEquals(true, table.checkTableIsVacant());
            table.addToTable(customer);
            customer.addToFoodOrder(dish);
            assertEquals(10,customer.getBill(),0.01);
            assertEquals(10, table.getTableTotal(),0.01);
            table.addToTable(customer);
            customer.addToFoodOrder(dish);
            assertEquals(20, table.getTableTotal(),0.01);
        }
        @Test
        public void canGoDutchOnBill() {
            assertEquals(true, table.checkTableIsVacant());
            table.addToTable(customer);
            table.addToTable(customer2);
            customer.addToFoodOrder(dish);
            customer2.addToFoodOrder(dish2);
            assertEquals(19, table.getTableTotal(),0.01);
            customer.setFunds(10);
            customer2.setFunds(10);
            table.splitBill();
            assertEquals(0.5, customer.getFunds(),0.01);
            assertEquals(0.5, customer2.getFunds(),0.01);
        }
        @Test
        public void canGoSplitBillIndividually() {
            assertEquals(true, table.checkTableIsVacant());
            table.addToTable(customer);
            table.addToTable(customer2);
            customer.addToFoodOrder(dish);
            customer2.addToFoodOrder(dish2);
            assertEquals(19, table.getTableTotal(), 0.01);
            customer.setFunds(10);
            customer2.setFunds(10);
            table.payIndividually();
            assertEquals(0, customer.getFunds(), 0.01);
            assertEquals(1, customer2.getFunds(), 0.01);
        }


}
