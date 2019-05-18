package Vasek_FirstSemesterProject;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyFileIO
{
      // Writes the given object to a file with the given file name
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
      
   // Writes the objects in the given array to a file with the given file name
      public void writeToFile(String fileName, Object[] objs) throws IOException
      {
         ObjectOutputStream writeToFile = null;
         try
         {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            writeToFile = new ObjectOutputStream(fileOutputStream);
            
            for(int i=0;i<objs.length;i++)
               {
               writeToFile.writeObject(objs[i]);
               }
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
      
      
      // Reads the first object from the file with the given file name and returns it.
      // Whoever calls the method will need to cast it from type Object to its real type
      
      public Object readObjectFromFile(String fileName ) throws IOException, FileNotFoundException, ClassNotFoundException
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
            //Done reading
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
