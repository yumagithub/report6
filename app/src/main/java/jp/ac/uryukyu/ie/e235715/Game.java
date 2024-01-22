package jp.ac.uryukyu.ie.e235715;

import java.util.Scanner;

/**
 * ブラックジャックのゲームを管理するクラス。
 * ゲームの進行や結果表示などを担当する。
 */
public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;

    /**
     * Gameクラスのコンストラクタ。
     * ゲームの初期化を行う。
     */
    public Game() {
        deck = new Deck();
        player = new Player();
        dealer = new Player();
    }

    /**
     * ブラックジャックのゲームを開始するメソッド。
     * 初回のカードの配布からプレイヤーとディーラーのターン、結果の表示まで行う。
     */
    public void start() {
        System.out.println("ブラックジャックを開始します。");

        // 初回のカードを配る
        dealInitialCards();

        // プレイヤーのターン
        playerTurn();

        // ディーラーのターン
        dealerTurn();

        // ゲーム結果を表示
        displayResults();
    }

    private void dealInitialCards() {
        System.out.println("カードを配ります。");
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
        dealer.addCardToHand(deck.drawCard());

        // 手札を表示
        displayHands(true);
    }

    private void playerTurn() {
        try(Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("カードを引く場合は '1'、スタンドする場合は '2' を入力してください: ");
                String input = scanner.nextLine().toLowerCase();
    
                if (input.equals("1")) {
                    // プレイヤーがカードを引く
                    player.addCardToHand(deck.drawCard());
                    displayHands(true);
    
                    // バーストしたら終了
                    if (player.getHandTotal() > 21) {
                        System.out.println("バーストしました。");
                        break;
                    }
                } else if (input.equals("2")) {
                    // プレイヤーがスタンドする
                    break;
                } else {
                    System.out.println("無効な入力です。");
                }
            }
        }
    }

    private void dealerTurn() {
        // ディーラーは17以上になるまでカードを引く
        while (dealer.getHandTotal() < 17) {
            dealer.addCardToHand(deck.drawCard());
        }

        // 手札を表示
        displayHands(false);
    }

    private void displayHands(boolean showAllCards) {
        System.out.println("\nプレイヤーの手札: " + player.getHandCards() + " (合計: " + player.getHandTotal() + ")");
        System.out.println("\nディーラーの手札: " + (showAllCards ? dealer.getHandCards() : dealer.getHandCards().subList(0, 1)) +
                " (合計: " + dealer.getHandTotal() + ")\n");
    }

    private void displayResults() {
        System.out.println("\n結果を表示します。");

        // プレイヤーとディーラーの手札を表示
        displayHands(true);

        // 勝敗判定
        int playerTotal = player.getHandTotal();
        int dealerTotal = dealer.getHandTotal();

        if (playerTotal > 21 || (dealerTotal <= 21 && dealerTotal >= playerTotal)) {
            System.out.println("ディーラーの勝利！");
        } else if (dealerTotal > 21 || (playerTotal <= 21 && playerTotal > dealerTotal)) {
            System.out.println("プレイヤーの勝利！");
        } else {
            System.out.println("引き分け");
        }
    }
}
