package application;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData
{

   public static void main(String[] args)
   {
      ListOfPlayers players = new ListOfPlayers();
      ListOfSquads squads = new ListOfSquads();
      MyTextFileIO mtfioPlayers = new MyTextFileIO();
      MyTextFileIO mtfioSquads = new MyTextFileIO();
      String[] playersArray = null;
      String[] squadsArray = null;
         try
         {
            playersArray=mtfioPlayers.readArrayFromFile("C:\\Vasek\\players.txt");
            for(int i=0;i<playersArray.length;i++)
            {
              String temp = playersArray[i];
              String[] tempArr = temp.split(",");
              String name = tempArr[0];
              int number = Integer.parseInt(tempArr[1]);
              String position = tempArr[2];
              
              players.addPlayer(new Player(name, number, position));
            }
            
            squadsArray=mtfioSquads.readArrayFromFile("C:\\Vasek\\squads.txt");
            for(int i=0;i<squadsArray.length;i++)
            {
              String temp = squadsArray[i];
              String[] tempArr = temp.split(",");
              int index = Integer.parseInt(tempArr[0]);
              String date = tempArr[1];
              String time = tempArr[2];
              String matchType = tempArr[3];
              String opponent = tempArr[4];
              squads.addSquad(new Squad(index, date, time, matchType, opponent));
            }
            
            
         }
         catch (FileNotFoundException e)
         {
            System.out.println(e.getMessage());
         }
         
         MyFileIO mfioPlayers = new MyFileIO();
         MyFileIO mfioSquads = new MyFileIO();
         
         try
         {
            mfioPlayers.writeToFile("C:\\Vasek\\players.bin", players);
            mfioSquads.writeToFile("C:\\Vasek\\squads.bin", squads);
         }
         catch (FileNotFoundException e)
         {
            System.out.println("Error opening file ");
         }
         catch (IOException e)
         {
            System.out.println("IO Error writing to file ");
         }
         
         
         System.out.println("Done");
         

   }

}
