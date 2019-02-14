import Products.ColaProduct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColaTest {

    ColaProduct colaProduct;

    @Test
    public void hasBrand() {
        colaProduct = new ColaProduct("Coke");
        assertEquals("Coke", colaProduct.getBrand());
    }


}
