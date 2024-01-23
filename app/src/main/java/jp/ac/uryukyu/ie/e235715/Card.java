package jp.ac.uryukyu.ie.e235715;

/**
 * トランプのカードを表すクラス。
 * 各カードはスート（ハート、ダイヤ、クラブ、スペード）とランク（2 から 10、ジャック、クイーン、キング、エース）を持つ。
 */
public class Card {
    /**
     * スートを表す文字列。
     */
    private String suit; 
    
    /**
     * カードのランクを表す文字列。
     */
    private String rank;
    
    /**
     * Card クラスのコンストラクタ。
     * @param suit カードのスート
     * @param rank カードのランク
     */
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * スートを取得するメソッド。
     * @return カードのスート
     */
    public String getSuit() {
        return suit;
    }

    /**
     * ランクを取得するメソッド。
     * @return カードのランク
     */
    public String getRank() {
        return rank;
    }

    /**
     * カードの点数を取得するメソッド。
     * エースは1または11、それ以外は数字のランクに対応。
     * @return カードの点数
     * @throws IllegalArgumentException 無効なカードの数字の場合
     */
    public int getValue() {
        switch (rank) {
            case "1","2", "3", "4", "5", "6", "7", "8", "9", "10":
                return Integer.parseInt(rank);

            case "ジャック":
            case "クイーン":
            case "キング":
                return 10;

            case "エース":
                //デフォルトは11とする
                return 11;  

            default:
                throw new IllegalArgumentException("無効なカードの数字: " + rank);
        }
    }

     /**
     * カードの実際の値を設定するメソッド。
     * このメソッドは内部でのみ使用する。
     * @param value 設定する値
     * @throws IllegalArgumentException 無効なカードの数字の場合
     */
    private void setValue(int value) {
        switch (rank) {
            case "2", "3", "4", "5", "6", "7", "8", "9", "10":
                this.rank = String.valueOf(value);
                break;
            case "エース":
                this.rank = (value == 1) ? "1" : "11";
                break;
            default:
                throw new IllegalArgumentException("無効なカードの数字: " + rank);
        }
    }
    
    /**
     * カードのエースの値を1に変更するメソッド。
     * エースでない場合は何も行わない。
     */
    public void setAceValueToOne() {
        // エースの値を1に変更する
        if ("エース".equals(rank)) {
            setValue(1);
        }
    }

    /**
     * カードの文字列表現を返すメソッド。
     * @return カードの文字列表現
     */
    @Override
    public String toString() {
        return suit + "の" + rank;
    }
}
