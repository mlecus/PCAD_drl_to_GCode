package mlecus_tut.by.mlecus;

import mlecus_tut.by.mlecus.DrillList.DrillList;
import mlecus_tut.by.mlecus.DrillToolList.DrillToolMap;
import mlecus_tut.by.mlecus.ExcellonAnalyser.Excellon;

public class Main {

    static public void writeln(Object ob)
    {
        System.out.println(ob);
    }
    public static void main(String[] args) {

        /*DrillFrame drillList= new DrillFrame();
        for (int i=1;i<=10;i++)
        {
            drillList.addPoint(new Point2D(i,i));
        }


        System.out.println(drillList);
        drillList.Mirror(new Vector(new Point2D(-5,5)));
        String tempstr=drillList.toString();
        System.out.println(tempstr);
        try (FileWriter fw = new FileWriter("output.drl"))
        {
            fw.write(tempstr);
        }
        catch (IOException exc)
        {
            System.out.println(exc);
        }
        */
        Excellon excellon=new Excellon();
        DrillList drillList=new DrillList();
        DrillToolMap drillToolMap=new DrillToolMap();
        //System.out.println(excellon.ParseExcellon("TEST.DRL",drillFrame));
        excellon.ParseExcellon("TEST.DRL",drillList,drillToolMap);
        //System.out.println(drillList);






    }
}
