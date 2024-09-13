package nl.hu.bep2.casino.blackjack.domein.Result;

import nl.hu.bep2.casino.blackjack.domein.people.Choices;
import nl.hu.bep2.casino.blackjack.domein.people.Dealer;
import nl.hu.bep2.casino.blackjack.domein.people.Player;


public class ResultsFunctions {

    public static Results determineResult(Player player, Dealer dealer) {
        int playerHandValue = player.getHandValue();
        int dealerHandValue = dealer.getDealerHandValue();

        boolean playerBlackjack = player.hasBlackjack();
        boolean dealerBlackjack = dealer.hasBlackjack();

        if (player.getLastAction() == Choices.SURRENDER) {
            return Results.SURRENDER;
        }

        if (playerHandValue > 21) {
            return Results.BUST;
        }

        if (playerBlackjack && dealerBlackjack) {
            return Results.PUSH;
        }

        if (playerBlackjack) {
            return Results.BLACKJACK;
        }

        if (dealerBlackjack) {
            return Results.LOST;
        }

        if (dealerHandValue > 21) {
            return Results.WON;
        }

        if (playerHandValue > dealerHandValue) {
            return Results.WON;
        } else if (playerHandValue < dealerHandValue) {
            return Results.LOST;
        } else {
            return Results.PUSH;
        }
    }
}
