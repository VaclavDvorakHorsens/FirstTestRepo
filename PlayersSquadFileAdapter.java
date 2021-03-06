package Vasek_FirstSemesterProject;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PlayersSquadFileAdapter
{
   private MyFileIO mfio;
   private String fileName;
   
   public PlayersSquadFileAdapter(String fileName)
   {
      mfio = new MyFileIO();
      this.fileName = fileName;
   }
// Use the MyFileIO class to retrieve a PlayerList object with all Players
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
      }
      return players;
   }

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
      }
      return squads;
   }
   
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
 
   
   
   
   public void changePlayer(String playerName, String playerNumber, String playerPosition, boolean ifInjured)
   {
      ListOfPlayers players = getAllPlayers();

      for (int i = 0; i < players.size(); i++)
      {
         Player player = players.get(i);
         int intPlayerNumber = Integer.parseInt(playerNumber);

         if (player.getNumber()==intPlayerNumber)
         {
            player.setName(playerName);
            player.setPosition(playerPosition);
            player.setIfInjured(ifInjured);
         }
      }

      savePlayers(players);
   }

   
}
