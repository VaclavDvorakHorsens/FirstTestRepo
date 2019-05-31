package application;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller 
{
   @FXML private Tab changePlayersTab;
   @FXML private Tab allSquadsTab;
   @FXML private Tab allPlayersTab;
   @FXML private Tab createPlayerTab;
   @FXML private ComboBox<String> playerBox;
   @FXML private TextArea allSquadsArea;
   @FXML private TextArea allPlayersArea;
   @FXML private Button updatePlayer;
   @FXML private Button deletePlayer;
   @FXML private Button createNewPlayer;
   @FXML private TextField PlayerName;
   @FXML private TextField forHowManyDays;
   @FXML private TextField PlayerNumber;
   @FXML private TextField PlayerPosition;
   @FXML private TextField createPlayerName;
   @FXML private TextField createPlayerNumber;
   @FXML private TextField createPlayerPosition;
   @FXML private TextField SuspendedForHowManyMatches;
   @FXML private RadioButton ifInjuredYes;
   @FXML private RadioButton ifInjuredNo;
   @FXML private CheckBox ifSuspended;
   @FXML private TabPane tabPane; 
   @FXML private Tab total;
   @FXML private MenuBar menuBar;
   @FXML private MenuItem close;
   
   private PlayersSquadFileAdapter adapterPlayers;
   private PlayersSquadFileAdapter adapterSquads;
   
   
 
   /**
    * no argument constructor which creates two instances for PlayersSquadFileAdapter class,
    * one for players and one for squads and sets their file paths
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public Controller()
   {
      adapterPlayers = new PlayersSquadFileAdapter("C:\\Vasek\\players.bin");
      adapterSquads = new PlayersSquadFileAdapter("C:\\Vasek\\squads.bin");
   }
   
   
   /**
    * updates allPlayersArea tab content, which is list of players
    * @author Vaclav Dvorak
    * @version 1.0
    */
  
   private void updatePlayersArea()
   {
      ListOfPlayers players = adapterPlayers.getAllPlayers();
      allPlayersArea.setText(players.toString());
   }
   
   /**
    * updates allSquadsArea tab content, which is list of squads
    * @author Vaclav Dvorak
    * @version 1.0
    */
   private void updateSquadsArea()
   {
      ListOfSquads squads = adapterSquads.getAllSquads();
      allSquadsArea.setText(squads.toString());
   }
   
   
   /**
    * shows actual players names in Combobox
    * @author Vaclav Dvorak
    * @version 1.0
    */
   private void updatePlayerBox()
   {
      playerBox.getItems().clear();

      ListOfPlayers players = adapterPlayers.getAllPlayers();
      ArrayList<String> PlayersNames = new ArrayList<String>();
         for (int i = 0; i < players.size(); i++)
         {
            PlayersNames.add(players.get(i).getName());
            playerBox.getItems().add(PlayersNames.get(i));
         } 
   }
   
   
   /**
    * Tab Listener class
    * @author Vaclav Dvorak
    * @version 1.0
    */
      public void MyTabListener(Event ev)
      {
         if (allPlayersTab.isSelected())
         {   
            updatePlayersArea();   
         }
         else if (allSquadsTab.isSelected())
         {
            updateSquadsArea();
         }
         else if (changePlayersTab.isSelected())
         {
            updatePlayerBox();
         }  
      }
  

      /**
       * Rest of the elements Listener class
       * @author Vaclav Dvorak
       * @version 1.0
       */
      public void MyActionListener(ActionEvent e)
      {
        if(e.getSource() == updatePlayer) //when SavingChanges of Player 
         {   
            String playerName = PlayerName.getText(); 
            String playerNumber = PlayerNumber.getText();
                  if(playerNumber.equals(""))
                  {
                  playerNumber="0";
                  }
            String playerPosition = PlayerPosition.getText();
            boolean ifInjured = ifInjuredYes.isSelected();
            boolean ifIsSuspended = ifSuspended.isSelected();
            String ForHowManyDays = SuspendedForHowManyMatches.getText();
                  if(ForHowManyDays.equals(""))
                  {
                     ForHowManyDays="0";
                  }
            
           
            if(adapterPlayers.comparePlayerNumber(playerNumber, playerName)==true)
            {
               final JPanel panel = new JPanel();
               JOptionPane.showMessageDialog(panel, "The Player Number has been already assigned to another player","Error", JOptionPane.ERROR_MESSAGE); 
            }
            else if(playerNumber.equals("0"))
            {
               final JPanel panel = new JPanel();
               JOptionPane.showMessageDialog(panel, "The Player Number cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
            }
            else
            {
            adapterPlayers.changePlayer(playerName, playerNumber, playerPosition, ifInjured, ifIsSuspended,ForHowManyDays);
            updatePlayerBox();
            }    
         }
         
         
      else if(e.getSource() == playerBox) //when selecting Player from combobox 
         {
            
         String temp = playerBox.getSelectionModel().getSelectedItem();
         Player playerTemp= new Player("tempName",10000001,"tempPosition");
            
         ListOfPlayers players = adapterPlayers.getAllPlayers();
         for(int i=0; i<players.size();i++)
         {
            if(players.get(i).getName().equals(temp))
            {
               playerTemp=players.get(i);
            }
         }
            
         if (temp != null)
            {
               PlayerName.setText(playerTemp.getName());
               String toStringPlayerNumber = Integer.toString(playerTemp.getNumber());
               PlayerNumber.setText(toStringPlayerNumber);
               PlayerPosition.setText(playerTemp.getPosition());
               String toStringSuspended = Integer.toString(playerTemp.getSuspendedForMatches());
               SuspendedForHowManyMatches.setText(toStringSuspended);
            if(playerTemp.getIfInjured()==true)
                     {
                     ifInjuredYes.setSelected(true);
                     }
            else if(playerTemp.getIfInjured()==false)
                     {
                     ifInjuredNo.setSelected(true);
                     }
            if(playerTemp.getIfSuspended()==true)
                  {
                     ifSuspended.setSelected(true);
                  }
            else if(playerTemp.getIfSuspended()==false)
                  {
                     ifSuspended.setSelected(false);
                  }
            }
         }
         
         
         else if(e.getSource() == deletePlayer)  //when deleting selecting Player from combobox 
         {
            int input = JOptionPane.showConfirmDialog(null,"Do you really want to delete the selected player?","Select", JOptionPane.YES_NO_OPTION);
            if(input==0)
               {
                String playerName = PlayerName.getText();  
                adapterPlayers.deletePlayer(playerName);     
                updatePlayerBox();
                PlayerName.setText(""); 
                PlayerPosition.setText("");
                PlayerNumber.setText("");
                ifInjuredYes.setSelected(false);
                ifSuspended.setSelected(false);
                SuspendedForHowManyMatches.setText("");
               }
         }
         
         else if (e.getSource() == createNewPlayer)//when creating new Player 
         {
            String createPlName = createPlayerName.getText(); 
            String createPlPosition = createPlayerPosition.getText();
            String createPlNumber = createPlayerNumber.getText();
                  if(createPlNumber.equals(""))
                  {
                  createPlNumber="0";
                  }
                  if(adapterPlayers.comparePlayerNumber(createPlNumber, createPlName)==true)
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Player Number has been already assigned to another player","Error", JOptionPane.ERROR_MESSAGE); 
                  }

                  else if(createPlName.equals(""))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Player Name cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  else if(createPlNumber.equals("0"))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Player Number cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  else if(createPlPosition.equals(""))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Player Position cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                 
                  else
                  {
                  final JPanel panel = new JPanel();
                  adapterPlayers.createNewPlayer(createPlName, createPlNumber, createPlPosition);
                  JOptionPane.showMessageDialog(panel, "The Player has been created","Confirmation", JOptionPane.INFORMATION_MESSAGE); 
      
                  } 
            } 

         else if (e.getSource() == close)  //when closing the application from MenuBar 
         {
            int input = JOptionPane.showConfirmDialog(null,"Do you really want to exit?","Select", JOptionPane.YES_NO_OPTION);
          
            if (input==0)
            {
               System.exit(0);
            }
         }

      }

 
   }

      

