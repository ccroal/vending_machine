import Components.CodeType;
import Components.Slot;
import Products.ColaProduct;
import Products.CrispProduct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SlotTest {

    ColaProduct coke;
    Slot slot;

    @Before
    public void before(){
        coke = new ColaProduct("Coke");
        slot = new Slot(CodeType.A1);
        slot.assignPrice(100);
    }

    @Test
    public void hasCode() {
        assertEquals(CodeType.A1, slot.getCode());
    }

    @Test
    public void hasPrice(){
        assertEquals(100, slot.getPrice());
    }

    @Test
    public void hasCapacity() {
        assertEquals(10, slot.getCapacity());
    }

    @Test
    public void startsEmpty() {
        assertEquals(0, slot.productCount());
    }

    @Test
    public void canAddProduct() {
        slot.addProduct(coke);
        assertEquals(1, slot.productCount());
    }

    @Test
    public void canRemoveProduct(){
        slot.addProduct(coke);
        slot.removeProduct();
        assertEquals(0, slot.productCount());
    }

    @Test
    public void cannotOverStock() {
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        slot.stockSlot(coke);
        assertEquals(10, slot.productCount());
    }

    @Test
    public void cannotAddDifferentProductToAlreadyAssignedSLot() {
        CrispProduct crisps = new CrispProduct("Walkers");
        slot.stockSlot(coke);
        slot.stockSlot(crisps);
        assertEquals(1, slot.productCount());
    }
}
