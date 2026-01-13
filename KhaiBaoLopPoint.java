import java.util.*;
public class KhaiBaoLopPoint {
    static class Point {
        double x, y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
        public double dist (Point a){
            return Math.sqrt((this.x - a.x)*(this.x - a.x) + (this.y - a.y)*(this.y - a.y));
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
        Point p1 = new Point(sc.nextDouble(), sc.nextDouble());
        Point p2 = new Point(sc.nextDouble(), sc.nextDouble());
        System.out.printf("%.4f", p1.dist(p2));
        }
    }
}
