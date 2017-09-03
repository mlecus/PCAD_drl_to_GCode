package mlecus_tut.by.mlecus.Geometry2D;

//abstract class Conformic
//{
//    public abstract void Rotate (/*Point2D point,*/ Point2D center, double angle);
//    public abstract void Move (/*Point2D point,*/ Point2D vector);
//    public abstract void Move (double x, double y);
//    public abstract void MirrorX(/*Point2D point*/);
//    public abstract void MirrorY(/*Point2D point*/);
//    public abstract void Mirror(/*Point2D point,*/ Vector axe);
//}
public class Point2D /*extends*/implements IConformicTransformation {
        /*final int X=0;
        final int Y=1;
        final int Z=2;*/
    private double _x, _y;


    public Point2D(double x, double y)
    {
        this._x =x;
        this._y =y;
    }
    public Point2D (Point2D point)
    {
        this._x =point._x;
        this._y =point._y;
    }
    public Point2D()
    {
        this._x=0f;
        this._y=0f;
    }
    double x()
    {
        return _x;
    }
    double y()
    {
        return _y;
    }
    void x(double x)
    {
        this._x=x;
    }
    void y(double y)
    {
        this._y=y;
    }

    @Override
    public /*Point2D*/ void Rotate(Point2D center, double angle) {
        //System.out.println("Point rotate");
        Point2D result =new Point2D();
        Point2D temp= new Point2D(this);
        temp.Move(-center.x(),-center.y());
        /*result.x( ((this.x()-center.x())*Math.cos(angle)-(this.y()-center.y())*Math.sin(angle)));
        result.y( ((this.x()-center.x())*Math.sin(angle)+(this.y()-center.y())*Math.cos(angle)));*/
        result.x( (temp.x()*Math.cos(angle)-temp.y()*Math.sin(angle)));
        result.y( (temp.x()*Math.sin(angle)+temp.y()*Math.cos(angle)));
        result.Move(center);
        this.x(result.x());
        this.y(result.y());
        //return result;
    }
    @Override
    public void /*Point2D*/ Move (Point2D vector)
    {
        Point2D result =new Point2D();
        /*result.x*/ this.x(this.x()+vector.x());
        /*result.y*/ this.y(this.y()+vector.y());
        //return result;
    }

    @Override
    public void Move(double x, double y) {
        this.x(this.x()+x);
        this.y(this.y()+y);
    }

    @Override
    public void /*Point2D*/  MirrorX() {
        this.y(-this.y());
        //return point;
    }

    @Override
    public void /*Point2D*/ MirrorY() {
        this.x(-this.x());
        //return point;
    }

    @Override
    public /*Point2D*/ void Mirror(Vector axe) {
        //System.out.println("==Mirror==");
        //System.out.println("axe px="+axe.px()+" py="+axe.py()+" R="+ axe.R());
        Point2D NormalAxeVector=new Point2D(axe.px()/axe.R(), axe.py()/axe.R());
        //System.out.println("Normal axe px="+NormalAxeVector.x()+" py="+NormalAxeVector.y());
        Vector fromFirstVectorPointToTargetPoint =new Vector(axe.p1(),this);

        double scalarproduct= fromFirstVectorPointToTargetPoint.px()*NormalAxeVector.x()+ fromFirstVectorPointToTargetPoint.py()*NormalAxeVector.y();
        Point2D temp =new Point2D();
        temp.x(axe.p1().x() + (scalarproduct * NormalAxeVector.x()));
        temp.y(axe.p1().y() + (scalarproduct * NormalAxeVector.y()));

        this.Rotate(temp,Math.PI);
        //this.x(result.x());
        //this.y(result.y());
        //System.out.println("/==Mirror==/");
        //return point;
    }
    @Override
    //public String toString(){return "x="+_x+" y="+_y;}
    //public String toString(){return "("+_x+","+_y+") ";}
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        out.append("(").append(_x).append(",").append(_y).append(") ");
        return out.toString();}
}
