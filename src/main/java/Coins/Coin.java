package  Coins;

public abstract class Coin {

    CoinType coinType;

    public Coin() {
        this.coinType = coinType;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public int getCoinValue(){
        return coinType.getValue();
    }
}
