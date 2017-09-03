package mlecus_tut.by.mlecus.FileOperetoion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mlecus on 02.09.2017.
 */
public class FileOpration {
    private BufferedReader file;
    private int index; //current string number
    public  FileOpration()
    {

    }
    public void Open(String Filename)
    {
        //try(BufferedReader f = new BufferedReader(new FileReader(Filename)))
        try
        {
            BufferedReader f = new BufferedReader(new FileReader(Filename));
            file=f;
            /*String temp;
            while ((temp=fin.readLine())!=null)
            {
                System.out.println(temp);
            }*/
        }
        catch (IOException exc)
        {
            System.out.println(exc);
            return;
        }
    }
    public String Readln()
    {
        try
        {
            String str;
            //if ((str=file.readLine())!= null)
            str=file.readLine();
            index++;
            {
                return str;
            }
        }
        catch (IOException exc)
        {  System.out.println(exc);
            return null;
        }
    //return null;
    }
    public void Writeln(String str)
    {

    }
    public void Close()
    {
        try {
            file.close();
        }
        catch (IOException exc)
        {  System.out.println(exc);
        }
    }

    public int getIndex() {
        return index;
    }
}
