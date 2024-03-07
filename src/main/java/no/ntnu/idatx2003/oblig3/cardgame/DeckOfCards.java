package no.ntnu.idatx2003.oblig3.cardgame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random;

public class DeckOfCards {
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
  private ArrayList<PlayingCard> deck;
  Random rand;

  public DeckOfCards() {
    deck = new ArrayList<>();
    rand = new Random();
    for (char suit : suits) {
      for (int face : faces) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  public ArrayList<PlayingCard> dealHand(int n) {
    if (n > deck.size()) {
      throw new IllegalArgumentException("No more cards left in the deck");
    }

    ArrayList<PlayingCard> dealtHand = new ArrayList<>();
    for (int i = 0 ; i < n ; i++) {
      PlayingCard playingCard = deck.get(rand.nextInt(0, deck.size()));
      dealtHand.add(playingCard);
      deck.remove(playingCard);
      System.out.println(playingCard.getAsString());
    }
    return dealtHand;
  }



}
