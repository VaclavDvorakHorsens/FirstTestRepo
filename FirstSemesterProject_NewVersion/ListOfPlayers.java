package application;

import java.io.Serializable;
import java.util.ArrayList;



/**
 *  A class with ArrayList ListOfPlayer representing a List of Players
 * @author Vaclav Dvorak
 * @version 1.0
 */

public class ListOfPlayers implements Serializable
{
   
   private ArrayList<Player> players;
   
   
   /**
    *  no-argument constructor initializing ArrayList ListOfPlayers of type Player
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public ListOfPlayers()
   {
      players=new ArrayList<Player>();
   }
   
   
   //WE MIGHT NOT EVEN USE THIS METHOD BELOW IN THE END, CHECK!!!!!
   //WE MIGHT NOT EVEN USE THIS METHOD BELOW IN THE END, CHECK!!!!!
   //WE MIGHT NOT EVEN USE THIS METHOD BELOW IN THE END, CHECK!!!!!
   /**
    * returns specific Player based on Player's attribute Number
    * @param receives integer number
    * @return based on which returns specific Player from ArrayList players
    * @author Vaclav Dvorak
    * @version 1.0
    */
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
   
   
   
   /**
    * returns specific Player based on index
    * @param receives integer index
    * @return based on which returns specific Player from ArrayList players
    * @author Vaclav Dvorak
    * @version 1.0
    */
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
   
   
   /**
    * returns all players
    * @return all players in ArrayList players of type Player
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public ArrayList<Player> getAllPlayers()
   {
      return players;
   }
   
   
   /**
    * adds Player to ArrayList players, if the Player's attribute Number does not exist already
    * @param receives Player player to add to the ArrayList
    * @author Vaclav Dvorak
    * @version 1.0
    */
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
   
   
   /**
    * removes Player from ArrayList players based on Player's attribute name
    * @param receives String name
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public void removePlayer(String playerName)
   {
      for(int i=0;i<players.size();i++)
         {
         if(players.get(i).getName().equals(playerName))
            {
             players.remove(i);  
            }
         }
   }

   /**
    * returns a string representation of ListOfPlayers
    * @return content of Player's ArrayList players
    * @return whole content of ArrayList players (all existing players) in a String
    * @author Vaclav Dvorak
    * @version 1.0
    */
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
   
   
   /**
    * returns a size of ArrayList players
    * @return size of ArrayList players
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public int size()
   {
      return players.size();
   }
    
}

