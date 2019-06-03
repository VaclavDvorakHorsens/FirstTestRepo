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
   @FXML private Tab editSquadsTab;
   @FXML private ComboBox<String> playerBox;
   @FXML private ComboBox<String> typeOfMatchBox;
   @FXML private ComboBox<String> typeOfMatchBoxEdit;
   @FXML private ComboBox<String> playerToSquadBox;
   @FXML private ComboBox<String> squadBox;
   @FXML private ComboBox<String> addSquadFieldPlayer;
   @FXML private ComboBox<String> deleteSquadPlayer;
   @FXML private TextArea allSquadsArea;
   @FXML private TextArea allPlayersArea;
   @FXML private TextArea allFieldPlayersSquadArea;
   @FXML private TextArea allBenchPlayersSquadArea;
   @FXML private Button updatePlayer;
   @FXML private Button deletePlayer;
   @FXML private Button updateSquad;
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
   @FXML private TextField SquadIndex;
   @FXML private TextField SquadDate;
   @FXML private TextField SquadTime;
   @FXML private TextField SquadOpponent;
   @FXML private TextField SquadMatchType;
   @FXML private TextArea SquadFieldPlayers;
   @FXML private TextArea SquadBenchPlayers;
   @FXML private RadioButton ifInjuredYes;
   @FXML private RadioButton ifInjuredNo;
   @FXML private CheckBox ifSuspended;
   @FXML private TabPane tabPane; 
   @FXML private Tab total;
   @FXML private MenuBar menuBar;
   @FXML private MenuItem close;
   
   private PlayersSquadFileAdapter adapterPlayers;
   private PlayersSquadFileAdapter adapterSquads;
   private Squad tempSquad = new Squad(100000000, "1.1.1900", "0:00", "matchType", "opponent",0,0);
   private Squad tempSquad1 = new Squad(100000001, "1.1.1900", "0:00", "matchType", "opponent",0,0);
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
      typeOfMatchBoxEdit.getItems().clear();

      ArrayList <String> typeOfMatch = new ArrayList <String>();
      typeOfMatch.add("league");
      typeOfMatch.add("cup");
      typeOfMatch.add("friendly");
   
         for (int i = 0; i < typeOfMatch.size(); i++)
         {
            typeOfMatchBox.getItems().add(typeOfMatch.get(i));
            typeOfMatchBoxEdit.getItems().add(typeOfMatch.get(i));
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
      addSquadFieldPlayer.getItems().clear();
      deleteSquadPlayer.getItems().clear();

      ListOfPlayers players = adapterPlayers.getAllPlayers();
      ArrayList<String> PlayersNames = new ArrayList<String>();
         for (int i = 0; i < players.size(); i++)
         {
            PlayersNames.add(players.get(i).getName());
            playerBox.getItems().add(PlayersNames.get(i));
            playerToSquadBox.getItems().add(PlayersNames.get(i));
            addSquadFieldPlayer.getItems().add(PlayersNames.get(i));
            deleteSquadPlayer.getItems().add(PlayersNames.get(i));
         } 
   }
   
   /**
    * shows actual squad names in Combobox in EditSquad tab
    * @author Raman
    * @version 1.0
    */
   
   private void updateSquadBox()
   {
      squadBox.getItems().clear();
      
      ListOfSquads squads = adapterSquads.getAllSquads();
      ArrayList<String> SquadsNames = new ArrayList<String>();
         for (int i = 0; i < squads.size(); i++)
         {
            SquadsNames.add(squads.get(i).getDate());
            squadBox.getItems().add(SquadsNames.get(i));
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
         else if (editSquadsTab.isSelected()) //if user switches to EditSquad tab,system updates combobox and clearing form field values
         {
            SquadIndex.setText("");
            SquadDate.setText("");
            SquadTime.setText("");
            SquadOpponent.setText("");
            SquadFieldPlayers.setText("");
            SquadBenchPlayers.setText("");
            updateSquadBox();
            updatePlayerBox();
            updateTypeOfMatchSquadBox();
         }
       
      }
  

      /**
       * Rest of the elements Listener class
       * @author Vaclav Dvorak, Ramanpreet Singh, Jose Alejandro, Alejandra Letica
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
         Player playerTemp= new Player("tempName",10000001,"tempPosition");//creates temporary Player for the loop below
            
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
        
        
        
//      <---------------------------------------------Raman's Work----------------------------------------------------------->

        
        
        if(e.getSource() == updateSquad) //when clicking on SaveChanges button on EditSquad tab
        {   
           String squadIndex = SquadIndex.getText(); 
           String squadDate = SquadDate.getText();
           String squadTime = SquadTime.getText();
           String squadOpponent = SquadOpponent.getText();
           String squadMatchType = typeOfMatchBoxEdit.getValue();
                 

                
                    adapterSquads.changeSquads(squadIndex, squadDate, squadTime, squadOpponent, squadMatchType);
                    JOptionPane.showMessageDialog(panel, "The Squad has been updated","Confirmation", JOptionPane.INFORMATION_MESSAGE); 
                    SquadIndex.setText("");
                    SquadDate.setText("");
                    SquadTime.setText("");
                    SquadOpponent.setText("");
                    SquadFieldPlayers.setText("");
                    SquadBenchPlayers.setText("");
                    updateSquadBox();
                    updateTypeOfMatchSquadBox();
              
                 
        }
     
        else if(e.getSource() == squadBox) //when selecting Squad from combobox on Edit Squad tab
        {
              
           String temp = squadBox.getSelectionModel().getSelectedItem(); //takes currently picked value of combobox
           Squad squadTemp= new Squad(10000001,"31.12.2999","23:59","friendly","tempOpponent",0,0);//creates temporary Squad
              
           ListOfSquads squads = adapterSquads.getAllSquads();//takes all existing squadss
           for(int i=0; i<squads.size();i++)
           {
              if(squads.get(i).getDate().equals(temp))
              {
                 squadTemp=squads.get(i); //and compares them to selected squad in combobox
              }
           }
              
           if (temp != null) //if a squad is selected in combobox, then its values are shown in the GUI 
              {
                 String toStringSquadIndex = Integer.toString(squadTemp.getIndex());
                 SquadIndex.setText(toStringSquadIndex);
                 SquadDate.setText(squadTemp.getDate());
                 SquadTime.setText(squadTemp.getTime());
                 SquadOpponent.setText(squadTemp.getOpponent());
                 typeOfMatchBoxEdit.setValue(squadTemp.getMatchType());
                 String toStringSquadFieldPlayers = Integer.toString(squadTemp.getFieldPlayers());
                 /*SquadFieldPlayers.setText(toStringSquadFieldPlayers);*/
                 String toStringSquadBenchPlayers = Integer.toString(squadTemp.getBenchPlayers());
                 SquadBenchPlayers.setText(squadTemp.getSquadBenchPlayerstoString());
                 SquadFieldPlayers.setText(squadTemp.getSquadFieldPlayerstoString());
               
                 
              }
        }
   
       
        
