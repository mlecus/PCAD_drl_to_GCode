package mlecus_tut.by.mlecus.DrillToolList;

/**
 * Created by mlecus on 02.09.2017.
 */
public class DrillTool {
    private String toolName;
    private double drillDiam=0f;

    public double getDrillDiam() {
        return drillDiam;
    }

    public void setDrillDiam(double drillDiam) {
        this.drillDiam = drillDiam;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }
}
