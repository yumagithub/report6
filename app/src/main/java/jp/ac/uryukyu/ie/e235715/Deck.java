package jp.ac.uryukyu.ie.e235715;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * トランプの山札を表すクラス。
 * 山札は複数のカードを持ち、シャッフルやドローを行う。
 */
public class Deck {
    /**
     * 山札に含まれるカードのリスト。
     */
    private List<Card> cards;
    /**
     * カードが引かれた位置を示す。
     */
    private int drawIndex;

    /**
     * Deck クラスのコンストラクタ。
     * デッキの初期化とシャッフルを行う。
     */
    public Deck() {
        initializeDeck();
        shuffle();
        drawIndex = 0;
    }

    /**
     * カードを初期化するメソッド。
     * 各スートとランクのカードを生成し、デッキに追加する。
     */
    private void initializeDeck() {
        //カードを初期化
        cards = new ArrayList<>();

        // 各スートとランクのカードを生成し、デッキに追加
        String[] suits = {"ハート", "ダイヤ", "クラブ", "スペード"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "ジャック", "クイーン", "キング", "エース"};

        for (String suit : suits) {
            for (String rank : ranks) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    /**
    * デッキをシャッフルするメソッド。
    */
    public void shuffle() {
        //デッキをシャッフルする
        Collections.shuffle(cards);
        drawIndex = 0;
    }


    /**
     * デッキからカードを引くメソッド。
     * @return 引かれたカード
     * @throws IllegalStateException デッキが空の場合
     */
    public Card drawCard() {
        //デッキからカードを引く
        if (drawIndex >= cards.size()) {
            throw new IllegalStateException("デッキが空です。");
        }
        return cards.remove(0);
    }

    /**
     * まだ引かれていない残りのカード数を取得するメソッド。
     * @return 残りのカード数
     */
    public int getRemainingCards() {
        // まだ引かれていない残りのカード数を取得する
        return cards.size() - drawIndex;
    }
}
