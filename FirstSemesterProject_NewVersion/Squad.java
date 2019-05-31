package application;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  A class representing a Squad with a index, date and time, matchType, opponent, number of fieldPlayers,
 *  number of benchPlayers and list of players
 * @author Vaclav Dvorak
 * @version 1.0
 */


public class Squad implements Serializable
{
   private int index;
   private String date;
   private String time;
   private String matchType;
   private String opponent;
   private int fieldPlayers;
   private int benchPlayers;
   private ArrayList<Player> players;
   
   
   /**
    * Five-argument constructor + 2 integer attributes fieldPlayers and benchPlayers are set as 0 by default
    * +empty arraylist players (list of players) 
    * @param integer index sets the Squads's number
    * @param String date sets the date of match when the Squad is supposed to play
    * @param String time sets the time of match when the Squad is supposed to play
    * @param String matchType sets type of match
    * @param String opponent sets opponent of Squad
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public Squad(int index, String date, String time, String matchType, String opponent)
   {
      this.index=index;
      this.date=date;
      this.time=time;
      this.matchType=matchType;
      this.opponent=opponent;
      this.fieldPlayers=0;
      this.benchPlayers=0;
      players=new ArrayList<Player>(); 
   }
   
   
   /**
    * adds Player to arraylist and adds one to total number of fieldPlayers or benchPlayers based on matchType 
    * @param Player player
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public void addPlayers(Player player)
   {
      if(matchType.equals("league") && benchPlayers<=4 && fieldPlayers<=11)
      {
         players.add(player);
         fieldPlayers++;
      }
      else if(matchType.equals("league") && benchPlayers<=4)
      {
         players.add(player);
         benchPlayers++;
      }
      else if(matchType.equals("cup") || matchType.equals("friendly") && benchPlayers<=5 && fieldPlayers<=11)
      {
         players.add(player);
         fieldPlayers++;
      }
      else if(matchType.equals("cup") || matchType.equals("friendly") && benchPlayers<=5)
      {
         players.add(player);
         benchPlayers++;
      }  
   }
   
   
   /**
    * Sets the Squad's index.
    * @param integer index representing if the Squad's number
    * @author Vaclav Dvorak
    * @version 1.0
    */
     public void setIndex(int index)
      {
         this.index=index;  
      }
     
     
     /**
      * Sets the Squad's date.
      * @param String date representing date of match when Squad is supposed to play
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public void setDate(String date)
     {
        this.date=date;  
     }
     
     
     /**
      * Sets the Squad's time.
      * @param String time representing time of match when Squad is supposed to play
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public void setTime(String time)
     {
        this.time=time;  
     }
     
     
     /**
      * Sets the Squad's matchType.
      * @param String matchType representing type of match
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public void setMatchType(String matchType)
     {
        this.matchType=matchType;  
     }
     
     
     /**
      * Sets the Squad's opponent.
      * @param String oppponent representing opponent for the Squad
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public void setOpponent(String opponent)
     {
        this.opponent=opponent;  
     }
     
     
     
     
     /**
      * Gets the Squad's index
      * @return Integer index representing Squad's number
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public int getIndex()
     {
        return index;
     }
     
     
     
     /**
      * Gets the Squad's date
      * @return String date representing date of match when Squad is supposed to play
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public String getDate()
     {
        return date;
     }
     
     
     /**
      * Gets the Squad's time
      * @return String time representing time of match when Squad is supposed to play
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public String getTime()
     {
        return time;
     }
     
     
     /**
      * Gets the Squad's opponent
      * @return String oppponent representing opponent for the Squad
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public String getOpponent()
     {
        return opponent;
     }
     
     
     /**
      * Gets the Squad's number of field players
      * @return integer fieldPlayers representing number of field players of the Squad
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public int getFieldPlayers()
     {
        return fieldPlayers;
     }
     
     
     
     /**
      * Gets the Squad's number of bench players
      * @return integer benchPlayers representing number of bench players of the Squad
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public int getBenchPlayers()
     {
        return benchPlayers;
     }
     
     
     
     /**
      * returns a string representation of Squad
      * @return Squad's attributes converted to String: date, time, opponent, matchType, fieldPlayers, benchPlayers
      * @return and players 
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public String toString()
     {
        String SquadList=date+ " " +time+ " " +opponent+ " "+matchType+" "+"FieldPlayers: " +fieldPlayers+ " "+"BenchPlayers: " +benchPlayers+"\n";
        for(int i=0;i<players.size();i++)
        {
           SquadList+=players.get(i).toString();
           SquadList+= "\n";
        }
        return SquadList;
     }
  
}
