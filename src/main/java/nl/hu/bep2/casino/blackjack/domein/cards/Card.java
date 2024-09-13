package nl.hu.bep2.casino.blackjack.domein.cards;

public class Card {
    private final CardSuits suit;
    private final CardRank rank;

    public Card(CardSuits suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuits getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return getRank()+ " OF "+  getSuit();
    }
}


