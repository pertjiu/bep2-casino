package nl.hu.bep2.casino.blackjack.domein.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand {
    private List<Card> cards;
    private List<Card> playerCards = new ArrayList<>();
    private List<Card> dealerCards = new ArrayList<>();
    private static final Random random = new Random();

    public Hand() {
        Deck deck = Deck.full();
        this.cards = deck.getCards();
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck to deal.");
        }
        return cards.remove(random.nextInt(cards.size()));
    }

    public void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            playerCards.add(dealCard());
            dealerCards.add(dealCard());
        }
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
// worden de kaarten randomly uitgedeelt aan de speler en dealer