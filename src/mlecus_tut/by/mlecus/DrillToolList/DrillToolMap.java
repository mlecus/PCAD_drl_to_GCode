package mlecus_tut.by.mlecus.DrillToolList;

import java.util.HashMap;

/**
 * Created by mlecus on 02.09.2017.
 */
public class DrillToolMap {
    private HashMap<String,Double> DrillTools = new HashMap<String, Double>(0);
    //private int index=0;
    public  DrillToolMap()
    {

    }
    DrillToolMap(DrillToolMap drillTools)
    {
        this.DrillTools.putAll(drillTools.DrillTools);
    }
    public void AddTool(String toolName, double toolDiam)
    {
        this.DrillTools.put(toolName,(Double) toolDiam);
    }
    public double GetToolDiam(String toolName)
    {
        if (this.DrillTools.get(toolName)!=null)
        {
            return this.DrillTools.get(toolName);
        }
        return -1;
    }
}
