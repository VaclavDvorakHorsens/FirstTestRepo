package Vasek_FirstSemesterProject;

import java.io.Serializable;
import java.util.ArrayList;

public class ListOfPlayers implements Serializable
{
   
   // test comment to see if git works
   
   private ArrayList<Player> players;
   
   public ListOfPlayers()
   {
      players=new ArrayList<Player>();
   }
   
   public Player getPlayer(int number)
   {
      for(int i=0; i<players.size();i++)
      {
         if(players.get(i).getNumber()==number)
         {
         return players.get(i);
         }
      }
      return null;
   }
   
   public Player get(int index)
   {
      if(index<players.size())
      {
         return players.get(index);
      }
      else
      {
         return null;
      }
   }
   
   
   
   public ArrayList<Player> getAllPlayers()
   {
      return players;
   }
   
   public void addPlayer(Player player)
   {
      int counter=0;
      for(int i=0; i<players.size();i++)
         {
            if(players.get(i).numberEquals(player)==true)
            {
            counter++;
            }
         }
      if(counter==0)
      {
         players.add(player);
      }
   }
   
   public void removePlayer(int number)
   {
      for(int i=0;i<players.size();i++)
         {
         if(players.get(i).getNumber()==number)
            {
             players.remove(i);  
            }
         }
   }

   public String toString()
   {
      String playersList="";
      for(int i=0;i<players.size();i++)
      {
         playersList+=players.get(i);
         playersList+= "\n";
         
      }
      
      return playersList;   
   }   
   
   public int size()
   {
      return players.size();
   }
}
