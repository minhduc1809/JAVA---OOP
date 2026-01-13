import java.util.*;
public class KiemTraFibonacci {
        public static void main(String[] args) {
        long[] fi = new long[93];
        fi[0]=0;
        fi[1]=1;
        fi[2]=1;
        for (int i = 3; i < 93; i++){
            fi[i]=fi[i-1]+fi[i-2];
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            long x = in.nextLong();
            int check = 0;
            for(int j = 0; j < 93; j++){
               if(x == fi[j]){
                check = 1;
               }
            }
            if(check == 1){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
