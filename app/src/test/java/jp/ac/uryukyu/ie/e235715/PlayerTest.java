package jp.ac.uryukyu.ie.e235715;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void testPlayerAddCardToHand() {
        Player player = new Player();
        Card card1 = new Card("ハート", "エース");
        Card card2 = new Card("ダイアモンド", "10");
        Card card3 = new Card("スペード", "キング");

        //エースなので11になるはず
        player.addCardToHand(card1);
        assertEquals(11, player.getHandTotal());

        //11＋10で21になるなず
        player.addCardToHand(card2);
        assertEquals(21, player.getHandTotal());

        //エースが1になり、1＋10＋10で21になるはず
        player.addCardToHand(card3);
        assertEquals(21,player.getHandTotal());
    }
}

