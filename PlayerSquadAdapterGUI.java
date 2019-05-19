package Vasek_FirstSemesterProject;


import java.awt.BasicStroke;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import javax.swing.*;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ButtonType;
import javax.swing.JToggleButton;
import javafx.application.Application;
import javafx.scene.control.RadioButton;

public class PlayerSquadAdapterGUI extends Application
{
  
   private VBox mainPane;
   
   
   private TabPane tabPane;
   private Tab allPlayersTab;
   private Tab changePlayersTab;
   private Tab allSquadsTab;
   
   private TextArea allPlayersArea;
   private ScrollPane allPlayersScrollPane;
   private TextArea allSquadsArea;
   private ScrollPane allSquadsScrollPane;
 
   private Button updatePlayer;
   private Button createNewPlayer;
   
   
   
   
   
   private VBox radioPane;
   private VBox allPlayersPane;
   private VBox allSquadsPane;
   private VBox changePlayerPane;
   
   
   private HBox changePlayerTopPane;
   private FlowPane comboPane;
   private Label name;
   private Label number;
   private Label position;
   private Label ifSuspended;
   private Label suspendedForMatches;
   private Label ifInjured;
   private GridPane changePlayerInputPane;
   private ComboBox<Player> playerBox;
   private TextField PlayerName;
   private TextField PlayerNumber;
   private TextField PlayerPosition;
   private JRadioButton IfSuspended;
   private TextField SuspendedForHowManyMatches;
   private RadioButton ifInjuredYes;
   private RadioButton ifInjuredNo;
   
   
   
   
   private MyActionListener listener;
   private MyTabListener tabListener;
   
  
   
   private PlayersSquadFileAdapter adapterPlayers;
   private PlayersSquadFileAdapter adapterSquads;




   
   public void start(Stage window)
   {
    window.setTitle("VIA Sport Management System");
    adapterPlayers = new PlayersSquadFileAdapter("C:\\Vasek\\players.bin");
    adapterSquads = new PlayersSquadFileAdapter("C:\\Vasek\\squads.bin");
    
    listener = new MyActionListener();
    tabListener = new MyTabListener();
    
    tabPane = new TabPane();
    tabPane.getSelectionModel().selectedItemProperty().addListener(tabListener);

      
    
    
    
      createNewPlayer=new Button("New Player");
      /*createNewPlayer.setOnAction(new MyActionListener());*/
      
      allPlayersTab = new Tab("All Players");
      allSquadsTab = new Tab("All Squads");
      changePlayersTab = new Tab("Change Players");
      
      allPlayersArea = new TextArea();
      allPlayersArea.setPrefRowCount(16);
      allPlayersArea.setPrefColumnCount(50);
      allPlayersArea.setEditable(false);
      
      allSquadsArea = new TextArea();
      allSquadsArea.setPrefRowCount(16);
      allSquadsArea.setPrefColumnCount(50);
      allSquadsArea.setEditable(false);
      
      allPlayersScrollPane = new ScrollPane(allPlayersArea);
      allPlayersScrollPane.setFitToWidth(true);
      allSquadsScrollPane = new ScrollPane(allSquadsArea);
      allSquadsScrollPane.setFitToWidth(true);
      
      allPlayersPane = new VBox(10);
      allPlayersPane.setAlignment(Pos.CENTER);
      allPlayersPane.getChildren().add(allPlayersScrollPane);
      allPlayersPane.getChildren().add(createNewPlayer);
      
      allSquadsPane = new VBox(10);
      allSquadsPane.setAlignment(Pos.CENTER);
      allSquadsPane.getChildren().add(allSquadsScrollPane);
      
      
  
      
 

      
      
 
      
      
      changePlayerPane = new VBox(20);
      changePlayerTopPane = new HBox(20);
      playerBox = new ComboBox<Player>();
      playerBox.setOnAction(listener);
      changePlayerInputPane=new GridPane();
      comboPane = new FlowPane();
      comboPane.setAlignment(Pos.BASELINE_RIGHT);
      comboPane.setPrefWidth(200);
      comboPane.getChildren().add(playerBox);
      updatePlayer=new Button("UpdatePlayer");
      updatePlayer.setOnAction(listener);
     
   
      
      
      
      name=new Label("Player Name");
      number=new Label("Player Number");;
      position=new Label("Player Position");
      ifSuspended=new Label("IfSuspended");
      suspendedForMatches=new Label("suspendedForMatches");
      ifInjured=new Label("ifInjured");
      
      
      PlayerName = new TextField();
      PlayerNumber = new TextField();
      PlayerNumber.setEditable(false);
      PlayerPosition = new TextField();
      SuspendedForHowManyMatches = new TextField();
      
      
      /*VBox radioPane = new VBox(10);*/
      VBox radioPane = new VBox();
    
      ToggleGroup ifInjuredGroup = new ToggleGroup();
      ifInjuredYes = new RadioButton("Injured-Yes");
      ifInjuredNo = new RadioButton("Injured-No");
      ifInjuredNo.setSelected(true);
      ifInjuredYes.setToggleGroup(ifInjuredGroup);
      ifInjuredNo.setToggleGroup(ifInjuredGroup);
      radioPane.getChildren().add(ifInjuredYes);
      radioPane.getChildren().add(ifInjuredNo);
  
    
      
     
      
      
     
      
      
      
    
      changePlayerInputPane.setHgap(5);
      changePlayerInputPane.setVgap(5);
      changePlayerInputPane.addRow(0, name, PlayerName);
      changePlayerInputPane.addRow(1, number, PlayerNumber);
      changePlayerInputPane.addRow(2, position, PlayerPosition);
      changePlayerTopPane.getChildren().add(changePlayerInputPane);
      changePlayerTopPane.getChildren().add(comboPane);
      changePlayerTopPane.getChildren().add(updatePlayer);
      changePlayerPane.getChildren().add(changePlayerTopPane);
      changePlayerPane.getChildren().add(radioPane);
      changePlayerPane.setAlignment(Pos.CENTER);
      
      
      
      allPlayersTab.setContent(allPlayersPane);
      allSquadsTab.setContent(allSquadsPane);
      changePlayersTab.setContent(changePlayerPane);
      
    
      tabPane.getTabs().add(allPlayersTab);
      tabPane.getTabs().add(allSquadsTab);
      tabPane.getTabs().add(changePlayersTab);
      
    
      
      /*menuBar = new MenuBar();*/


      
      
     
      
      mainPane = new VBox();
      /*mainPane.getChildren().add(menuBar);*/
      mainPane.getChildren().add(tabPane);
      mainPane.getChildren().add(allPlayersPane);
      mainPane.getChildren().add(allSquadsPane);
      mainPane.getChildren().add(changePlayerPane);
      
      
      
      Scene scene = new Scene(mainPane, 1100, 490);
      
      window.setScene(scene);
      window.setResizable(false);
      window.show();
   }
   
