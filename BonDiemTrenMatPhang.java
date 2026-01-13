import java.util.*;
public class BonDiemTrenMatPhang {
    static class Point3D{
        long x,y,z;
        Point3D(long x, long y, long z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
        static boolean check(Point3D a, Point3D b, Point3D c, Point3D d){
            long abx = b.x-a.x;
            long aby = b.y-a.y;
            long abz = b.z-a.z;
            long acx = c.x-a.x;
            long acy = c.y-a.y;
            long acz = c.z-a.z;
            long adx = d.x-a.x;
            long ady = d.y-a.y;
            long adz = d.z-a.z;
            Point3D abc = new Point3D(aby*acz - abz*acy, abz*acx - abx*acz, abx*acy - aby*acx);
            long res = abc.x*adx + abc.y*ady + abc.z*adz;
            return res == 0 ? true : false;
        }
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        if(Point3D.check(p1,p2,p3,p4)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        }
    }
}
