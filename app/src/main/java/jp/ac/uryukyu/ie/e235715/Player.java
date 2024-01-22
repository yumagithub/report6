package jp.ac.uryukyu.ie.e235715;

import java.util.List;

/**
 * プレイヤーを表すクラス。
 * プレイヤーは手札（Hand）を持ち、手札の合計値を計算したり新しいカードを手札に追加することができる。
 */
public class Player {
    
    /**
     * プレイヤーの手札を表す Hand クラスのインスタンス。
     */
    private Hand hand;

    /**
     * Player クラスのコンストラクタ。
     * プレイヤーの初期化を行い、手札を生成する。
     */
    public Player() {
        hand = new Hand();
    }

    /**
     * プレイヤーの手札を取得するメソッド。
     * @return プレイヤーの手札
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * 手札の合計値を取得するメソッド。
     * @return 手札の合計値
     */
    public int getHandTotal() {
        return hand.calculateTotal();
    }

    /**
     * 手札のカードリストを取得するメソッド。
     * @return 手札のカードリスト
     */
    public List<Card> getHandCards() {
        return hand.getCards();
    }

    /**
     * 手札にカードを追加するメソッド。
     * @param card 手札に追加するカード
     */
    public void addCardToHand(Card card) {
        hand.addCard(card);
    }
}

