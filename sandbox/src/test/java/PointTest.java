import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test

  public void testdistance() {
    Point p1 = new Point(2, 5);
    Point p2 = new Point(5, 9);
    Assert.assertEquals(p1.distance(p2), 5.0);


  }
}