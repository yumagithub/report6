package jp.ac.uryukyu.ie.e235715;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCardGetValue() {
        Card card = new Card("ハート", "エース");
        assertEquals(11, card.getValue());

        card = new Card("ダイヤ", "ジャック");
        assertEquals(10, card.getValue());

        card = new Card("スペード", "2");
        assertEquals(2, card.getValue());
    }

    @Test
    public void testSetAceValueToOne() {
        Card card = new Card("クラブ", "エース");
        card.setAceValueToOne();
        assertEquals(1, card.getValue());
    }
}

