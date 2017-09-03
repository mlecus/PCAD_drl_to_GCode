package mlecus_tut.by.mlecus.Geometry2D;
/**
 * Created by mlecus on 06.08.2017.
 */
public class Vector implements IConformicTransformation {
    private Point2D p1,p2;
    public Vector(Point2D p2)
    {
        p1 = new Point2D(0f,0f);
        this.p2 = new Point2D(p2);
    }
    public Vector(Point2D p1, Point2D p2)
    {
        this.p1 = new Point2D(p1);
        this.p2 = new Point2D(p2);
    }
    public Vector(Vector vector)
    {
        /*this.p1=vector.p1();
        this.p2=vector.p2();*/
        /*this.p1=new Point2D(vector.p1());
        this.p2=new Point2D(vector.p2());*/
        this.p1=new Point2D(vector.p1);
        this.p2=new Point2D(vector.p2);
    }
    public Vector(double x1, double y1, double x2, double y2)
    {
        p1=new Point2D(x1,y1);
        p2=new Point2D(x2,y2);
    }
    public Vector(double x2, double y2)
    {
        p1=new Point2D(0f,0f);
        p2=new Point2D(x2,y2);
    }
    public Point2D p1()
    {
        return  p1;
    }
    public Point2D p2()
    {
        return p2;
    }
    
    public double px()
    {
        //if (p2==null) return 0;
        //if (p1==null) return 0;
        return (p2.x()-p1.x());
    }
    public double py()
    {
        return (p2.y()-p1.y());
    }
    public double R()
    {
        return  Math.sqrt(Math.pow(px(),2)+Math.pow(py(),2));
    }
    public double Phi()
    {
        double phi=  (Math.atan(py()/px()));
        if (px()<0)
        {
            phi+=Math.PI;
        }
        else if (py()<0)
        {
            phi+=2*Math.PI;
        }
        return (phi*180/Math.PI);
    }
    public double Phi(Vector l)
    {
        return Phi() - l.Phi();
    }
    public double DistanceToPoint(Point2D p0)
    {
        return  (Math.abs(py()*p0.x()-px()*p0.y()+p2.x()*p1.y()-p2.y()*p1.x())/R());
    }

    @Override
    public void Rotate(Point2D center, double angle) {
        p1.Rotate(center,angle);
        p2.Rotate(center,angle);
    }

    @Override
    public void Move(Point2D vector) {
        p1.Move(vector);
        p2.Move(vector);
    }

    @Override
    public void Move(double x, double y) {
        p1.Move(x,y);
        p2.Move(x,y);
    }

    @Override
    public void MirrorX() {
        p1.MirrorX();
        p2.MirrorX();
    }

    @Override
    public void MirrorY() {
        p1.MirrorY();
        p2.MirrorY();
    }

    @Override
    public void Mirror(Vector axe) {
        p1.Mirror(axe);
        p2.Mirror(axe);
    }
    @Override
    //toString()
    public String toString()
    {
        return ("p1.x="+p1.x()+" p1.y="+p1.y()+" p2.x="+p2.x()+" p2.y="+p2.y());
    }
}
