import java.util.*;
public class PhanSo {
    static class pso {
        private long a;
        private long b;
        pso(long a,long b){
            this.a = a;
            this.b = b;
        } 
        static long gcd(long a, long b) {
            while (b != 0) {
                long r = a % b;
                a = b;
                b = r;
            }
            return a;
        }
        public String rutgon( pso x ) {
            long ucln = gcd(x.a,x.b);
            long arg = x.a/ucln;
            long brg = x.b/ucln;
            return (arg) + "/" + (brg);
        }
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        pso x = new pso(in.nextLong(),in.nextLong());
        System.out.printf(x.rutgon(x));
    }
}
