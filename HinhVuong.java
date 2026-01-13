import java.util.*;
public class HinhVuong {
        static int min4(int a,int b,int c,int d){
        return Math.min(Math.min(Math.min(a, b),c),d);
    }
    static int max4(int a,int b,int c,int d){
        return Math.max(Math.max(Math.max(a, b),c),d);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        int f = in.nextInt();
        int g = in.nextInt();
        int h = in.nextInt();
        int minx = min4(a,c,e,g), maxx = max4(a,c,e,g);
        int miny = min4(b,d,f,h), maxy = max4(b,d,f,h);
        int y = Math.max(maxx-minx, maxy-miny);
        System.out.print(y*y);
    }
}
