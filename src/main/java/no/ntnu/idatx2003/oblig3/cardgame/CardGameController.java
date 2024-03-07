package no.ntnu.idatx2003.oblig3.cardgame;

public class CardGameController {
  private Hand hand;
  private CardGameUI cardGameUI;

  public CardGameController(CardGameUI cardGameUI) {
    this.cardGameUI = cardGameUI;
    this.hand = new Hand();
  }

  public void dealHand() {
    this.cardGameUI.setCards(hand.dealHand());
  }

  public void checkHand() {
  }
}
