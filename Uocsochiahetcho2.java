import java.util.*;
public class Uocsochiahetcho2 {
    static void ptich(long n){
    long cnt=0;
    for (long i=2;i*i<=n;i++){
      long count=0;
      while (n%i==0){
        count ++;
        n=n/i;
      }
      if(i == 2) cnt=count;
      if (count>0 && i != 2 ) cnt*=(count+1);
    }
    if(n>1) cnt*=2;
    if(n==2) cnt=1;
    System.out.println(cnt);
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
