package nl.hu.bep2.casino.blackjack.domein.cards;

public class Main {
    public static void main(String[] args) {
        Hand hand = new Hand();

        hand.dealInitialCards();

        System.out.println("Remaining cards in the deck: " + hand.getCards());
        System.out.println("Remaining cards in the deck: " + hand.getCards().size());

        System.out.println("Player's initial cards: " + hand.getPlayerCards());

        System.out.println("Dealer's initial cards: " + hand.getDealerCards());
    }
}
//word verwijderd bij totaale oplevering nu alleen voor test redenen