//        <---------------------------------------------Raman's Work----------------------------------------------------------->
       
           
           
        
//      <---------------------------------------------Alejandra's Work----------------------------------------------------------->
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
        
//      <---------------------------------------------Raman's Work----------------------------------------------------------->
        
        
        
//      <---------------------------------------------Jose's Work----------------------------------------------------------->
        
         else if (e.getSource() == createNewSquad)//when clicking on CreateNewSquad button on CreateSquad tab
         {
            //form field values are assigned to variables
            
            String createSqMatchDate = createSquadDate.getText(); 
            String createSqmatchTime = createSquadTime.getText();
            String createSqMatchOpponent = createSquadOpponent.getText();
            String createSqMatchIndex= createSquadIndex.getText();
                  if(createSqMatchIndex.equals(""))
                  {
                     createSqMatchIndex="0"; 
                     JOptionPane.showMessageDialog(panel, "The Squad Number can not be empty","Error", JOptionPane.ERROR_MESSAGE);  
                     
                  }
            String createSqTypeMatch = typeOfMatchBox.getValue();
            int fieldPlayers=tempSquad.getFieldPlayers();
            int benchPlayers=tempSquad.getBenchPlayers();
            ArrayList<Player> squadPlayers=tempSquad.getAllSquadPlayers();
                  if(typeOfMatchBox.getValue()==null)
                  {
                     createSqTypeMatch=""; //to avoid Null pointer exception
                  }
                  if(adapterSquads.compareSquadNumber(createSqMatchIndex)==true)
                  {  
                    JOptionPane.showMessageDialog(panel, "The Squad Number has been already assigned to another squad","Error", JOptionPane.ERROR_MESSAGE);  
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
                     adapterSquads.createNewSquad(createSqMatchDate, createSqmatchTime, createSqMatchOpponent,createSqMatchIndex,createSqTypeMatch,fieldPlayers,benchPlayers,squadPlayers);
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
                           else if(playerTemp.getIfSuspended()==true && (typeOfMatchBox.getValue().contains("cup") || typeOfMatchBox.getValue().contains("league"))) //if player is suspended
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
               
             
        

        else if(e.getSource() == addSquadFieldPlayer) //when add players from AddPlayer combobox to Squad on CreateSquad tab
        {
        
           String temp = addSquadFieldPlayer.getSelectionModel().getSelectedItem();//takes currently picked value of combobox
           Player playerTemp= new Player("tempName",10000001,"tempPosition");//creates temporary Player
           ListOfPlayers players = adapterPlayers.getAllPlayers(); //gets all existing players
           ListOfSquads squads = adapterSquads.getAllSquads();//gets all existing squads
           
         //takes form fields values and assign them to temporary Squad 
           tempSquad.setIndex(Integer.parseInt(SquadIndex.getText()));
           tempSquad.setDate(SquadDate.getText());
           tempSquad.setTime(SquadTime.getText());
           tempSquad.setOpponent(SquadOpponent.getText());
           tempSquad.setMatchType(typeOfMatchBoxEdit.getValue());
           
           
         //gets the squad and its current players  
           
           tempSquad1 = squads.getSquad(Integer.parseInt(SquadIndex.getText()));
           ArrayList<Player> tempSquad1players=tempSquad1.getAllSquadPlayers();
           
           if(typeOfMatchBoxEdit.getValue()==null)  //checks that typeOfMatch has been selected 
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
                    if(players.get(i).getName().equals(addSquadFieldPlayer.getValue()))
                    {
                       playerTemp=players.get(i);
                   
                    }
                    }
                    
                 
              
                 if(input==0) //if confirmation message has been answered=YES
                    {
                    
                    if(SquadFieldPlayers.getText().contains(playerTemp.getName())) //if player is already assigned to the squad
                       {
                          JOptionPane.showMessageDialog(panel, "The Player is already on the list","Error", JOptionPane.ERROR_MESSAGE); 

                       }
                    else if(playerTemp.getIfSuspended()==true && (typeOfMatchBox.getValue().contains("cup") || typeOfMatchBox.getValue().contains("league"))) //if player is suspended
                       {
                       JOptionPane.showMessageDialog(panel, "The Player is Suspended","Error", JOptionPane.ERROR_MESSAGE);
                     
                       }
                    
                    else if(tempSquad1.isTeamFull()==true) //if squad is already full
                    {
                       tempSquad1.setIsSquadFull(true);  
                       JOptionPane.showMessageDialog(panel, "Too many players","Error", JOptionPane.ERROR_MESSAGE);  
                    }
                    
                    else if(tempSquad1.isTeamFull()==false)//if squad is not full, chosen player from combobox is assigned to either field players
                  System.out.print(tempSquad1.toString());
                     
                       {
                          int counterOfSquadPlayers=tempSquad1.getFieldPlayers();
                          
                       if(tempSquad1.getFieldPlayers()<=10 && tempSquad1.getBenchPlayers()==0)
                          {
                          tempSquad1.addPlayers(playerTemp);                       
                          SquadFieldPlayers.appendText(playerTemp.toString()+"\n");
                          counterOfSquadPlayers++;
                        
                          }
                       else//or to bench players
                      
                          {
                             tempSquad1.addPlayers(playerTemp);
                             SquadBenchPlayers.appendText(playerTemp.toString()+"\n");
                          }
                      }

                   }
              
                }
              }
        }
      
 
        
        
        
      
        
        
        
        
        
        else if(e.getSource() == deleteSquadPlayer) //deletes Players from Squad on EditSquad tab
        {
        
           String temp = addSquadFieldPlayer.getSelectionModel().getSelectedItem();//takes currently picked value of combobox
           Player playerTemp= new Player("tempName",10000001,"tempPosition");//creates temporary Player
           ListOfPlayers players = adapterPlayers.getAllPlayers(); //gets all existing players
           ListOfSquads squads = adapterSquads.getAllSquads();//gets all existing squads
           
      
           
           
         //gets the squad and its current players  
           
           tempSquad1 = squads.getSquad(Integer.parseInt(SquadIndex.getText()));
          
           
          
         
         
             if (temp != null)
              {  
                 int input = JOptionPane.showConfirmDialog(null,"Do you really want to delete player from the squad?","Select", JOptionPane.YES_NO_OPTION);
                 
                 for(int i=0; i<players.size();i++) //checks for all existing players and if there is a name match, assigns it to temporary player
                    {
                    if(players.get(i).getName().equals(addSquadFieldPlayer.getValue()))
                    {
                       playerTemp=players.get(i);
                   
                    }
                    }
                    
                 
              
                 if(input==0) //if confirmation message has been answered=YES
                    {
                       String tempSquadBenchPlayers=SquadBenchPlayers.getText();
                       String tempSquadFieldPlayers=SquadFieldPlayers.getText();
                       
                       if(tempSquadBenchPlayers.contains(playerTemp.getName()))
                      
                          {
                             tempSquad1.deleteSquadFieldPlayers(playerTemp);
                             SquadBenchPlayers.replaceSelection(playerTemp.toString());
                          }
                       else if(tempSquadFieldPlayers.contains(playerTemp.getName()))
                          {
                             tempSquad1.deleteSquadBenchPlayers(playerTemp);
                             SquadBenchPlayers.replaceSelection(playerTemp.toString());
                           
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

