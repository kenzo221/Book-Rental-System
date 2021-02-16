/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Kenzo
 */
public class returnbook extends Books {
    
     @Override
     public void updateBook(String filepaths,String books,String avail)
       {
          
           File f1 = new File(filepaths);
           File f2 = new File("temp.txt");
           String book="";
           String availa= "";
           String price ="";
           try 
           {
               FileWriter fw = new FileWriter("temp.txt",true);
               BufferedWriter bw = new BufferedWriter(fw);
               PrintWriter pw = new PrintWriter(bw);
               a = new Scanner(new File(filepaths));
               a.useDelimiter("[,\n]");
               
               while(a.hasNext())
               {
                   book=a.next();
                   availa=a.next();
                   price=a.next();
                   if(book.equals(books))
                           {
                               pw.println(books+","+avail+","+price);
                                       
                           }
                   else
                   {
                       pw.println(book+","+availa+","+price);
                   }
               }
               a.close();
               pw.flush();
               pw.close();
               f1.delete();
               File dump = new File(filepaths);
               f2.renameTo(dump);
               
           }
           catch (Exception e)
                   {
                       System.out.println("Error");
                   }
       }
    public void removeRecord(String filepath,String removeTerm,String removeBook)
{
 
  File f1 = new File(filepath);
  File f2 = new File("tempfile.txt");
  String name = "";
  String book = "";
  String date = "";
  try 
           {
               FileWriter fw = new FileWriter("tempfile.txt",true);
               BufferedWriter bw = new BufferedWriter(fw);
               PrintWriter pw = new PrintWriter(bw);
               x = new Scanner(new File(filepath));
               x.useDelimiter("[,\n]");
               
               while(x.hasNext())
               {
                   name=x.next();
                   book=x.next();
                   date=x.next();
                   if( !name.equals(removeTerm) || !book.equals(removeBook))
                   {
                               pw.println(name + "," + book + ","+date);
                            
                   }
                   else {
                    
                       
                       
                       JOptionPane.showMessageDialog(null,"Book Returned Successfully","Book returned", JOptionPane.INFORMATION_MESSAGE);
                   }
                    
               }
               x.close();
               pw.flush();
               pw.close();
               f1.delete();
               File dump = new File(filepath);
               f2.renameTo(dump);
               
           }
           
          catch (Exception e)
                   {
                       System.out.println("Error");
                   }
}
}
