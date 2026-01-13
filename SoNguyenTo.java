import java.util.Scanner;
public class SoNguyenTo {
      static boolean check(int a){
         if(a<2){
            return false;
         }
         for(int i=2;i*i<a;i++){
            if(a%i==0){
                return false;
            }
         }
         return true;
      }
      public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
           int a = in.nextInt();
           if(check(a)){
             System.out.println("YES");
           }
           else{
             System.out.println("NO");
           }
        }
      }    
}
