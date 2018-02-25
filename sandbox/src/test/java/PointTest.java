import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test

  public void testdistance(){
    Point p1 = new Point(3, 4, 5, 6 );
    Assert.assertEquals(p1.distance(), 1.4142135623730951);


  }
}
