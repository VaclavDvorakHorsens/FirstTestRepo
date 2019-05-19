package Vasek_FirstSemesterProject;

import java.io.Serializable;
import java.util.ArrayList;

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
  public void setIndex(int index)
   {
      this.index=index;  
   }
  public void setDate(String date)
  {
     this.date=date;  
  }
  public void setTime(String time)
  {
     this.time=time;  
  }
  public void setMatchType(String matchType)
  {
     this.matchType=matchType;  
  }
  public void setOpponent(String opponent)
  {
     this.opponent=opponent;  
  }
  public int getIndex()
  {
     return index;
  }
  public String getDate()
  {
     return date;
  }
  public String getTime()
  {
     return time;
  }
  public String getOpponent()
  {
     return opponent;
  }
  public int getFieldPlayers()
  {
     return fieldPlayers;
  }
  public int getBenchPlayers()
  {
     return benchPlayers;
  }
  
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
