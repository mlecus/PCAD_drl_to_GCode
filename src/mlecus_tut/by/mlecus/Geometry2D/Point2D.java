package mlecus_tut.by.mlecus.Geometry2D;

public class Point2D /*extends*/implements IConformicTransformation {
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
        Point2D result =new Point2D();
        Point2D temp= new Point2D(this);
        temp.Move(-center.x(),-center.y());
        result.x( (temp.x()*Math.cos(angle)-temp.y()*Math.sin(angle)));
        result.y( (temp.x()*Math.sin(angle)+temp.y()*Math.cos(angle)));
        result.Move(center);
        this.x(result.x());
        this.y(result.y());
    }
    @Override
    public void Move (Point2D vector)
    {
        Point2D result =new Point2D();
         this.x(this.x()+vector.x());
         this.y(this.y()+vector.y());
    }

    @Override
    public void Move(double x, double y) {
        this.x(this.x()+x);
        this.y(this.y()+y);
    }

    @Override
    public void MirrorX() {
        this.y(-this.y());
    }

    @Override
    public void MirrorY() {
        this.x(-this.x());
    }

    @Override
    public void Mirror(Vector axe) {
        Point2D NormalAxeVector=new Point2D(axe.px()/axe.R(), axe.py()/axe.R());
        Vector fromFirstVectorPointToTargetPoint =new Vector(axe.p1(),this);
        double scalarproduct= fromFirstVectorPointToTargetPoint.px()*NormalAxeVector.x()+ fromFirstVectorPointToTargetPoint.py()*NormalAxeVector.y();
        Point2D temp =new Point2D();
        temp.x(axe.p1().x() + (scalarproduct * NormalAxeVector.x()));
        temp.y(axe.p1().y() + (scalarproduct * NormalAxeVector.y()));
        this.Rotate(temp,Math.PI);
    }
    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();
        out.append("(").append(_x).append(",").append(_y).append(") ");
        return out.toString();}
}
