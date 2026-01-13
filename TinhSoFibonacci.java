import java.util.*;
public class TinhSoFibonacci {
    public static void main(String[] args) {
        long[] fi = new long[93];
        fi[1]=1;
        fi[2]=1;
        for (int i = 3; i < 93; i++){
            fi[i]=fi[i-1]+fi[i-2];
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int x = in.nextInt();
            System.out.println(fi[x]);
        }
    }
}
