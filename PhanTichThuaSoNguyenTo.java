import java.util.Scanner;
public class PhanTichThuaSoNguyenTo {
      static void ptich(long n,int so){
    String s="Test "+so+":"; 
    for (long i=2;i*i<=n;i++){
      long count=0;
      while (n%i==0){
        count ++;
        n=n/i;
      }
      if (count>0) s+=" "+ i+"("+count+")";
    }
    if(n>1){
      s+=" "+n+"(1)";
    }
      System.out.println(s);
    }
  
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int t=sc.nextInt();
    for(int i=1;i<=t;i++){
      long n= sc.nextLong();
      ptich(n,i);
    }
    sc.close();
  }
}
