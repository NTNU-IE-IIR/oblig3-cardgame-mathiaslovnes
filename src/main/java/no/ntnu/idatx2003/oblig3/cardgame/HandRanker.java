package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;

public class HandRanker {

  public static boolean checkForFlush(ArrayList<PlayingCard> hand) {
    boolean flush = false;
    int noOfSameSuit = 1;
    for (int i = 0 ; i < 4 ; i++) {
    if(hand.get(i).getSuit() == hand.get(i+1).getSuit()) {
      noOfSameSuit++;
      if (noOfSameSuit == 5) {
        flush = true;
        }
      }
    }
    System.out.println(flush);
    return flush;
  }

  public static int checkSumOfFaces(ArrayList<PlayingCard> hand) {
    int sumOfFaces = 0;
    for (PlayingCard playingCard : hand) {
      sumOfFaces += playingCard.getFace();
    }
    System.out.println(sumOfFaces);
    return sumOfFaces;
  }

  public static String checkForHearts(ArrayList<PlayingCard> hand) {
    String hearts = "";
    for (PlayingCard card : hand) {
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
}