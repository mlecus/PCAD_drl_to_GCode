package mlecus_tut.by.mlecus.ExcellonAnalyser;

import mlecus_tut.by.mlecus.DrillList.DrillFrame;
import mlecus_tut.by.mlecus.DrillList.DrillList;
import mlecus_tut.by.mlecus.DrillToolList.DrillToolMap;
import mlecus_tut.by.mlecus.FileOperetoion.FileOpration;
import mlecus_tut.by.mlecus.Log.ConsoleLogWriter;
import mlecus_tut.by.mlecus.Log.ILogWriter;

import java.io.BufferedReader;

/**
 * Created by mlecus on 12.08.2017.
 */
public class Excellon {
    private BufferedReader fin;
    private boolean metric=true; //false for  inch
    private int digBeforePoint=0;
    private int digAfterPoint=0;
    private FileOpration f;
    private ILogWriter log;
    private String s;
    //private DrillFrame drillFrame;
    //private DrillToolMap drillToolMap;

    public  Excellon (String fileName)
    {
        log= new ConsoleLogWriter();
        log.OpenLog("");
        f=new FileOpration();
        f.Open(fileName);
    }
    private String SkipComments()
    {
        //String s;
        do {
            s = f.Readln();
            if (s == null) return s;
        }
        while (s.charAt(0)==';');
        return s;
    }
    public boolean ParseHeader (DrillToolMap drillToolMap)
    {
        //String s;
        s=SkipComments();
        if (s.compareTo("M48")!=0)
        {
            log.Writeln("begin of header not found");
            return  false;
        }
        log.Writeln(s+"\t//header found at "+f.getIndex());
        s=f.Readln();
        while (s.lastIndexOf(";FILE_FORMAT=")==-1)
        {
            s=f.Readln();
            if (s==null) return false;
        }
        log.Writeln(s+"\t//found decimal point position declaration at "+ f.getIndex());
        try {
            digBeforePoint = Integer.parseInt(s.substring(s.lastIndexOf('=')+1,s.lastIndexOf(':')));
            log.Writeln("\tamount of digts before point is setted to "+digBeforePoint);
            int digAfterPointStartPosition=s.lastIndexOf(':')+1;
            digAfterPoint= Integer.parseInt(s.substring(digAfterPointStartPosition,s.indexOf(' ',digAfterPointStartPosition)));
            log.Writeln("\tamount of digts after point is setted to "+digAfterPoint);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exc)
        {
            log.Writeln("invalid decimal point position declaration");
            //f.Close();
            return false;
        }
        /*catch (IndexOutOfBoundsException exc)
        {
            log.Writeln("invalid decimal point position declaration");
            f.Close();
            return false;
        }*/
        s=SkipComments();
        switch (s.toUpperCase())
        {
            case "METRIC":
                metric=true;
                break;
            case "INCH":
                metric=false;
                break;
            default:
                log.Writeln("the type of measurement system not found");
                return false;
        }
        log.Writeln(s+"\t//the type of measurement system found at "+f.getIndex());
        log.Writeln("\t the type of measurement system is setted to "+ (metric?"METRIC":"INCH"));
        do
        {
            s=SkipComments();
            log.Writeln(s);
            if (s.charAt(0)=='%') break;
            try
            {
                String toolName = s.substring(0, s.indexOf('C'));
                double toolDiam=Double.parseDouble(s.substring(s.indexOf('C')+1));
                drillToolMap.AddTool(toolName,toolDiam);
                log.Writeln("\t"+toolName+" with diameter "+toolDiam+" found at "+f.getIndex());

            }
            catch (NumberFormatException | IndexOutOfBoundsException exc)
            {
                log.Writeln("invalid tool declaration at "+f.getIndex());
                //f.Close();
                return false;
            }

        } while (s.charAt(0)!='%');
        log.Writeln("end of header found at "+f.getIndex());
        return true;
    }

    public boolean ParseDrillFrame (DrillToolMap drillToolMap, DrillFrame df)
    {

        //String s="";
        //DrillFrame df=new DrillFrame();
        df.setDrillDiam(drillToolMap.GetToolDiam(s));
        log.Writeln("\ttool "+s+" frame with tool diameter "+ df.getDrillDiam()+" found at "+f.getIndex());
        double x=0,y=0;
        do
        {
            s=SkipComments();
            log.Writeln(s);
            try
            {
                String tempX="",tempY="";
                if (s.indexOf('X')!=-1)
                {
                    if (s.indexOf('Y')!=-1)
                    {
                        tempX = s.substring(s.indexOf('X') + 1, s.indexOf('Y'));
                        tempY = s.substring(s.indexOf('Y') + 1);
                    }
                    else
                    {
                        tempX = s.substring(s.indexOf('X') + 1);
                    }
                }
                else
                {
                    if (s.indexOf('Y')!=-1)
                    {
                        tempY = s.substring(s.indexOf('Y') + 1);
                    }
                    else
                    {
                        //drillList.Add(df);
                        //break;
                        return true;
                    }

                }
                if (tempX!="")
                    x=Double.parseDouble(tempX)/Math.pow(10,digAfterPoint);
                if (tempY!="")
                    y=Double.parseDouble(tempY)/Math.pow(10,digAfterPoint);
                df.addPoint(x,y);
                log.Writeln("\tpoint ("+Double.toString(x)+","+Double.toString(y)+") found at "+f.getIndex());
            }
            catch (NumberFormatException | IndexOutOfBoundsException exc)
            {
                log.Writeln("invalid coordinate at "+f.getIndex());
                //f.Close();
                return false;
            }

        }while(true);
        //return true;
    }
    public boolean ParseFooter()
    {
        log.Writeln("\tFooter found at "+f.getIndex());
        s = SkipComments();
        log.Writeln(s);
        if (s.compareTo("M30")==0)
        {
            log.Writeln("\tEnd of file found at "+f.getIndex());
            //f.Close();
            log.Writeln("\tPARSING COMPLETED");
            return true;
        }
        log.Writeln("parsing completed without footer at "+f.getIndex());
        //f.Close();
        return false;
        //return true;
    }
    public boolean ParseExcellon(String fileName, DrillList drillList, DrillToolMap drillToolMap)
    {
        if (!ParseHeader(drillToolMap))
        {
            f.Close();
            return  false;
        }

        s = SkipComments();
        do {
            if (s==null)
            {
                log.Writeln("parsing completed without footer at "+f.getIndex());
                f.Close();
                log.CloseLog();
                return false;
            }
            if (s.compareTo("T00")==0)
            {
                boolean exitCode=ParseFooter();
                f.Close();
                return exitCode;
            }
            log.Writeln(s);
            if (drillToolMap.GetToolDiam(s) == -1) {
                log.Writeln("invalid tool name found at " + f.getIndex());
                f.Close();
                log.CloseLog();
                return false;
            }

            DrillFrame df=new DrillFrame();
            if (!ParseDrillFrame(drillToolMap,df))
            {
                f.Close();
                return false;
            };
            drillList.Add(df);

        }while (true);


        //f.Close();
        //return true;
    }



}
