package application;

import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
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
   @FXML private ComboBox<String> typeOfMatchBox;
   @FXML private ComboBox<String> playerToSquadBox;
   @FXML private TextArea allSquadsArea;
   @FXML private TextArea allPlayersArea;
   @FXML private TextArea allFieldPlayersSquadArea;
   @FXML private TextArea allBenchPlayersSquadArea;
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
   private Squad tempSquad = new Squad(1, "1.1.1900", "0:00", "matchType", "opponent",0,0);
   private JPanel panel = new JPanel();


   
   
   
   
 
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
    * shows matchType values in typeOfMatch Combobox
    * @author Vaclav Dvorak
    * @version 1.0
    */
   private void updateTypeOfMatchSquadBox()
   {
      typeOfMatchBox.getItems().clear();

      ArrayList <String> typeOfMatch = new ArrayList <String>();
      typeOfMatch.add("league");
      typeOfMatch.add("cup");
      typeOfMatch.add("friendly");
   
         for (int i = 0; i < typeOfMatch.size(); i++)
         {
            typeOfMatchBox.getItems().add(typeOfMatch.get(i));
         }    
   }
   
   
   
   /**
    * shows actual players names in Comboboxes in both EditPlayer and CreateSquad tabs
    * @author Vaclav Dvorak
    * @version 1.0
    */
   private void updatePlayerBox()
   {
      playerBox.getItems().clear();
      playerToSquadBox.getItems().clear();

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
      public void MyTabListener(Event ev)   // functionalities called while switching tabs
      {
       
         if (allPlayersTab.isSelected()) // if user switches to AllPlayers tab, then all players are shown
         {   
            updatePlayersArea();   
         }
         else if (createPlayerTab.isSelected())//if user switches to CreatePlayer tab, system clears form field values
         {
            createPlayerName.setText("");
            createPlayerNumber.setText("");
            createPlayerPosition.setText("");  
         }
         else if (changePlayersTab.isSelected()) //if user switches to EditPlayer tab,system updates combobox and clearing form field values
         {
            updatePlayerBox();
            PlayerName.setText("");
            PlayerNumber.setText("");
            PlayerPosition.setText("");
            SuspendedForHowManyMatches.setText("");
            ifInjuredNo.setSelected(true);
            ifSuspended.setSelected(false);
         } 
         else if (allSquadsTab.isSelected())// if user switches to AllSquads tab, then all squads are shown
         {
            updateSquadsArea();
         }
       
         else if (createSquadTab.isSelected())//if user switches to CreateSquad tab,system updates comboboxes and clears form field values
         {
            updateTypeOfMatchSquadBox();
            updatePlayerBox();
            createSquadIndex.setText("");
            createSquadDate.setText("");
            createSquadTime.setText("");
            createSquadOpponent.setText("");
            allFieldPlayersSquadArea.setText("");
            allBenchPlayersSquadArea.setText("");  
         }
       
      }
  

      /**
       * Rest of the elements Listener class
       * @author Vaclav Dvorak
       * @version 1.0
       */
      public void MyActionListener(ActionEvent e)
      {
        if(e.getSource() == updatePlayer) //when clicking on SaveChanges button on EditPlayer tab
         {   
            String playerName = PlayerName.getText(); 
            String playerNumber = PlayerNumber.getText();
                  if(playerNumber.equals("")) //so NullPointer exception would not occur later when calling methods for the value of this field
                  {
                  playerNumber="0";
                  }
            String playerPosition = PlayerPosition.getText();
            boolean ifInjured = ifInjuredYes.isSelected();
            boolean ifIsSuspended = ifSuspended.isSelected();
            String ForHowManyDays = SuspendedForHowManyMatches.getText();
                 if(ForHowManyDays.equals("")) //to keep number format
                  {
                     ForHowManyDays="0";
                  }
            
            //System checks, that Player Number has specific format and if not, shows validation
            if(adapterPlayers.comparePlayerNumber(playerNumber, playerName)==true)
            {  
              JOptionPane.showMessageDialog(panel, "The Player Number has been already assigned to another player","Error", JOptionPane.ERROR_MESSAGE);  
            }
            else if(playerNumber.equals("0"))
            {
               JOptionPane.showMessageDialog(panel, "The Player Number cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
            }
            
            
          //System sends data via class PlayersSquadFileAdapter object=adapterPlayers and it's method changePlayer() and then clears the form fields and boxes
            else
            {
               adapterPlayers.changePlayer(playerName, playerNumber, playerPosition, ifInjured, ifIsSuspended,ForHowManyDays);
               JOptionPane.showMessageDialog(panel, "The Player has been updated","Confirmation", JOptionPane.INFORMATION_MESSAGE); 
               PlayerName.setText("");
               PlayerNumber.setText("");
               PlayerPosition.setText("");
               SuspendedForHowManyMatches.setText("");
               ifInjuredNo.setSelected(true);
               ifSuspended.setSelected(false);
               updatePlayerBox();
            }    
         }
         
         
        
        
      else if(e.getSource() == playerBox) //when selecting Player from combobox on Edit Player tab
      {
            
         String temp = playerBox.getSelectionModel().getSelectedItem(); //takes currently picked value of combobox
         Player playerTemp= new Player("tempName",10000001,"tempPosition");//creates temporary Player
            
         ListOfPlayers players = adapterPlayers.getAllPlayers();//takes all existing players
         for(int i=0; i<players.size();i++)
         {
            if(players.get(i).getName().equals(temp))
            {
               playerTemp=players.get(i); //and compares them to selected player in combobox
            }
         }
            
         if (temp != null) //if player is selected in combobox, then his values are shown in the GUI 
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
         
         
         else if(e.getSource() == deletePlayer)  //when deleting selecting Player from combobox and clicking on DeletePlayer button on EditPlayer tab
         {
            int input = JOptionPane.showConfirmDialog(null,"Do you really want to delete the selected player?","Select", JOptionPane.YES_NO_OPTION);
            if(input==0)//if the dialog is confirmed, player is deleted and form fields are cleared
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
         
        
        
         else if (e.getSource() == createNewPlayer)//when clicking on CreateNewPlayer on CreatePlayer tab
         {
          //form field values are assigned to variables
            String createPlName = createPlayerName.getText(); 
            String createPlPosition = createPlayerPosition.getText();
            String createPlNumber = createPlayerNumber.getText();
                  if(createPlNumber.equals(""))
                  {
                  createPlNumber="0";//so NullPointer exception would not appear
                  }
                  
                //checks if values in form fields are valid
                  if(adapterPlayers.comparePlayerNumber(createPlNumber, createPlName)==true)
                  {
                     JOptionPane.showMessageDialog(panel, "The Player Number has been already assigned to another player","Error", JOptionPane.ERROR_MESSAGE); 
                  }

                  else if(createPlName.equals(""))
                  {
                     JOptionPane.showMessageDialog(panel, "The Player Name cannot be empty","Error", JOptionPane.ERROR_MESSAGE);  
                  } 
                  else if(createPlNumber.equals("0"))
                  {
                     JOptionPane.showMessageDialog(panel, "The Player Number cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  else if(createPlPosition.equals(""))
                  {
                     JOptionPane.showMessageDialog(panel, "The Player Position cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                 
                //System sends data via class PlayersSquadFileAdapter object=adapterPlayers and it's method createNewPlayer(), shows confirmation message and then clears the form fields
                  else
                  {
                     adapterPlayers.createNewPlayer(createPlName, createPlNumber, createPlPosition);
                     JOptionPane.showMessageDialog(panel, "The Player has been created","Confirmation", JOptionPane.INFORMATION_MESSAGE); 
                     createPlayerName.setText("");
                     createPlayerNumber.setText("");
                     createPlayerPosition.setText("");
                  } 
            } 
        
        
        
         else if (e.getSource() == createNewSquad)//when clicking on CreateNewSquad button on CreateSquad tab
         {
            //form field values are assigned to variables
            
            String createSqMatchDate = createSquadDate.getText(); 
            String createSqmatchTime = createSquadTime.getText();
            String createSqMatchOpponent = createSquadOpponent.getText();
            String createSqMatchIndex= createSquadIndex.getText();
            String createSqTypeMatch = typeOfMatchBox.getValue();
            int fieldPlayers=tempSquad.getFieldPlayers();
            int benchPlayers=tempSquad.getBenchPlayers();
                  if(typeOfMatchBox.getValue()==null)
                  {
                     createSqTypeMatch=""; //to avoid Null pointer exception
                  }
            
                  //checks if form field data are valid
                  else if(createSqMatchDate.equals(""))
                  {
                     JOptionPane.showMessageDialog(panel, "The Match Date cannot be empty","Error", JOptionPane.ERROR_MESSAGE);
                  }
                  else if(createSqmatchTime.equals(""))
                  {
                     JOptionPane.showMessageDialog(panel, "The Match Time cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }

                  else if(createSqMatchOpponent.equals(""))
                  {
                     JOptionPane.showMessageDialog(panel, "The Match opponent cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  else if(createSqMatchIndex.equals(""))
                  {
                     JOptionPane.showMessageDialog(panel, "The Match Number cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  else if(createSqTypeMatch.equals(""))
                  {
                     JOptionPane.showMessageDialog(panel, "The Match Type cannot be empty","Error", JOptionPane.ERROR_MESSAGE); 
                  }
                  
                  //System sends data via class PlayersSquadFileAdapter object=adapterSquads and it's method createNewSquad(), shows confirmation message
                  
                  else
                  {
                     adapterSquads.createNewSquad(createSqMatchDate, createSqmatchTime, createSqMatchOpponent,createSqMatchIndex,createSqTypeMatch,fieldPlayers,benchPlayers);
                     JOptionPane.showMessageDialog(panel, "The Squad has been created","Confirmation", JOptionPane.INFORMATION_MESSAGE); 
                  } 
         }     
                  
                  
                
        else if(e.getSource() == playerToSquadBox) //when add players from AddPlayer combobox to Squad on CreateSquad tab
               {
                     
                  String temp = playerToSquadBox.getSelectionModel().getSelectedItem();//takes currently picked value of combobox
                  Player playerTemp= new Player("tempName",10000001,"tempPosition");//creates temporary Player
                  ListOfPlayers players = adapterPlayers.getAllPlayers(); //gets all existing players
                  
                  
                //takes form fields values and assign them to temporary Squad 
                  tempSquad.setIndex(Integer.parseInt(createSquadIndex.getText()));
                  tempSquad.setDate(createSquadDate.getText());
                  tempSquad.setTime(createSquadTime.getText());
                  tempSquad.setOpponent(createSquadOpponent.getText());
                  tempSquad.setMatchType(typeOfMatchBox.getValue());
                  
                  if(typeOfMatchBox.getValue()==null)  //checks that typeOfMatch has been selected 
                  {
                   
                     final JPanel panel = new JPanel();
                     JOptionPane.showMessageDialog(panel, "select Type of Match first","Error", JOptionPane.ERROR_MESSAGE); 
                   
                  }
                
                  else //if player has been selected in combobox, then confirmation message is shown
                  {
                
                    if (temp != null)
                     {  
                        int input = JOptionPane.showConfirmDialog(null,"Do you really want to add player to the squad?","Select", JOptionPane.YES_NO_OPTION);
                        
                        for(int i=0; i<players.size();i++) //checks for all existing players and if there is a name match, assigns it to temporary player
                           {
                           if(players.get(i).getName().contains(temp))
                           {
                              playerTemp=players.get(i);
                          
                           }
                           }
                           
                        
                     
                        if(input==0) //if confirmation message has been answered=YES
                           {
                           
                           if(allFieldPlayersSquadArea.getText().contains(playerTemp.getName())) //if player is already assigned to the squad
                              {
                                 JOptionPane.showMessageDialog(panel, "The Player is already on the list","Error", JOptionPane.ERROR_MESSAGE); 
      
                              }
                           else if(playerTemp.getIfSuspended()==true) //if player is suspended
                              {
                              JOptionPane.showMessageDialog(panel, "The Player is Suspended","Error", JOptionPane.ERROR_MESSAGE);
                            
                              }
                           
                           else if(tempSquad.isTeamFull()==true) //if squad is already full
                           {
                              tempSquad.setIsSquadFull(true);  
                              JOptionPane.showMessageDialog(panel, "Too many players","Error", JOptionPane.ERROR_MESSAGE);  
                           }
                           
                           else if(tempSquad.isTeamFull()==false)//if squad is not full, chosen player from combobox is assigned to either field players
                         
                              {
                              if(tempSquad.getFieldPlayers()<=10 && tempSquad.getBenchPlayers()==0)
                                 {
                                 tempSquad.addPlayers(playerTemp);
                                 allFieldPlayersSquadArea.appendText(playerTemp.toString()+"\n");
                               
                                 }
                              else//or to bench players
                             
                                 {
                                    tempSquad.addPlayers(playerTemp);
                                    allBenchPlayersSquadArea.appendText(playerTemp.toString()+"\n");
                                 }
                             }

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

    

