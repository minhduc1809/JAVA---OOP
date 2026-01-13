import java.util.Scanner;
public class GiaiPTBacNhat {
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        float a = x.nextFloat();
        float b = x.nextFloat();
        if(a==0){
            if(b==0){
                System.out.println("VSN");
            }
            else{
                System.out.println("VN");
            }
        }
        else{
            System.out.printf("%.2f",-b/a);
        }
    }
}
