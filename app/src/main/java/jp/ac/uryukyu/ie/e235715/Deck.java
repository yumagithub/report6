package jp.ac.uryukyu.ie.e235715;

import java.util.List;

import java.util.Collections;
import java.util.ArrayList;

public class Deck {
    private List<Card> cards;

    public Deck(){
        initializeDeck();
        shuffle();
    }

    public void initializeDeck(){
        cards = new ArrayList<>();
        String[] suits = {"ハート", "ダイヤ", "クラブ", "スペード"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "ジャック", "クイーン", "キング", "エース"};
    
        for(String suit : suits){
            for(String rank : ranks){
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        return cards.remove(0);
    }

}


