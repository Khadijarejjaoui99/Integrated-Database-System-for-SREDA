package Users;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Person {
    
    private String name;
    private String Email;
    private String Password;
    private String Weight;
    private int ID;
    private String Dob;
    private String BG;
    
    public Person() {}
    
    public void setDetails(String e,String p,String n,String dob,String w, String bg) throws IOException
    {
        name = n;
        Email = e;
        Password = p;
        Dob = dob;
        Weight = w;
        BG = bg;
        
        Random rand = new Random();
        ID=rand.nextInt(100000);
        
        File file = new File ("Users.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bf = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bf);
        
        pw.println(Email);
        pw.println(Password);
        pw.println(ID);
        pw.close();
        fw.close();
        
        file = new File(Integer.toString(ID)+".txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        fw = new FileWriter(file);
        bf = new BufferedWriter(fw);
        pw = new PrintWriter(bf);
        
        pw.println(Email);
        pw.println(Password);
        pw.println(Integer.toString(ID));
        pw.println(name);
        pw.println(Dob);
        pw.println(Weight);
        pw.println(BG);
        pw.close();
        fw.close();
    }
    
}
