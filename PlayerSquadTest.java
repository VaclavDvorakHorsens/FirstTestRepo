package Vasek_FirstSemesterProject;

public class PlayerSquadTest
{

   public static void main(String[] args)
   {
      Player player1 = new Player("vasek dvorak", 1, "center");
      Player player2 = new Player("michal dvorak", 2, "goalkeeper");
      Player player3 = new Player("tomas dvorak", 2, "forward");
      /* ListOfPlayers listOfPlayers1 = new ListOfPlayers();
      listOfPlayers1.addPlayer(player1);
      listOfPlayers1.addPlayer(player2);
      listOfPlayers1.addPlayer(player3);*/
      
      
      Squad squad1 = new Squad(1,"1.1.2000","12:01","cup","Slavia");
      squad1.addPlayers(player1);
      squad1.addPlayers(player2);
      System.out.println(squad1.toString());
      
   }

}
