import java.util.*;
public class KhaiBaoLopThiSinh {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        double c = in.nextDouble();
        double d = in.nextDouble();
        double e = in.nextDouble();
        double tong = c+d+e;
        System.out.printf("%s %s %.1f",a,b,tong);
    }
}
