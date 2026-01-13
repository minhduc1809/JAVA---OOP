import java.util.*;
import java.io.*;
class SP{
    String ma,ten;
    long don;
    SP(String ma,String ten,long don){
        this.ma =ma;
        this.ten=ten;
        this.don=don;
    }
}
public class HoaDon {
    public static void main(String[] args)throws Exception{
        Scanner in = new Scanner(new File("DATA1.in"));
        int n = Integer.parseInt(in.nextLine());
        ArrayList<SP> a = new ArrayList<>();
        while(n-->0){
            String ma = in.nextLine();
            String ten = in.nextLine();
            long don1 = Integer.parseInt(in.nextLine());
            long don2 = Integer.parseInt(in.nextLine());
            a.add(new SP(ma+"1",ten,don1));
            a.add(new SP(ma+"2",ten,don2));
        }
    }
}
