package jp.ac.uryukyu.ie.e235715;

import java.util.ArrayList;
import java.util.List;

/**
 * プレイヤーとディーラーの手札を表すクラス。
 * 手札は複数のカードから構成され、合計値の計算や新しいカードの追加が可能。
 */
public class Hand {
    
    /**
     * 手札に含まれるカードのリスト。
     */
    private List<Card> cards;

    /**
     * Hand クラスのコンストラクタ。
     * 手札の初期化を行う。
     */
    public Hand() {
        cards = new ArrayList<>();
    }

     /**
     * 手札にカードを追加するメソッド。
     * @param card 追加するカード
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * 手札の合計値を計算するメソッド。
     * エースがある場合、合計が21を超えない範囲でエースを1として扱う。
     * @return 手札を合計した値
     */
    public int calculateTotal() {
        // 手札の合計を計算するメソッド
        int total = 0;
        int aceCount = 0;  // エースの数を保持

        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank().equals("エース")) {
                aceCount++;
            }
        }

        // エースの処理: エースがある場合、合計が21を超えない範囲でエースを1として扱う
        while (aceCount > 0 && total > 21) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    /**
     * 手札のカードリストを取得するメソッド。
     * @return 手札のカードリスト
     */
    public List<Card> getCards() {
        return cards;
    }
}