   private void updatePlayersArea()
   {
      ListOfPlayers players = adapterPlayers.getAllPlayers();
      allPlayersArea.setText(players.toString());
   }
   private void updateSquadsArea()
   {
      ListOfSquads squads = adapterSquads.getAllSquads();
      allSquadsArea.setText(squads.toString());
   }
   private void updatePlayerBox()
   {
      int currentIndex = playerBox.getSelectionModel().getSelectedIndex();
      playerBox.getItems().clear();

      ListOfPlayers players = adapterPlayers.getAllPlayers();
      for (int i = 0; i < players.size(); i++)
      {
         playerBox.getItems().add(players.get(i));
      }

      if (currentIndex == -1 && playerBox.getItems().size() > 0)
      {
         playerBox.getSelectionModel().select(0);
      }
      else
      {
         playerBox.getSelectionModel().select(currentIndex);
      }
   }
   
   
   private class MyTabListener implements ChangeListener<Tab>
   {
      public void changed(ObservableValue<? extends Tab> tab, Tab oldTab, Tab newTab)
      {
         if (newTab == allPlayersTab)
         {
            updatePlayersArea();
         }
         else if (newTab == allSquadsTab)
         {
            updateSquadsArea();
         }
         else if (newTab == changePlayersTab)
         {
            updatePlayerBox();
         }
      }
   }
   
 

   private class MyActionListener implements EventHandler<ActionEvent>
   {
      public void handle(ActionEvent e)
      {
         if (e.getSource() == createNewPlayer)
         {
            updatePlayersArea();
         }
         
         else if(e.getSource() == updatePlayer)
         {
           
            String playerName = PlayerName.getText(); 
            String playerNumber = PlayerNumber.getText();
            String playerPosition = PlayerPosition.getText();
            boolean ifInjured = ifInjuredYes.isSelected();
           
          

            adapterPlayers.changePlayer(playerName, playerNumber, playerPosition, ifInjured);
            updatePlayerBox();
            
         }
         
         else if(e.getSource() == playerBox)
         {
            Player temp = playerBox.getSelectionModel().getSelectedItem();

            if (temp != null)
            {
               PlayerName.setText(temp.getName());
               String toStringPlayerNumber = Integer.toString(temp.getNumber());
               PlayerNumber.setText(toStringPlayerNumber);
               PlayerPosition.setText(temp.getPosition());
               
               if(temp.getIfInjured()==true)
                  {
                  ifInjuredYes.setSelected(true);
                  }
               else if(temp.getIfInjured()==false)
                  {
                  ifInjuredNo.setSelected(true);
                  }
            }
            
         }
         

      }
   }
   
   public static void main(String[] args)
   {
      launch(args);

   }

}
