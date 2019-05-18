package Vasek_FirstSemesterProject;

import java.io.Serializable;

public class ViaClub implements Serializable
{
private ListOfPlayers listOfPlayers;
private ListOfSquads listOfSquads;


public ViaClub()
{
   listOfPlayers=new ListOfPlayers();
   listOfSquads=new ListOfSquads();
}

public ListOfPlayers getListOfPlayers()
{
   return listOfPlayers;
}

public ListOfSquads getListOfSquads()
{
   return listOfSquads;
}
}
