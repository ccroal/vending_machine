package Products;

public abstract class Product {

    private String brand;

    public Product(String brand){
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
