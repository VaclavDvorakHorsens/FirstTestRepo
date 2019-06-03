package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
* Main class starting the GUI.
* @author Vaclav Dvorak
* @version 1.0
*/


public class Main extends Application 
{
    
   /**
    * Loads GUI from Sample.fxml
    * @param primaryStage
    * @author Vaclav Dvorak
    * @version 1.0
    */
	public void start(Stage primaryStage)
	{
		try 
		{
		
		  FXMLLoader loader = new FXMLLoader();
		  loader.setLocation(getClass().getResource("Sample.fxml"));
		   
			Scene scene = new Scene(loader.load(),1000,700);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	
	 /**
    * Starts the program
    * @param args Command line arguments
    * @author Vaclav Dvorak
    * @version 1.0
    */
	
	   public static void main(String[] args) 
	   {
	      launch(args);
	      
	   }

	   
}

