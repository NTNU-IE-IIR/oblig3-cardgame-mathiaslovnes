package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

public class MainApp {
  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    ArrayList<PlayingCard> hand = deck.dealHand(5);
    HandRanker.checkSumOfFaces(hand);
    HandRanker.checkForFlush(hand);
    System.out.println(HandRanker.checkForHearts(hand));
  }
}

