package jp.ac.uryukyu.ie.e235715;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void testDeckDrawCard() {
        Deck deck = new Deck();
        Card card = deck.drawCard();
        assertNotNull(card);
        assertEquals(51, deck.getRemainingCards());

        // すべてのカードを引く
        for (int i = 0; i < 51; i++) {
            deck.drawCard();
        }

        // デッキが空なのでIllegalStateExceptionをスローするはず
        assertThrows(IllegalStateException.class, () -> {
            deck.drawCard();
        });    
    }

    @Test
    public void testDeckShuffle() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();

        // 両方のデッキを引いてシャッフル
        deck1.drawCard();
        deck2.drawCard();
        deck1.shuffle();
        deck2.shuffle();

        // シャッフルした後は順番が異なるはず
        assertNotEquals(deck1.toString(), deck2.toString());
    }
}

