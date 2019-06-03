package application;

import java.io.Serializable;

/**
 * A class representing a Player with a name, number, position, index of ifSuspended, index of ifInjured
 * and number of suspended matches
 * @author Vaclav Dvorak
 * @version 1.0
 */

public class Player implements Serializable
{
  
private String name;
private int number;
private String position;
private boolean ifSuspended;
private int suspendedForMatches;
private boolean ifInjured;


/**
 * Three-argument constructor + 2 booleans attributes ifSuspended and ifInjured are set as false by default
 * and integer suspendedForMatches is set as null by default
 * @param String name sets the Player's whole name
 * @param integer number sets the Player's number
 * @param String position sets the Player's position
 * @author Vaclav Dvorak
 * @version 1.0
 */
public Player(String name, int number, String position)
   {
      this.name=name;
      this.number=number;
      this.position=position;
      ifSuspended=false;
      ifInjured=false;
   }


/**
 * Sets the Player's name
 * @param String name sets the Player's name
 * @author Vaclav Dvorak
 * @version 1.0
 */
public void setName(String name)
{
   this.name=name;
}



/**
 * Sets the Player's number
 * @param String position sets the Player's position
 * @author Vaclav Dvorak
 * @version 1.0
 */
public void setNumber(int number)
{
   this.number=number;
}


/**
 * Sets the Player's position
 * @param String position sets the Player's position
 * @author Vaclav Dvorak
 * @version 1.0
 */
public void setPosition(String position)
{
   this.position=position;
}


/**
 * Sets the Player's index of being suspended or not.
 * @param boolean ifSuspended sets if the Players is suspended or not
 * @author Vaclav Dvorak
 * @version 1.0
 */
public void setIfSuspended(boolean ifSuspended)
{
   this.ifSuspended=ifSuspended;
}


/**
 * Sets the Player's number of days he is suspended for
 * @param integer suspendedForMatches sets the Player's number of days he is suspended for
 * @author Vaclav Dvorak
 * @version 1.0
 */
public void setSuspendedForMatches(int suspendedForMatches)
{
   this.suspendedForMatches=suspendedForMatches;
}



/**
 * Sets the Player's index of being injured or not.
 * @param boolean ifInjured representing if the Player's is injured or not
 * @author Vaclav Dvorak
 * @version 1.0
 */
public void setIfInjured(boolean ifInjured)
{
   this.ifInjured=ifInjured;
}


/**
 * Gets the Players's name
 * @return String name representing Player's name
 * @author Vaclav Dvorak
 * @version 1.0
 */
public String getName()
{
   return name;
}


/**
 * Gets the Players's number
 * @return Integer number representing Player's number
 * @author Vaclav Dvorak
 * @version 1.0
 */
public int getNumber()
{
   return number;
}




/**
 * Gets the Players's position
 * @return String position representing Player's position
 * @author Vaclav Dvorak
 * @version 1.0
 */
public String getPosition()
{
   return position;
}



/**
 * Gets the Players's index of being suspended or not.
 * @return boolean ifSuspended representing if Player is suspended
 * @author Vaclav Dvorak
 * @version 1.0
 */
public boolean getIfSuspended()
{
   return ifSuspended;
}



/**
 * Gets the Players's number of matches which the Player is suspended for
 * @return integer suspendedForMatches representing number of matches which the Player is suspended for
 * @author Vaclav Dvorak
 * @version 1.0
 */
public int getSuspendedForMatches()
{
   return suspendedForMatches;
}



/**
 * Gets the Players's index of being injured or not.
 * @return boolean ifInjured representing if Player is injured
 * @author Vaclav Dvorak
 * @version 1.0
 */
public boolean getIfInjured()
{
   return ifInjured;
}


/**
 * returns if Players's number already exists
 * @param receives object of type Player
 * @return boolean if another Player already has the number
 * @author Vaclav Dvorak
 * @version 1.0
 */
public boolean numberEquals(Object obj)
{
   if(!(obj instanceof Player))
      {
       return false;  
      }
   Player other =(Player)obj;
   if(other.getNumber()==number)
   {
      return true;
   }
   return false;
}


/**
 * returns a string representation of Player
 * @return all Player's attributes converted to String: name, number, position
 * @return ifSuspended, suspendedForMatches, ifInjured
 * @author Vaclav Dvorak
 * @version 1.0
 */
public String toString()
{
   return "Name:" +name + ", " +"Number: " + number + ",  "+ "Position: " + position+",  "+"Suspended: "+ " " + ifSuspended + ", "+"ForHowManyMatches: " + suspendedForMatches + ",  "+"Injured: " + ifInjured+"\n";
}




}
