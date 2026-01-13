import java.util.*;
public class CatDoi {
    static String res(char[] x){
        for(int i = 0; i < x.length; i++){
           if(x[i]=='9'){
            return "INVALID";
           }
        }
        String m = new String(x);
        m=m.replaceFirst("^0+", "");
        if(m == "") return "INVALID";
        else return m;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i = 0; i < t; i++){
            String s = in.nextLine();
            char[] a = s.toCharArray();
            for(int j = 0; j < a.length; j++){
                if (a[j] == '8'){
                    a[j] = '0';
                }
                else if(a[j] == '9'){
                    a[j] = '0';
                }
                else if(a[j] == '0'){
                    a[j] = '0';
                }
                else if(a[j] == '1'){
                    a[j] = '1';
                }
                else{
                    a[j] = '9';
                }
            }
            System.out.println(res(a));
        }
    }
}
