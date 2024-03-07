package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

public class CardGameController {
  private Hand hand;
  private CardGameUI cardGameUI;

  public CardGameController(CardGameUI cardGameUI) {
    this.cardGameUI = cardGameUI;
    this.hand = new Hand();
  }

  public void dealHand() {
    this.hand = new Hand();
  }

  public ArrayList<PlayingCard> getHand() {
    return hand.getHand();
  }

  public void checkHand() {
    cardGameUI.setHandStrengthLabels("Sum", String.valueOf(hand.checkSumOfFaces()));
    cardGameUI.setHandStrengthLabels("Hearts", String.valueOf(hand.checkForHearts()));

    if (hand.checkForFlush()) {
      cardGameUI.setHandStrengthLabels("Flush", "Yes!");
    } else {
      cardGameUI.setHandStrengthLabels("Flush", "No :(");
    }

    if (hand.checkForQos()) {
      cardGameUI.setHandStrengthLabels("Queen of Spades", "Yes!");
    } else {
      cardGameUI.setHandStrengthLabels("Queen of Spades", "No :(");
    }
  }
}
