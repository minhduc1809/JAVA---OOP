import java.util.*;
public class KhaiBaoLopSinhVien{
    static String chuanhoa(String d){
        String[] a = d.split("/");
        for(int i=0; i<a.length; i++){
            if(a[i].length()<2) a[i] = "0" + a[i];
        }
        return a[0] + "/" + a[1] + "/" + a[2];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("B20DCCN001 %s %s %s %.2f", sc.nextLine(), sc.nextLine(), chuanhoa(sc.nextLine()), sc.nextFloat());
    }
}