import Components.CodeType;
import Components.CoinInTray;
import Components.Slot;
import Products.ColaProduct;
import Products.Product;

import java.util.ArrayList;

public class VendingMachine {

    CoinInTray coinInTray;
    ArrayList<Slot> vendSlots;

    public VendingMachine(){
        this.coinInTray = new CoinInTray();
        this.vendSlots = new ArrayList<Slot>();
    }

    public void vendSlotsPopulate(){
        for(CodeType codeType: CodeType.values()){
            Slot slot = new Slot(codeType);
            this.vendSlots.add(slot);
        }
    }

    public Slot getSlot(int index){
        return this.vendSlots.get(index);
    }

    public int countVendSlots(){
        return this.vendSlots.size();
    }

    public Slot findSlotByCode(CodeType code){
        for (Slot slot : this.vendSlots){
            if (slot.getCode() == code){
                return slot;
            }
        }
        return null;
    }

    public void setSlotPrice(CodeType code, int price){
        Slot slotFound = findSlotByCode(code);
        slotFound.assignPrice(price);

    }

    public void addProductToSlot(CodeType code, Product product) {
        Slot slotFound = findSlotByCode(code);
        slotFound.addProduct(product);
    }

    public void refilEmptySlot(CodeType code, Product product){
        Slot slotFount = findSlotByCode(code);

        for(int i = 0; i < slotFount.getCapacity(); ++i){
            slotFount.addProduct(product);
        }
    }
}
