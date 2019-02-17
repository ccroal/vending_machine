import Coins.*;
import Components.CoinInTray;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinInTrayTest {

    PoundCoin poundCoin;
    FiftyCoin fiftyCoin;
    TwentyCoin twentyCoin;
    TenCoin tenCoin;
    FiveCoin fiveCoin;
    TwoCoin twoCoin;
    OneCoin oneCoin;
    CoinInTray coinInTray;

    @Before
    public void before(){
        poundCoin = new PoundCoin();
        fiftyCoin = new FiftyCoin();
        twentyCoin = new TwentyCoin();
        tenCoin = new TenCoin();
        fiveCoin = new FiveCoin();
        twoCoin = new TwoCoin();
        oneCoin = new OneCoin();

        coinInTray = new CoinInTray();
    }

    @Test
    public void startsAtZero() {
        assertEquals(0, coinInTray.countCoinValue());
    }

    @Test
    public void testCoinValid(){
        coinInTray.checkValidity(poundCoin);
        assertEquals(1, coinInTray.countValidCoins());
        assertEquals(0, coinInTray.countReturnedCoins());
    }

    @Test
    public void testCoinInvalid(){
        coinInTray.checkValidity(twoCoin);
        assertEquals(1, coinInTray.countReturnedCoins());
        assertEquals(0, coinInTray.countValidCoins());
    }

    @Test
    public void testInsertCoinReturnsTotal(){
        int firstTotal = coinInTray.insertCoin(poundCoin);
        assertEquals(100, firstTotal);
        int secondTotal = coinInTray.insertCoin(fiftyCoin);
        assertEquals(150, secondTotal);
    }

    @Test
    public void testInsertCoinReturnsTotalInvalidCoin(){
        int firstTotal = coinInTray.insertCoin(poundCoin);
        assertEquals(100, firstTotal);
        int secondTotal = coinInTray.insertCoin(twoCoin);
        assertEquals(100, secondTotal);
        assertEquals(1, coinInTray.countReturnedCoins());
    }

    @Test
    public void testCanReturnCoins(){
        coinInTray.insertCoin(poundCoin);
        coinInTray.insertCoin(poundCoin);
        coinInTray.returnCoins();
        assertEquals(2, coinInTray.countReturnedCoins());
    }
}

