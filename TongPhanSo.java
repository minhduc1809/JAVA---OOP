import java.util.*;
public class TongPhanSo {
    static class PhanSo {
        private long a;
        private long b;
        PhanSo (long a, long b){
            this.a = a;
            this.b = b;
        }
        static long gcd(long a,long b){
            while(b != 0){
                long r = a%b;
                a=b;
                b=r;
            }
            return a;
        }
        public static PhanSo Tong(PhanSo x, PhanSo y){
            long ts = x.a*y.b+y.a*x.b;
            long ms = y.b*x.b;
            long g = gcd(ts,ms);
            PhanSo t = new PhanSo(ts/g,ms/g);
            return t; 
        }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        PhanSo a = new PhanSo(in.nextLong(), in.nextLong());
        PhanSo b = new PhanSo(in.nextLong(), in.nextLong());
        PhanSo res = PhanSo.Tong(a,b);
        System.out.printf("%d/%d",res.a,res.b);
    }
}
