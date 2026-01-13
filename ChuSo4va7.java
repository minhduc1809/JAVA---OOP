import java.util.*;
public class ChuSo4va7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long it = in.nextLong();
        int dem = 0;
        while(it > 0){
            long r = it % 10;
            if( r == 4 || r == 7){
                dem++;
            }
            it = it / 10;
        }
        if(dem == 4 || dem == 7){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        
    }
}
