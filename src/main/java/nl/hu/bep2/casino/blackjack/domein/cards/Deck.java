package nl.hu.bep2.casino.blackjack.domein.cards;

import java.util.ArrayList;
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
    }

    public List<Card> getCards() {
        return cards;
    }
}
// worden de kaarten verzameld en in een deck gestopd door te forloopen totdat
// er geen nieuwe kaart naam combies meer gemaakt kunnen worden
