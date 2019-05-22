package Vasek_FirstSemesterProject;

import java.io.Serializable;
import java.util.ArrayList;

public class ListOfSquads implements Serializable
{
  
   // another comment
   private ArrayList<Squad> squads;
   
   public ListOfSquads()
   {
      squads=new ArrayList<Squad>();
   }
   
   public Squad getSquad(int index)
   {
      for(int i=0; i<squads.size();i++)
      {
         if(squads.get(i).getIndex()==index)
         {
         return squads.get(i);
         }
      }
      return null;
   }
   
   public ArrayList<Squad> getAllPlayers()
   {
      return squads;
   }
   
   public void addSquad(Squad squad)
   {
      squads.add(squad);
   }
   

   public String toString()
   {
      String squadsList="";
      for(int i=0;i<squads.size();i++)
      {
         squadsList+=squads.get(i);
         squadsList+= "\n";
         
      }
      
      return squadsList;   
   } 
}
