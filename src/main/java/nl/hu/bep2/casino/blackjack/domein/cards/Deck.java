package nl.hu.bep2.casino.blackjack.domein.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        generateDeck();
    }

    public static Deck full() {
        return new Deck();
    }

    private void generateDeck() {
        for (CardSuits suit : CardSuits.values()) {
            for (CardRank rank : CardRank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }


}

