package application;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *  A class  with ArrayList ListOfSquads representing a List of Squads
 * @author Vaclav Dvorak
 * @version 1.0
 */

public class ListOfSquads implements Serializable
{
  
   private ArrayList<Squad> squads;
   
   
   /**
    *  no-argument constructor initializing ArrayList ListOfSquads of type Squad
    * @author Vaclav Dvorak
    * @version 1.0
    */
   public ListOfSquads()
   {
      squads=new ArrayList<Squad>();
   }
   
   
   /**
    * returns specific Squad based on index
    * @param receives integer index 
    * @return based on which returns Squad from ArrayList squads of type Squad 
    * @author Vaclav Dvorak
    * @version 1.0
    */
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
   
      
      /**
       * returns all squads
       * @return all squads in ArrayList squads of type Squad
       * @author Vaclav Dvorak
       * @version 1.0
       */
      public ArrayList<Squad> getAllSquads()
      {
         return squads;
      }
      
      
      
      /**
       * adds Squad to ArrayList squads
       * @param receives Squad squad to add to the ArrayList
       * @author Vaclav Dvorak
       * @version 1.0
       */
      public void addSquad(Squad squad)
      {
         squads.add(squad);
      }
      

      
      /**
       * returns a string representation of ListOfSquads
       * @return content of Squad's ArrayList squads
       * @return whole content of ArrayList squads (all existing squads) in a String
       * @author Vaclav Dvorak
       * @version 1.0
       */
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
