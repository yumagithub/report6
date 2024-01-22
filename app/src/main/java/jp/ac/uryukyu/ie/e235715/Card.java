package jp.ac.uryukyu.ie.e235715;

public class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit(){
        return suit;
    }

    public String getRank(){
        return rank;
    }

    public int getValue() {
        // カードの点数を取得するメソッド（エースは1または11、それ以外は数字のランクに対応）
        switch (rank) {
            case "2", "3", "4", "5", "6", "7", "8", "9", "10":
                return Integer.parseInt(rank);

            case "ジャック":
            case "クイーン":
            case "キング":
                return 10;

            case "エース":
                //デフォルトは11とする
                return 11;  

            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return suit + "の" + rank;
    }

}
