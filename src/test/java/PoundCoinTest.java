import Coins.CoinType;
import Coins.PoundCoin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PoundCoinTest {

    PoundCoin poundCoin;

    @Before
    public void before(){
        poundCoin = new PoundCoin();
    }

    @Test
    public void hasType() {
        assertEquals(CoinType.ONEPOUND, poundCoin.getCoinType());
    }

    @Test
    public void hasValue() {
        assertEquals(100, poundCoin.getCoinValue());
    }
}
