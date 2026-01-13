import java.util.Scanner;
import java.math.*;
public class Uocsonguyentolonnhat {
    static void ptich(long n){
    long res=0;
    for (long i=2;i*i<=n;i++){
      long count=0;
      while (n%i==0){
        count ++;
        n=n/i;
      }
      if (count>0) res=Math.max(res,i);
      if(i>n)break;
    }
    if(n>1) res=Math.max(res,n);
    System.out.println(res);
    }
  
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    for(int i=1;i<=t;i++){
      long n= sc.nextLong();
      ptich(n);
    }
    sc.close();
  }    
}
