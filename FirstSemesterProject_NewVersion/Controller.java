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
   @FXML private Tab createSquadTab;
   @FXML private ComboBox<String> playerBox;
   @FXML private ComboBox<String> squadBox;
   @FXML private ComboBox<String> playerToSquadBox;
   @FXML private TextArea allSquadsArea;
   @FXML private TextArea allPlayersArea;
   @FXML private TextArea allPlayersSquadArea;
   @FXML private Button updatePlayer;
   @FXML private Button deletePlayer;
   @FXML private Button createNewPlayer;
   @FXML private Button createNewSquad;

   @FXML private TextField PlayerName;
   @FXML private TextField forHowManyDays;
   @FXML private TextField PlayerNumber;
   @FXML private TextField PlayerPosition;
   @FXML private TextField createPlayerName;
   @FXML private TextField createPlayerNumber;
   @FXML private TextField createPlayerPosition;
   @FXML private TextField SuspendedForHowManyMatches;
   @FXML private TextField createSquadIndex;
   @FXML private TextField createSquadDate;
   @FXML private TextField createSquadTime;
   @FXML private TextField createSquadOpponent;
   @FXML private RadioButton ifInjuredYes;
   @FXML private RadioButton ifInjuredNo;
   @FXML private CheckBox ifSuspended;
   @FXML private TabPane tabPane; 
   @FXML private Tab total;
   @FXML private MenuBar menuBar;
   @FXML private MenuItem close;
   
   private PlayersSquadFileAdapter adapterPlayers;
   private PlayersSquadFileAdapter adapterSquads;
   private Squad tempSquad = new Squad(1, "1.1.1900", "0:00", "matchType", "opponent");
   
   
 
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

   
   private void updateSquadBox()
   {
      squadBox.getItems().clear();

      ArrayList <String> typeOfMatch = new ArrayList <String>();
      typeOfMatch.add("league");
      typeOfMatch.add("cup");
      typeOfMatch.add("friendly");
   
         for (int i = 0; i < typeOfMatch.size(); i++)
         {
            squadBox.getItems().add(typeOfMatch.get(i));
         } 
   }
   
   
   private void updatePlayerBox()
   {
      playerBox.getItems().clear();

      ListOfPlayers players = adapterPlayers.getAllPlayers();
      ArrayList<String> PlayersNames = new ArrayList<String>();
         for (int i = 0; i < players.size(); i++)
         {
            PlayersNames.add(players.get(i).getName());
            playerBox.getItems().add(PlayersNames.get(i));
            playerToSquadBox.getItems().add(PlayersNames.get(i));
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
         else if (createSquadTab.isSelected())
         {
            updateSquadBox();
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
         /*Squad tempSquad = new Squad(1, "1.1.1900", "0:00", "matchType", "opponent");*/
         
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
        
        
        
         else if (e.getSource() == createNewSquad)//when creating new Squad
         {
            String createSqMatchDate = createSquadDate.getText(); 
            String createSqmatchTime = createSquadTime.getText();
            String createSqMatchOpponent = createSquadOpponent.getText();
            String createSqMatchIndex= createSquadIndex.getText();
            String createSqTypeMatch = squadBox.getValue();
                  if(squadBox.getValue()==null)
                  {
                     createSqTypeMatch="";
                  }
            
                  if(createSqMatchDate.equals(""))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Match Date cannot be empty","Error", JOptionPane.ERROR_MESSAGE);
                  }
                  if(createSqmatchTime.equals(""))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Match Time cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }

                  if(createSqMatchOpponent.equals(""))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Match opponent cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  if(createSqMatchIndex.equals(""))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Match Number cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  if(createSqTypeMatch.equals(""))
                  {
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "The Match Type cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  else
                  {
                     final JPanel panel = new JPanel();
                     adapterSquads.createNewSquad(createSqMatchDate, createSqmatchTime, createSqMatchOpponent,createSqMatchIndex,createSqTypeMatch);
                     JOptionPane.showMessageDialog(panel, "The Squad has been created","Confirmation", JOptionPane.INFORMATION_MESSAGE); 
                  } 
         }     
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
                  
        else if(e.getSource() == playerToSquadBox) //when add Player from combobox to Squad
               {
                     
                  String temp = playerToSquadBox.getSelectionModel().getSelectedItem();
                  Player playerTemp= new Player("tempName",10000001,"tempPosition");
                  ListOfPlayers players = adapterPlayers.getAllPlayers();
                  
                  
                  tempSquad.setIndex(Integer.parseInt(createSquadIndex.getText()));
                  tempSquad.setDate(createSquadDate.getText());
                  tempSquad.setTime(createSquadTime.getText());
                  tempSquad.setOpponent(createSquadOpponent.getText());
                  tempSquad.setMatchType(squadBox.getValue());
                  
                  if(squadBox.getValue()==null)
                  {
                   
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "select Type of Match first","Error", JOptionPane.ERROR_MESSAGE); 
                   
                  }
                
                  else 
                  {
                
                    if (temp != null)
                     {  
                        int input = JOptionPane.showConfirmDialog(null,"Do you really want to add player to the squad?","Select", JOptionPane.YES_NO_OPTION);
                        
                        for(int i=0; i<players.size();i++)
                           {
                           if(players.get(i).getName().contains(temp))
                           {
                              playerTemp=players.get(i);
                          
                           }
                           }
                           
                        
                     
                        if(input==0)
                           {
                           
                           if(allPlayersSquadArea.getText().contains(playerTemp.getName()))
                              {
                                 final JPanel panel = new JPanel();
                                 JOptionPane.showMessageDialog(panel, "The Player is already on the list","Error", JOptionPane.ERROR_MESSAGE); 
      
                              }
                           else if(playerTemp.getIfSuspended()==true)
                              {
                              final JPanel panel = new JPanel();
                              JOptionPane.showMessageDialog(panel, "The Player is Suspended","Error", JOptionPane.ERROR_MESSAGE);  
                              }
                           
                           
                           else if(tempSquad.addPlayers(playerTemp)==false)
                         
                              {
                              tempSquad.addPlayers(playerTemp);
                              allPlayersSquadArea.appendText(playerTemp.toString()+"\n"); 
                             
                              }
                           else if(tempSquad.addPlayers(playerTemp)==true)
                              {
                                 final JPanel panel = new JPanel();
                                 JOptionPane.showMessageDialog(panel, "Too many players","Error", JOptionPane.ERROR_MESSAGE);  
                               
                              }
                           System.out.print(tempSquad.toString());
                        
                          }
                     
                       }
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

    

