import java.util.*;

public class DienTichTamGiac {
    static class Point {
        double x, y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    static double dist(Point a, Point b){
        return Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
    }

    static double area(Point a, Point b, Point c){
        double A = dist(a,b);
        double B = dist(b,c);
        double C = dist(c,a);

        if (A + B <= C || A + C <= B || B + C <= A)
            return -1;

        return 0.25 * Math.sqrt(
                (A+B+C)*(A+B-C)*(A-B+C)*(-A+B+C)
        );
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            Point c = new Point(sc.nextDouble(), sc.nextDouble());

            double s = area(a,b,c);
            if (s < 0)
                System.out.println("INVALID");
            else
                System.out.printf("%.2f%n", s);
        }
    }
}

