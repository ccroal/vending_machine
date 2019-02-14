import Coins.*;
import Components.CodeType;
import Components.CoinInTray;
import Components.Slot;
import Products.ColaProduct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {

    PoundCoin poundCoin;
    FiftyCoin fiftyCoin;
    TwentyCoin twentyCoin;
    TenCoin tenCoin;
    FiveCoin fiveCoin;
    TwoCoin twoCoin;
    OneCoin oneCoin;

    ColaProduct coke;
    Slot slot;

    VendingMachine vendingMachine;

    @Before
    public void before() {
        poundCoin = new PoundCoin();
        fiftyCoin = new FiftyCoin();
        twentyCoin = new TwentyCoin();
        tenCoin = new TenCoin();
        fiveCoin = new FiveCoin();
        twoCoin = new TwoCoin();
        oneCoin = new OneCoin();

        coke = new ColaProduct("Coke");
        slot = new Slot(CodeType.A1);

        vendingMachine = new VendingMachine();
        vendingMachine.vendSlotsPopulate();
    }


    @Test
    public void canPopulateWithSlots() {
        assertEquals(9, vendingMachine.countVendSlots());
    }

    @Test
    public void canAssignSlotPrice(){
        vendingMachine.setSlotPrice(CodeType.A1, 100);
        assertEquals(100, vendingMachine.getSlot(0).getPrice());
    }

    @Test
    public void canAddProductToSlot(){
        vendingMachine.addProductToSlot(CodeType.A1, coke);
        assertEquals(1, vendingMachine.getSlot(0).productCount());
    }

    @Test
    public void canFillEmptySlot() {
        vendingMachine.refilEmptySlot(CodeType.A1, coke);
        assertEquals(10, vendingMachine.getSlot(0).productCount());
    }
}
