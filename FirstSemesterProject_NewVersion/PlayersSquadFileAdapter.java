package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * adapter class, that calls creating/editing methods on squads and players and saves them changed
 * @author Vaclav Dvorak
 * @version 1.0
 */

public class PlayersSquadFileAdapter
{
   private MyFileIO mfio;
   private String fileName;
   
   
   /**
    * constructor accepting file name and path
    * @param receives name(and path)
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public PlayersSquadFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
   
   
   /**
    * Sends ListOfPlayers into object of MyFileIO class (which eventually ends with saving the ListOfPlayers)
    * @return returns players (object including arraylist with players)
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public ListOfPlayers getAllPlayers()
   {
      ListOfPlayers players = new ListOfPlayers();

      try
      {
         players = (ListOfPlayers)mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
         e.printStackTrace();
      }
      return players;
   }

   
   /**
    * Sends ListOfSquads into object of MyFileIO class (which eventually ends with saving the ListOfSquads)
    * @return returns squads (object including arraylist with squads)
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public ListOfSquads getAllSquads()
   {
      ListOfSquads squads = new ListOfSquads();

      try
      {
         squads = (ListOfSquads)mfio.readObjectFromFile(fileName);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error reading file");
      }
      catch (ClassNotFoundException e)
      {
         System.out.println("Class Not Found");
         e.printStackTrace();
      }
      return squads;
   }
   
   
   /**
    * Sends ListOfPlayers into object of MyFileIO class (which eventually ends with saving the ListOfPlayers)
    * @param receives players (object including ArrayList with players)
    * @author Alejandra Leticia
    * @version 1.0
    */
   public void savePlayers(ListOfPlayers players)
   {
      try
      {
         mfio.writeToFile(fileName, players);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
   }
   
   
   /**
    * Sends ListOfSquadsinto object of MyFileIO class (which eventually ends with saving the ListOfSquads)
    * @param receives players (object including ArrayList with squads)
    * @author Ramanpreet Singh
    * @version 1.0
    */
   public void saveSquads(ListOfSquads squads)
   {
      try
      {
         mfio.writeToFile(fileName, squads);
      }
      catch (FileNotFoundException e)
      {
         System.out.println("File not found");
      }
      catch (IOException e)
      {
         System.out.println("IO Error writing to file");
      }
      System.out.print(squads.toString());
   }
 
   
   
   /**
    * compares Player's attribute Number in ListOfPlayers and if there is some other Player
    * with the same number then return this information
    * @param receives Player's Number and Name
    * @param returns False, if there is no other player with the same number and returns
    * @param True, if there is already a Player with the same Number
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public boolean comparePlayerNumber(String playerNumber, String playerName)
   {
      ListOfPlayers players = getAllPlayers();
     
      for (int i = 0; i < players.size(); i++)    
      { 
         Player player = players.get(i);
         int plNumber = Integer.parseInt(playerNumber);
         if(player.getName().equals(playerName) && player.getNumber()==plNumber)
         {
           return false;
         }
         else if(player.getNumber()==plNumber)
         {
            return true;
         }
      } 
      return false;
   }
   
   
   /**
    * changes Player's attributes in ListOfPlayers and then saves the new attributes
    * @param receives Player's: Name, Number, Position, if Player is injured
    * @param if Player is suspended and for how many days
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public void changePlayer(String playerName, String playerNumber, String playerPosition, boolean ifInjured, boolean ifIsSuspended, String ForHowManyDays)
   {
      ListOfPlayers players = getAllPlayers();

      for (int i = 0; i < players.size(); i++)
      {
         Player player = players.get(i);
         int intPlayerNumber = Integer.parseInt(playerNumber);
         int forHowManyDays = Integer.parseInt(ForHowManyDays);
        
         
         if(player.getName().equals(playerName))
         {
            player.setNumber(intPlayerNumber);
            player.setPosition(playerPosition);
            player.setIfInjured(ifInjured);
            player.setIfSuspended(ifIsSuspended);
            player.setSuspendedForMatches(forHowManyDays);
         }  
      }
      savePlayers(players);
   }
 
   
   /**
    * changes Squad's attributes based on it's SquadIndex
    * @param receives Squad's: String SquadIndex, String SquadDate, String SquadTime, String SquadOpponent, String SquadMatchType
    * @author Ramanpreet Singh
    * @version 1.0
    */
   
   public void changeSquads(String SquadIndex, String SquadDate, String SquadTime, String SquadOpponent, String SquadMatchType)
   {
      ListOfSquads squads = getAllSquads();

      for (int i = 0; i < squads.size(); i++)
      {
         Squad squad = squads.get(i);
         int intSquadIndex = Integer.parseInt(SquadIndex);
         
        
         
         if(squad.getIndex()==intSquadIndex)
         {
            squad.setDate(SquadDate);
            squad.setTime(SquadTime);
            squad.setOpponent(SquadOpponent);
            squad.setMatchType(SquadMatchType);
         }  
      }
      saveSquads(squads);
   }
   
   /**
    * compares Player's attribute Number in ListOfPlayers and if there is some other Player
    * with the same number then return this information
    * @param receives Player's Number and Name
    * @param returns False, if there is no other player with the same number and returns
    * @param True, if there is already a Player with the same Number
    * @author Jose Alejandro
    * @version 1.0
    */
   public boolean compareSquadNumber(String createSqMatchIndex)
   {
      ListOfSquads squads = getAllSquads();
     
      for (int i=0; i<squads.size();i++)    
      { 
         Squad squad = squads.get(i);
         int sqNumber = Integer.parseInt(createSqMatchIndex);
         if(squad.getIndex()==sqNumber)
         {
           return true;
         }
         else
         {
            return false;
         }
      } 
      return false;
   }
   
   
   
   
   /**
    * deletes Player in ListOfPlayers and then saves ListOfPlayers without the deleted Player
    * @param receives Player's Name based on which search for all the Players and removes the 
    * @param player when there is a match  
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public void deletePlayer(String playerName)
   {
      ListOfPlayers players = getAllPlayers();

      for (int i = 0; i < players.size(); i++)
      {
         Player player = players.get(i);
        
         if (player.getName().equals(playerName))
         {
            players.removePlayer(playerName);;   
         }     
      }
      savePlayers(players);
   }
   
   
   /**
    * creates a new Player in ListOfPlayers and then saves ListOfPlayers
    * @param receives Player's: Name, Number, Position 
    * @author Alejandra Leticia
    * @version 1.0
    */
   public void createNewPlayer(String createPlName, String createPlNumber, String createPlPosition)
   {
      ListOfPlayers players = getAllPlayers();
      int intPlayerNumber = Integer.parseInt(createPlNumber);
      
      Player newPlayer = new Player(createPlName, intPlayerNumber, createPlPosition);
      players.addPlayer(newPlayer);
      savePlayers(players);
   }

   
   
   /**
    * creates a new Player in ListOfPlayers and then saves ListOfPlayers
    * @param receives Player's: Name, Number, Position 
    * @author Jose Alejandro
    * @version 1.0
    */
   public void createNewSquad(String createSqMatchDate, String createSqmatchTime, String createSqMatchOpponent, String createSqMatchIndex,String createSqTypeMatch, int fieldPlayers, int benchPlayers, ArrayList<Player> squadPlayers)
   {
      ListOfSquads squads = getAllSquads();
      int intSquadindex = Integer.parseInt(createSqMatchIndex);
      
      Squad newSquad = new Squad(intSquadindex, createSqMatchDate, createSqmatchTime,createSqTypeMatch,createSqMatchOpponent,fieldPlayers,benchPlayers);
      newSquad.setSquad(squadPlayers);
      squads.addSquad(newSquad);
      saveSquads(squads);
   }
   
   
   
}
