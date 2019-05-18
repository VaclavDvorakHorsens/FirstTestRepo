package Vasek_FirstSemesterProject;

import java.io.Serializable;

public class Player implements Serializable
{
private String name;
private int number;
private String position;
private boolean ifSuspended;
private int suspendedForMatches;
private boolean ifInjured;

public Player(String name, int number, String position)
   {
      this.name=name;
      this.number=number;
      this.position=position;
      ifSuspended=false;
      ifInjured=false;
   }

public void setName(String name)
{
   this.name=name;
}
public void setNumber(int number)
{
   this.number=number;
}
public void setPosition(String position)
{
   this.position=position;
}
public void setIfSuspended(boolean ifSuspended)
{
   this.ifSuspended=ifSuspended;
}
public void setSuspendedForMatches(int suspendedForMatches)
{
   this.suspendedForMatches=suspendedForMatches;
}
public void setIfInjured(boolean ifInjured)
{
   this.ifInjured=ifInjured;
}

public String getName()
{
   return name;
}
public int getNumber()
{
   return number;
}
public String getPosition()
{
   return position;
}
public boolean getIfSuspended()
{
   return ifSuspended;
}
public int getSuspendedForMatches()
{
   return suspendedForMatches;
}
public boolean getIfInjured()
{
   return ifInjured;
}

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

public String toString()
{
   return name + number + position + ifSuspended + suspendedForMatches + ifInjured;
}

}
