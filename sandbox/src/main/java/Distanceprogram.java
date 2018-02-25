public class Distanceprogram {

    public static void main(String[] args) {

        Point p1 = new Point (3,3);
        Point p2 = new Point (5,6);

        System.out.println("Distance beetwen two points is " + distance(p1, p2));


    }

    public static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p2.y - p1.y;
        return  Math.sqrt(dx*dx + dy*dy);





    }
}

