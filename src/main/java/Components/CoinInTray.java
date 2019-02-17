package Components;

import Coins.Coin;

import java.util.ArrayList;

public class CoinInTray {

    private ArrayList<Coin> validCoins;
    private ArrayList<Coin> returnedCoins;

    public CoinInTray(){
        this.validCoins = new ArrayList<Coin>();
        this.returnedCoins = new ArrayList<Coin>();
    }

    public int countValidCoins(){
        return this.validCoins.size();
    }

    public int countReturnedCoins(){
        return this.returnedCoins.size();
    }

    public int countCoinValue(){
        int total = 0;
        for(Coin coin : this.validCoins){
            total += coin.getCoinValue();
        }
        return total;
    }


    public void checkValidity(Coin coin){
        if (coin.getCoinValue() >= 10){
            this.validCoins.add(coin);
        } else {
            this.returnedCoins.add(coin);
        }
    }

    public int insertCoin(Coin coin){
        checkValidity(coin);
        int total = countCoinValue();
        return total;
    }

    public void returnCoins(){
        for (Coin coin : this.validCoins){
            this.returnedCoins.add(coin);
        }
    }
}
