package mlecus_tut.by.mlecus.Geometry2D;

/**
 * Created by mlecus on 07.08.2017.
 */
public interface IConformicTransformation {
    public  void Rotate (Point2D center, double angle);
    public  void Move (Point2D vector);
    public  void Move (double x, double y);
    public  void MirrorX();
    public  void MirrorY();
    public  void Mirror(Vector axe);
}
