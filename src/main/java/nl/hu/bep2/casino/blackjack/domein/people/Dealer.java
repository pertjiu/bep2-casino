package nl.hu.bep2.casino.blackjack.domein.people;

import nl.hu.bep2.casino.blackjack.domein.cards.Card;
import nl.hu.bep2.casino.blackjack.domein.cards.CardRank;
import nl.hu.bep2.casino.blackjack.domein.cards.Hand;

import java.util.List;

public class Dealer {
    private Hand hand;

    public Dealer() {
        this.hand = new Hand();
        dealInitialCards();
    }

    private void dealInitialCards(){
        hand.dealInitialCards();
    }


    public void play() {
        while (calculateHandValue(hand.getDealerCards()) < 17) {
            Card card = hand.dealCard();
            hand.getDealerCards().add(card);
            System.out.println("Dealer draws: " + card);
            try {
                Thread.sleep(2000); // Wait for 2 seconds
            } catch (InterruptedException e) {
                System.err.println("Sleep interrupted: " + e.getMessage());
            }
        }
    }

    private int calculateHandValue(List<Card> cards) {
        int totalValue = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int cardValue = card.getRank().getValue();
            totalValue += cardValue;

            if (card.getRank() == CardRank.ACE) {
                aceCount++;
            }
        }


        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10;
            aceCount--;
        }

        return totalValue;
    }

    public List<Card> getDealerCards() {
        return hand.getDealerCards();
    }

    public int getDealerHandValue() {
        return calculateHandValue(hand.getDealerCards());
    }

    public boolean hasBlackjack() {
        return getDealerHandValue() == 21 && hand.getDealerCards().size() == 2;
    }
}
