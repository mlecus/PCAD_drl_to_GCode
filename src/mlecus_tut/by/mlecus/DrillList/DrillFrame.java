package mlecus_tut.by.mlecus.DrillList;

import mlecus_tut.by.mlecus.Geometry2D.IConformicTransformation;
import mlecus_tut.by.mlecus.Geometry2D.Point2D;
import mlecus_tut.by.mlecus.Geometry2D.Vector;

import java.util.ArrayList;

/**
 * Created by mlecus on 12.08.2017.
 */
public class DrillFrame implements IConformicTransformation {

    /*private Point2D basePoint=new Point2D();
    private double drillDiam=0f;
    private double angle=0f;
    private boolean mirrored=false;
    private ArrayList<Point2D> drillPoints = new ArrayList<Point2D>();
    private int index=0;
    public DrillFrame() {

    }

    public DrillFrame(Point2D basePoint, double drillDiam, double angle, boolean mirrored) {
        this.basePoint = basePoint;
        this.drillDiam = drillDiam;
        this.angle = angle;
        this.mirrored = mirrored;
    }

    public DrillFrame(DrillFrame drillFrame) {
        this.basePoint = drillFrame.basePoint;
        this.drillDiam = drillFrame.drillDiam;
        this.angle = drillFrame.angle;
        this.mirrored = drillFrame.mirrored;
        for (Point2D point: drillFrame.drillPoints)
        {
            this.addPoint(point);
        }
    }
    public double getDrillDiam() {
        return drillDiam;
    }
    public void setDrillDiam(double drillDiam) {
        this.drillDiam = drillDiam;
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
    public ArrayList<Point2D> getDrillPoints() {
        return drillPoints;
    }
    public void setDrillPoints(ArrayList<Point2D> drillPoints) {
        this.drillPoints = drillPoints;
    }
    */

    private double drillDiam=0f;
    private ArrayList<Point2D> drillPoints = new ArrayList<Point2D>();
    private int index=0;

    public DrillFrame() {

    }
    public DrillFrame(double drillDiam)
    {
        this.drillDiam=drillDiam;
    }

    public DrillFrame(DrillFrame drillFrame) {
        this.drillDiam = drillFrame.drillDiam;
        for (Point2D point: drillFrame.drillPoints)
        {
            this.addPoint(point);
        }
    }
    public double getDrillDiam() {
        return drillDiam;
    }
    public void setDrillDiam(double drillDiam) {
        this.drillDiam = drillDiam;
    }
    public ArrayList<Point2D> getDrillPoints() {
        return drillPoints;
    }
    public void setDrillPoints(ArrayList<Point2D> drillPoints) {
        this.drillPoints = drillPoints;
    }
/*
    public Point2D getPoint(int index)
    {
        if ((index>=0) && (index< drillPoints.size()))
        {
            return drillPoints.get(index);
        }
        return null;
    }
    public Point2D getNextPoint()
    {
        index++;
        if ((index>=0) && (index< drillPoints.size())) {
            return getPoint(index);
        }
        return null;

    }
    public void ResetIndex()
    {
        index=0;
    }
*/
    public void addPoint(Point2D point)
    {
        drillPoints.add(point);
    }
    public void addPoint(double x, double y)
    {
        Point2D point = new Point2D(x,y);
        drillPoints.add(point);
    }

    @Override
    public void Rotate(Point2D center, double angle) {
        for (Point2D point : drillPoints) {point.Rotate(center,angle);}

    }

    @Override
    public void Move(Point2D vector) {
        for (Point2D point : drillPoints) {point.Move(vector);}
    }

    @Override
    public void Move(double x, double y) {
        for (Point2D point : drillPoints) {point.Move(x,y);}
    }

    @Override
    public void MirrorX() {
        for (Point2D point : drillPoints) {point.MirrorX();}
    }

    @Override
    public void MirrorY() {
        for (Point2D point : drillPoints) {point.MirrorY();}
    }

    @Override
    public void Mirror(Vector axe) {
        for (Point2D point : drillPoints) {point.Mirror(axe);}
    }
    @Override
    public String toString()
    {
        StringBuilder out =new StringBuilder();
        out.append("drillDiam =").append(drillDiam).append('\n');
        for (Point2D point:drillPoints)
        {
            out.append(point).append("\n");
        }
        return out.toString();
    }
}
