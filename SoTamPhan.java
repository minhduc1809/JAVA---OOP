import java.util.*;
public class SoTamPhan {
    static String check(char[] a){
        for (int i = 0; i < a.length; i++){
            if(a[i] != '0' && a[i] != '1' && a[i] != '2'){
                return "NO";
            }
        }
        return "YES";
    }
    public static void main(){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0; i < t; i++){
            String s = in.nextLine();
            System.out.println(check(s.toCharArray()));
        }
    }
}
