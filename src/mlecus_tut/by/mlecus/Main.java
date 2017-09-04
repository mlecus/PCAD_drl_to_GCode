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
         Excellon excellon=new Excellon("data/TEST.DRL");
        //Excellon excellon=new Excellon("data/NTC-15-01-13_MAINBOARD_V1.2.DRL");
        DrillList drillList=new DrillList();
        DrillToolMap drillToolMap=new DrillToolMap();
        //System.out.println(excellon.ParseExcellon("TEST.DRL",drillFrame));
        excellon.ParseExcellon(drillList,drillToolMap);
        //System.out.println(drillList);
    }
}
