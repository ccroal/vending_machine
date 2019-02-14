import Products.Product;

import java.util.ArrayList;

public class Slot {

    private String code;
    private int price;
    private ArrayList<Product> product;
    private int capacity;


    public Slot(String code, int price){
        this.code = code;
        this.price = price;
        this.product = new ArrayList<Product>();
        this.capacity = 10;
    }

    public String getCode() {
        return this.code;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public int getCapacity() {
        return capacity;
    }

    public int productCount(){
        return this.product.size();
    }

    public void addProduct(Product product){
        if(productCount() < capacity) {
            this.product.add(product);
        }
    }

    public Product removeProduct(){
        return this.product.remove(0);
    }

    public void stockSlot(Product product){
        if(this.productCount() == 0) {
            addProduct(product);
        } else if (this.product.get(0).getBrand().equals(product.getBrand())){
            addProduct(product);
        }

    }

}
