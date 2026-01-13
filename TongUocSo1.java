import java.util.Scanner;
public class TongUocSo1 {
    static long ptich(long n){
    long cnt=0;
    for (long i=2;i*i<=n;i++){
      long count=0;
      while (n%i==0){
        count ++;
        n=n/i;
      }
      if (count>0 ) cnt+=i*count;
    }
    if(n>1) cnt+=n;
    return cnt;
    }
  
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    long tong = 0;
    for(int i=1;i<=t;i++){
      long n= sc.nextLong();
      tong+=ptich(n);
    }
    System.out.println(tong);
    sc.close();
  }
}
