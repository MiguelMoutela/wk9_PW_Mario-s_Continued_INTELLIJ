import Bar.Bar;
import Bar.BarItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BarTest {
    Bar bar;
    BarItem coke;

    @Before
    public void before() {
        bar = new Bar();
        coke = new BarItem("derp",1,10);
    }
    @Test
    public void canAddToBarArray(){
        bar.addToBar(coke);
        assertEquals(1, bar.getSize());
    }
    @Test
    public void canRemoveFromBarArray(){
        bar.addToBar(coke);
        assertEquals(1, bar.getSize());
        bar.takeFromBar(coke);
        assertEquals(0, bar.getSize());
    }
    @Test
    public void canCheckAmountInBarArray(){
        bar.addToBar(coke);
        assertEquals(10, bar.checkAmount(coke));
    }
    @Test
    public void canDecreaseQuantityOfaGivenBarItemInTheArray(){
        bar.addToBar(coke);
        assertEquals(10, bar.checkAmount(coke));
        bar.decreaseQuantity(coke,2);
        assertEquals(8, bar.checkAmount(coke));

    }
}
