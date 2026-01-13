import java.util.*;
public class SoKhongLienKe {
    static String check(char[] a){
          int Sum = a[0]-48;
          for(int i = 1; i < a.length; i++){
            if(Math.abs((int) a[i] - (int) a[i-1]) != 2){
               return "NO";
            }
            Sum += (int) a[i]-48;
          }
          if(Sum % 10 != 0) return "NO";
          return "YES";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int it = in.nextInt();
        for(int i = 0; i < it; i++){
           Long x = in.nextLong();
           String s = String.valueOf(x);
           System.out.println(check(s.toCharArray()));
        }
    }
}

