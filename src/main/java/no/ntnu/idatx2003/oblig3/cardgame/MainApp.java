package no.ntnu.idatx2003.oblig3.cardgame;

public class MainApp {
  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    deck.dealHand(52);
    deck.dealHand(1);

  }
}

