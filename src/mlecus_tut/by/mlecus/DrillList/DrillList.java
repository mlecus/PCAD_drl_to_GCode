package mlecus_tut.by.mlecus.DrillList;

import mlecus_tut.by.mlecus.Geometry2D.Point2D;

import java.util.ArrayList;

/**
 * Created by mlecus on 02.09.2017.
 */
public class DrillList {
    private Point2D basePoint=new Point2D();
    private double angle=0f;
    private boolean mirrored=false;

    private ArrayList<DrillFrame> drillFrames = new ArrayList<DrillFrame>();

    public DrillList()
    {}
    DrillList (DrillList drillList)
    {
        for (DrillFrame frame:drillList.drillFrames)
        {
            this.drillFrames.add(frame);
        }
    }

    public DrillList(Point2D basePoint, double angle, boolean mirrored) {
        this.basePoint = basePoint;
        this.angle = angle;
        this.mirrored = mirrored;
    }

    public Point2D getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Point2D basePoint) {
        this.basePoint = basePoint;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public boolean isMirrored() {
        return mirrored;
    }

    public void setMirrored(boolean mirrored) {
        this.mirrored = mirrored;
    }

    public void Add(DrillFrame drillFrame)
    {
        this.drillFrames.add(drillFrame);
    }
    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        out.append("Base point ").append(basePoint).append('\n')
           .append("Angle ").append(angle*180/Math.PI).append('\n')
           .append(mirrored?"Mirrored":"Normal").append('\n');
        int index=0;
        for (DrillFrame frame:this.drillFrames)
        {
            out.append("Frame ").append(index++).append('\n');
            out.append(frame).append('\n');
        }
        return out.toString();
    }
}
