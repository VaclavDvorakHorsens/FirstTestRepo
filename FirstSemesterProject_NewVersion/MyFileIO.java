package application;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * writes and reads data(objects) from/to  squad and player .bin files 
 * @author Vaclav Dvorak
 * @version 1.0
 */


public class MyFileIO
{
   
   
      /**
      * writes given object to a file given by path
      * @param receives String fileName, which specifies file path to write and Object obj, that is supposed to be written to the file
      * @throws IOException in case the writing to the file failed
      * @author Vaclav Dvorak (based on a Allan Henriksen's code)
      * @version 1.0
      */
      public void writeToFile(String fileName, Object obj) throws IOException
      {
         ObjectOutputStream writeToFile = null;
         
         try
         {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            writeToFile = new ObjectOutputStream(fileOutputStream);
            writeToFile.writeObject(obj);
         }
         finally
         {
            if(writeToFile !=null)
            {
               try
               {
                  writeToFile.close();
               }
               catch(IOException e)
               {
                  System.out.println("IO Error closing file " + fileName); 
               }
            }
         }
      }
     

      
      
      /**
       * reads from file by given file given path
       * @param receives String fileName, which specifies file path to read Object obj from
       * @return Object obj from file
       * @throws IOException in case the reading from the file failed
       * @throws ClassNotFoundException in case the end of the file has been reached unexpectedly
       * @throws FileNotFoundException in case the file is not found
       * @author Vaclav Dvorak
       * @version 1.0
       */
      public Object readObjectFromFile(String fileName) throws IOException, FileNotFoundException, ClassNotFoundException
      {
         Object obj = null;
         ObjectInputStream readFromFile=null;
         try
         {
           FileInputStream fileInStream = new FileInputStream(fileName);
           readFromFile = new ObjectInputStream(fileInStream);
           
           try
           {
              obj = readFromFile.readObject();
           }
           catch(EOFException eof)
           {
      
           }
         }
         
         finally
         {
            if(readFromFile != null)
            {
               try
               {
                  readFromFile.close();
               }
               catch (IOException e)
               {
                  System.out.println("IO Error closing file " + fileName);
               }
            }
         }
            return obj;
      }
    

}
