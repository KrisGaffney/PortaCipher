package ie.gmit.dip;

import java.io.*;



public class ReadFile {
 
 private String path;
 FileReader fr;  
 BufferedReader textReader; 
 
 public ReadFile(String file_path){
     path = file_path;
 
     try { 
        fr = new FileReader(path);
        textReader = new BufferedReader(fr);
     }catch(FileNotFoundException fileNotFoundEx){
         
         System.out.println("Error creating Readfile" + fileNotFoundEx.getMessage()); 
     }

     
 }
 
 public String Read() throws IOException{
    
    String line;
    String textData = ""; 
    while ((line = textReader.readLine()) != null) {
        textData += line + " ";
    }
   
    textReader.close();
    return textData;
    }
   
}
