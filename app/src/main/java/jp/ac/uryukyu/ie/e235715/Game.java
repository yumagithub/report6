package jp.ac.uryukyu.ie.e235715;

import java.util.Scanner;

public class Game {
    
    private Player player;
    private Player dealer;
    private Deck deck;

    public Game(){
        player = new Player();
        dealer = new Player();
        deck = new Deck();
    }

    public void start(){
        
        dealInitialCards();

        playerTurn();

        dealerTurn();

        displayResults();

    }

    public void dealInitialCards(){
            player.addCardToHand(deck.drawCard());
            dealer.addCardToHand(deck.drawCard());
            player.addCardToHand(deck.drawCard());
            dealer.addCardToHand(deck.drawCard());

            displayHands();
    }

    private void playerTurn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("カードを引く場合は '1'、スタンドする場合は '2' を入力してください: ");
        String input = scanner.nextLine().toLowerCase();

        if(input.equals("1")){
            player.addCardToHand(deck.drawCard());
            displayHands();

            if(player.getHandTotal() > 21){
                System.out.println("バーストしました");
            }

        }else if(input.equals("2")){    
        }
    }

    private void dealerTurn(){
        while (dealer.getHandTotal() < 17) {
            dealer.addCardToHand(deck.drawCard());            
        }
    }

    private void displayHands() {
        System.out.println("\nプレイヤーの手札: " + player.getHandCards() + " (合計: " + player.getHandTotal() + ")");
        System.out.println("\nディーラーの手札: " + dealer.getHandCards() + " (合計: " + dealer.getHandTotal() + ")\n");
    }

    private void displayResults(){
        
        int playerTotal = player.getHandTotal();
        int dealerTotal = dealer.getHandTotal();

        if(playerTotal > dealerTotal){
            System.out.println("ディーラーの勝利！");
        } else if(dealerTotal > playerTotal){
            System.out.println("ディーラーの勝利！");
        } else{
            System.out.println("引き分け");
        }
    }
}
