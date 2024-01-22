package jp.ac.uryukyu.ie.e235715;

import java.util.List;

public class Player {
    private Hand hand;

    public Player(){
        hand = new Hand();
    }

    public Hand getHand(){
        return hand;
    }

    public int getHandTotal() {
        return hand.calculateTotal();
    }

    public void addCardToHand(Card card){
        hand.addCard(card);
    }

    public List<Card> getHandCards(){
        return hand.getCards();
    }
}
