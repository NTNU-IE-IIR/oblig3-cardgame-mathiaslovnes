package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class Hand {

  private DeckOfCards deck;
  private ArrayList<PlayingCard> hand;

  public Hand() {
    deck = new DeckOfCards();

    hand = deck.dealHand(5);
  }

  public ArrayList<PlayingCard> getHand() {
    return this.hand;
  }

  public boolean checkForFlush2() {
    boolean flush = false;
    int noOfSameSuit = 1;
    for (int i = 0; i < 4; i++) {
      if (this.hand.get(i).getSuit() == this.hand.get(i + 1).getSuit()) {
        noOfSameSuit++;
      }
    }
    if (noOfSameSuit == 5) {
      flush = true;
    }
    return flush;
  }

  public boolean checkForFlush() {
    return this.hand.stream()
        .map(PlayingCard::getSuit)
        .distinct()
        .count() == 1;
  }

  public int checkSumOfFaces() {
    return this.hand.stream()
        .map(PlayingCard::getFace)
        .reduce(0, Integer::sum);
  }

  public String checkForHearts() {
    return this.hand.stream()
        .filter(c -> c.getSuit() == 'H')
        .map(PlayingCard::getAsString)
        .collect(Collectors.joining(", "));
  }

  public boolean checkForQos() {
    return this.hand.stream()
        .anyMatch(c -> c.getSuit() == 'S' && c.getFace() == 12);
  }

}