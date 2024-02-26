package no.ntnu.idatx2003.oblig3.cardgame;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final char[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
  private PlayingCard[] deck;

  public DeckOfCards() {
    deck = new PlayingCard[52];
    int i = 0;
    for (char suit : suits) {
      for (char face : faces) {
        deck[i] = (new PlayingCard(suit, face));
        i++;
      }
    }
  }
}
