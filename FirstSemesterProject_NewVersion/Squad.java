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
   private boolean isSquadFull;
   private ArrayList<Player> players;
   
   
   /**
    * Five-argument constructor + 2 integer attributes fieldPlayers and benchPlayers
    * +empty ArrayList players (list of players) 
    * @param integer index sets the Squads's number
    * @param String date sets the date of match when the Squad is supposed to play
    * @param String time sets the time of match when the Squad is supposed to play
    * @param String matchType sets type of match
    * @param String opponent sets opponent of Squad
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public Squad(int index, String date, String time, String matchType, String opponent, 
         int fieldPlayers,int benchPlayers)
   {
      this.index=index;
      this.date=date;
      this.time=time;
      this.matchType=matchType;
      this.opponent=opponent;
      this.fieldPlayers=fieldPlayers;
      this.benchPlayers=benchPlayers;
      this.isSquadFull=false;
      players=new ArrayList<Player>(); 
   }
   
   
   /**
    * adds Player to ArrayList and adds one to total number of fieldPlayers or benchPlayers 
    * based on matchType and if the team player limit has been fulfilled, then sets isSquadFull=true
    * @param Player player
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public void addPlayers(Player player)
   {
      if(fieldPlayers!=11 && fieldPlayers<=11)
      {
         players.add(player);
         fieldPlayers++;

      }
      else if(matchType.equals("league") && benchPlayers<=4)
      {
         players.add(player);
         benchPlayers++;

      }
      else if(matchType.equals("cup") && benchPlayers<=5)
      {
         players.add(player);
         benchPlayers++;
     
      }
      else if(matchType.equals("friendly") && benchPlayers<=11)
      {
         players.add(player);
         benchPlayers++;
     
      }  
      else 
         {
         isSquadFull=true;
         }
   }
   
   
   /**
    * Checks if the Squad's does not exceed specific number of players and sets Squad's 
    * isSquadFull attribute appropriately; 
    * @return boolean 
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public boolean isTeamFull()
   {
      if(matchType.equals("league") && benchPlayers<=3)
      {
        
         return false;
       
      }
     
      else if(matchType.equals("cup") && benchPlayers<=4)
      {
     
         return false;
      }
     
      else if(matchType.equals("friendly") && benchPlayers<=10)
      {
         return false;
      }
          
       else 
      {
        return true;
      }
     }
   
   /**
    * Checks if the Squad's does not exceed specific number of players
    * @return boolean 
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public void setIndex(int index)
   {
      this.index=index;  
   }
   
   
   
   /**
    * sets the Squad's isSquadFull attribute
    * @param boolean 
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public void setIsSquadFull(boolean isSquadFull)
   {
      this.isSquadFull=isSquadFull;  
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
      * Sets the Squad's ArrayList players of type Player.
      * @param ArrayList players
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public void setSquad(ArrayList<Player> players)
     {
        this.players=players;  
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
      * Gets the Squad's matchType
      * @return String matchType representing matchType of the Squad
      * @author Vaclav Dvorak
      * @version 1.0
      */
     public String getMatchType()
     {
        return matchType;
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
      * Gets the Squad's players in the field
      * @return String squadPlayers in the field, which is ArrayList players of type Player converted into String
      * @author Vaclav Dvorak
      * @version 1.0
      */ 
    public String getSquadFieldPlayerstoString()
     {
       String squadPlayers="";
       
       for(int i=0;i<fieldPlayers;i++)
       {
          squadPlayers+=players.get(i).toString() + "\n";
          System.out.print(squadPlayers);
       }
        return squadPlayers;
        
     }
     
    /**
     * Gets the Squad's players on the bench
     * @return String squadPlayers on the bench, which is ArrayList players of type Player converted into String
     * @author Vaclav Dvorak
     * @version 1.0
     */ 
   public String getSquadBenchPlayerstoString()
    {
      String squadPlayers="";
      
      for(int i=0;i<benchPlayers;i++)
      {
         squadPlayers+=players.get(i).toString() + "\n";
         System.out.print(squadPlayers);
      }
       return squadPlayers;
       
    }
    
    
    /**
     * Gets the Squad's players
     * @return ArrayList squadPlayers of type Player
     * @author Vaclav Dvorak
     * @version 1.0
     */ 
   public ArrayList<Player> getAllSquadPlayers()
    {
      ArrayList<Player> squadPlayers= new ArrayList<Player>();
      for(int i=0;i<players.size();i++)
      {
         squadPlayers.add(players.get(i));
       
      }
       return squadPlayers;
       
    }
    
    
   /**
    * Deletes the Squad's field player
    * @param Player
    * @author Vaclav Dvorak
    * @version 1.0
    */ 
  public void deleteSquadFieldPlayers(Player player)
  {
      players.remove(player);
      fieldPlayers--;
   }
    
  /**
   * Deletes the Squad's bench player
   * @param Player
   * @author Vaclav Dvorak
   * @version 1.0
   */ 
 public void deleteSquadBenchPlayers(Player player)
 {
     players.remove(player);
     benchPlayers--;
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
        String SquadList="Number: "+ index+", Date and Time: " +date+ " " +time+  ", Opponent: " +opponent+ ", MatchType: "+matchType+" "+", FieldPlayers: " +fieldPlayers+ " "+", BenchPlayers: " +benchPlayers+"\n";
    /*    for(int i=0;i<players.size();i++)
        {
           SquadList+=players.get(i).toString();
           SquadList+= "\n";
        }*/
        return SquadList;
     }
  
}
