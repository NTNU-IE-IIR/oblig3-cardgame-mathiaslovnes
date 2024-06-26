package no.ntnu.idatx2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CardGameUI extends Application {

  private CardGameController controller;
  private Map<String, Label> handStrengthLabels;

  private ArrayList<ImageView> cardImageView;
  private FlowPane cardsPane;
  private Label handsSinceFlush;
  private Label Unluckiness;


  public void start(Stage stage) throws Exception {
    this.controller = new CardGameController(this);
    this.cardImageView = new ArrayList<>();
    this.handStrengthLabels = new HashMap<>();
    this.cardsPane = new FlowPane();
    fillCardPaneWithJokers();
    // fillCardPaneWithFlush();

    BorderPane rootNode = new BorderPane();
    Scene scene = new Scene(rootNode, 1500, 1000, Color.WHITE);
    scene.setFill(Color.PURPLE);
    rootNode.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));

    Image table = new Image("Table.jpg");
    Image qos = new Image("Qos.png");
    Image sum = new Image(("Sum.png"));
    Image heart = new Image(("Heart.png"));
    Image flush = new Image(("Flush.jpg"));

    stage.getIcons().add(table);

    ImageView tableView = new ImageView(table);
    tableView.setX(150);
    tableView.setY(-200);
    rootNode.setTop(null);

    ImageView qosView = new ImageView(qos);
    qosView.setX(100);
    qosView.setY(600);
    qosView.setFitHeight(100);
    qosView.setFitWidth(83);

    ImageView sumView = new ImageView(sum);
    sumView.setX(100);
    sumView.setY(500);
    sumView.setFitHeight(110);
    sumView.setFitWidth(110);

    ImageView heartView = new ImageView(heart);
    heartView.setX(250);
    heartView.setY(600);
    heartView.setFitHeight(100);
    heartView.setFitWidth(85);


    ImageView flushView = new ImageView(flush);
    flushView.setX(250);
    flushView.setY(500);
    flushView.setFitHeight(120);
    flushView.setFitWidth(90);


    VBox vBoxButtons = new VBox();
    vBoxButtons.setAlignment(Pos.CENTER_RIGHT);
    Button dealHand = new Button("Deal Hand");
    dealHand.setOnAction(event -> {
      controller.dealHand();
      createCardView(controller.getHand());
    });


    dealHand.setPrefSize(100, 50);
    Button checkHand = new Button("Check Hand");
    checkHand.setOnAction(event ->
        controller.checkHand());


    checkHand.setPrefSize(100, 50);
    vBoxButtons.setPadding(new Insets(20));
    vBoxButtons.setSpacing(20);
    vBoxButtons.getChildren().addAll(dealHand, checkHand);

    rootNode.setRight(vBoxButtons);




    GridPane gridPane = new GridPane();

    // Heart
    Label heartLabel = new Label("Hearts");
    handStrengthLabels.put("Hearts", heartLabel);
    heartLabel.setMaxSize(100, 15);
    heartLabel.setAlignment(Pos.BOTTOM_CENTER);

    // Flush
    Label flushLabel = new Label("Flush");
    handStrengthLabels.put("Flush", flushLabel);
    flushLabel.setMinSize(100, 15);
    flushLabel.setAlignment(Pos.BOTTOM_CENTER);

    // Sum
    Label sumLabel = new Label("Sum");
    handStrengthLabels.put("Sum", sumLabel);
    sumLabel.setMaxSize(100, 15);
    sumLabel.setAlignment(Pos.BOTTOM_CENTER);

    // Queen of spades
    Label qosLabel = new Label("Queen of spades");
    handStrengthLabels.put("Queen of Spades", qosLabel);
    qosLabel.setMaxSize(100, 15);
    qosLabel.setAlignment(Pos.BOTTOM_CENTER);

    gridPane.add(flushView, 0, 0);
    gridPane.add(flushLabel, 1, 0);
    gridPane.add(heartView, 0, 1);
    gridPane.add(heartLabel, 1, 1);
    gridPane.add(qosView, 2, 0);
    gridPane.add(qosLabel, 3, 0);
    gridPane.add(sumView, 2, 1);
    gridPane.add(sumLabel, 3, 1);




    cardsPane.setPrefSize(200, 200);
    cardsPane.setMaxHeight(200);

    rootNode.setCenter(cardsPane);
    cardsPane.setAlignment(Pos.CENTER);


    rootNode.setBottom(gridPane);
    gridPane.setAlignment(Pos.BOTTOM_CENTER);
    rootNode.getBottom().prefHeight(400);
    // rootNode.getRight().setStyle("-fx-background-color: Green");
    gridPane.setVgap(10);
    gridPane.setPadding(new Insets(10));


    stage.setTitle("Poker");
    stage.setScene(scene);
    stage.show();

  }

  private void fillCardPaneWithJokers() {
    for (int i = 0; i < 5; i++) {
      ImageView joker = new ImageView("cards_images/joker.png");
      joker.setFitHeight(300);
      joker.setFitWidth(200);
      cardsPane.getChildren().add(joker);
    }
  }

  private void fillCardPaneWithFlush() {

  }

  public void createCardView(ArrayList<PlayingCard> cards) {
    cardsPane.getChildren().clear();
    for (int i = 0; i < cards.size(); i++) {
      ImageView cardImageView = new ImageView("cards_images/" + cards.get(i).getAsString() + ".png");
      cardImageView.setFitHeight(300);
      cardImageView.setFitWidth(200);
      cardImageView.setPreserveRatio(true);
      cardsPane.getChildren().add(cardImageView);
    }
  }

  public void setHandStrengthLabels(String label, String value) {
    handStrengthLabels.get(label).setText(value);
  }

  public static void appMain(String[] args) {
    launch();
  }
}
