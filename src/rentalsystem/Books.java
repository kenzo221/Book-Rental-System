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
public class Books {

    
   String title;
  String availability;
   String price;
   String filepath;
   String custName;
   Scanner t;
   Scanner x;
   Scanner a;
   public Books() {
    title = "";
    availability= "";
    price="";
    filepath="";
    custName="";
}
   public Books(String a, String b, String c,String d){
       title=a;
       availability=b;
       filepath=c;
       custName=d;
   }
   public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    
    
    public void saveRecord(String name,String books,String now)
    {
        try
        {   
          
            FileWriter fw = new FileWriter("records.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);  
        pw.println(name+","+books+","+now);
        pw.flush();
        pw.close();
            }
            
                
        
        
        catch(Exception e) {
            System.out.println("Error");
        }
       
    }
     public void updateBook(String filepath,String books,String avail)
       {
          
           File f1 = new File(filepath);
           File f2 = new File("temp.txt");
           String book="";
           String availa= "";
           String price ="";
           try 
           {
               FileWriter fw = new FileWriter("temp.txt",true);
               BufferedWriter bw = new BufferedWriter(fw);
               PrintWriter pw = new PrintWriter(bw);
               t = new Scanner(new File(filepath));
               t.useDelimiter("[,\n]");
               
               while(t.hasNext())
               {
                   book=t.next();
                   availa=t.next();
                   price=t.next();
                   if(book.equals(books))
                           {
                               pw.println(books+","+avail+","+price);
                                       
                           }
                   else
                   {
                       pw.println(book+","+availa+","+price);
                   }
               }
               t.close();
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
