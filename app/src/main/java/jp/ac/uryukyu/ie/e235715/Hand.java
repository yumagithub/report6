package jp.ac.uryukyu.ie.e235715;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public List<Card> getCards(){
        return cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public int calcTotal(){
        int total = 0;

        for(Card card : cards){
            total += card.getValue();
        }
        return total;
    }

    public int calculateTotal() {
        int total = 0;

        for (Card card : cards) {
            total += card.getValue();
        }

        return total;
    }


}
