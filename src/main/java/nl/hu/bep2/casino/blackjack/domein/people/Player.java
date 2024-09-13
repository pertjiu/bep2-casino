package nl.hu.bep2.casino.blackjack.domein.people;

import nl.hu.bep2.casino.blackjack.domein.cards.Card;
import nl.hu.bep2.casino.blackjack.domein.cards.CardRank;
import nl.hu.bep2.casino.blackjack.domein.cards.Hand;

import java.util.List;

public class Player {
    private Hand hand;
    private Choices lastAction;

    public Player() {
        this.hand = new Hand();
        this.lastAction = null;
        dealInitialCards();
    }

    private void dealInitialCards() {
        hand.dealInitialCards();
    }

    public void chooseAction(Choices action) {
        this.lastAction = action;
        switch (action) {
            case HIT:
                hit();
                break;
            case STAND:
                stand();
                break;
            case DOUBLE:
                doubleDown();
                break;
            case SURRENDER:
                break;
        }
    }
    private void hit() {
    Card card = hand.dealCard();
    hand.getPlayerCards().add(card);
    System.out.println("Player draws: " + card);
    }


    private void stand() {
        System.out.println("Player stands with total value: " + getHandValue());
    }


    private void doubleDown() {
        hit();
        stand();
    }

    public Choices getLastAction() {
        return lastAction;
    }

    public List<Card> getPlayerCards() {
        return hand.getPlayerCards();
    }

    public int getHandValue() {
        return calculateHandValue(hand.getPlayerCards());
    }

    public boolean hasBlackjack() {
        return getHandValue() == 21 && hand.getPlayerCards().size() == 2;
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
}
