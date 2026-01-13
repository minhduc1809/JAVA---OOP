import java.util.*;
public class sapxepnoibot{
    static void out(int[] a, int n, int step){
        System.out.printf("Buoc %d: ", step);
        for(int i=0;i<n;i++){
            System.out.printf("%d ", a[i]);
        }
        System.out.println("");
    }
    static boolean sorted(int[] a, int n){
        for(int i=0;i<n-1;i++){
            if(a[i]>a[i+1]) return false;
        }
        return true;
    }
    
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                }
            }
            out(a,n,i+1);
            if(sorted(a,n)) break;
        }
        in.close();
    }
}