package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

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

  public boolean checkForFlush() {
    boolean flush = false;
    int noOfSameSuit = 1;
    for (int i = 0 ; i < 4 ; i++) {
    if(this.hand.get(i).getSuit() == this.hand.get(i+1).getSuit()) {
      noOfSameSuit++;
      }
    }
    if (noOfSameSuit == 5) {
      flush = true;
    }
    System.out.println(flush);
    return flush;
  }

  public int checkSumOfFaces() {
    int sumOfFaces = 0;
    for (PlayingCard playingCard : this.hand) {
      sumOfFaces += playingCard.getFace();
    }
    System.out.println(sumOfFaces);
    return sumOfFaces;
  }

  public String checkForHearts() {
    String hearts = "";
    for (PlayingCard card : this.hand) {
      char h = 'H';
      if (card.getSuit() == h) {
        hearts = hearts.concat(card.getAsString()) + " ";
      }
    }

    if (hearts.isBlank()) {
      hearts = "No Hearts";
    }

    return hearts;
  }

  public boolean checkForQos() {
    boolean QueenOfSpades = false;
    for (PlayingCard playingCard : this.hand) {
      if (playingCard.getAsString().equals("S12")) {
        QueenOfSpades = true;
      }
    }

    return QueenOfSpades;
  }
}